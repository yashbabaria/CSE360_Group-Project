import java.io.*;

public class ProcessFile {
	private String fileString = "";
	private int lineWidth = 80;
	private char indentationFlag = 'n';
	private char columnFlag = '1';
	private char justificationFlag = 'l';
	private char spacingFlag = 's';
	// Title, empty flag are put in current flags and reset every paragraph
	String currentFlags = "";
	String supportedFlags = "telcrsdibn12";

	// Create string to format the file string
	public ProcessFile(File file){
		try {
			BufferedReader fr = new BufferedReader(new FileReader(file));
			String line = "";
			String paragraph = "";
			while ((line = fr.readLine()) != null) {
				// Process flag file
				if (line.charAt(0) == '-') {
					// Apply the formatting for the previous
					// paragraph
					this.fileString += formatParagraph(paragraph);
					// Reset paragraph to empty string
					paragraph = "";

					// Print the flag line
					this.fileString += line + "\n";
					// Get the new flags from the line
					getFlags(line);
				}
				// Add normal line
				else {
					paragraph += line + "\n";
				}
			}
			// Apply formatting to the last paragraph
			this.fileString += formatParagraph(paragraph);

			fr.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			e.printStackTrace();
		}
	}

	/*
	// Update file on user action
	public void updateFile() {

	}
	/*

	/* Find a way to save the file into a txt when user clicks on save as
	public File saveAs(){
		File savingFile = new File();
	}*/

	// Returns the flags set in a line
	// @param: line, a String of content
	private void getFlags(String flagLine) {
		this.currentFlags = "";
		
		int index = 0;
		char next;
		// Read line one char at a time, checking for flags
		while (index < flagLine.length() - 1
			&& flagLine.charAt(index) != '\n') {
			
			if (flagLine.charAt(index) == '-') {
				next = flagLine.charAt(index+1);

				if (next == '1' || next == '2') {
					columnFlag = next;
					if (next == '2') {
						lineWidth = 35;
					}
					else {
						lineWidth = 80;
					}
				}
				else if (next == 'b' || next == 'i' || next == 'n') {
					indentationFlag = next;
					if (next == 'b') {
						lineWidth = 70;
					}
					else {
						lineWidth = 80;
					}

				}
				else if (next == 's' || next == 'd') {
					spacingFlag = next;
				}
				else if (next == 'l' || next == 'c' || next == 'r') {
					justificationFlag = next;

				}
				else {
					this.currentFlags += next;
				}

			}
			index++;
			
		}
	}

	public String returnFile(){
		return fileString;
	}

	// Applies the current flags to the line
	// Call the other formatting methods from this function
	private String formatParagraph(String paragraph) {
		// Title formatting
		if (currentFlags.contains("t")) {
			paragraph = title(paragraph);
		}

		// Word Spacing
		if (spacingFlag == 'd') {
			paragraph = doubleSpace(paragraph);
		}
		else if (spacingFlag == 's') {
			paragraph = singleSpace(paragraph);
		}

		// Test for column flag
		if (columnFlag == '1') {
			paragraph = oneColumn(paragraph);
		}
		else if (columnFlag == '2') {
			paragraph = twoColumn(paragraph);
		}

		// First line indentation
		if (indentationFlag == 'i') {
			paragraph = indent(paragraph);
		}
		else if (indentationFlag == 'b') {
			paragraph = blockIndent(paragraph);
		}

		// Apply text justification
		if (columnFlag != '2' && justificationFlag == 'l') {
			paragraph = left(paragraph);
		}
		else if (columnFlag != '2' && justificationFlag == 'c') {
			paragraph = center(paragraph);
		}
		else if (columnFlag != '2' && justificationFlag == 'r') {
			paragraph = right(paragraph);
		}


		// Insert empty line
		if (currentFlags.contains("e")) {
			paragraph = empty(paragraph);
		}

		return paragraph;
	}

	
	// -t tag: format as title
	private String title(String paragraph){
		return center(paragraph).toUpperCase();
	}

	// -l flag: left-justify the paragraph
	private String left(String paragraph) {
		int index = 0;
		int lineIndex = 0;
		
		// Split up the lines into 80 chars
		char current;
		int lastSpace = 0;
		while (index < paragraph.length()) {
			current = paragraph.charAt(index);
			if (current == ' ') {
				lastSpace = index;
			}
			if (lineIndex >= lineWidth) {
				paragraph = paragraph.substring(0, lastSpace) + "\n" + paragraph.substring(lastSpace+1, paragraph.length());
				lineIndex = index - lastSpace;

			}
			lineIndex++;
			index++;
		}
		return paragraph;
	}

	// -c flag: center-justify the paragraph
	private String center(String paragraph) {
		int index = 0;
		int lineIndex = 0;
		
		// Split up the lines into 80 chars
		char current;
		String spaces = "";
		int lastSpace = 0;
		while (index < paragraph.length()) {
			current = paragraph.charAt(index);

			if (current == ' ') {
				lastSpace = index;
			}

			if (lineIndex >= lineWidth) {
				spaces = "";
				for (int i = 0; i < index - lastSpace; i++) {
					spaces += " ";
				}
				paragraph = paragraph.substring(0,index-lineIndex) + spaces + paragraph.substring(index-lineIndex, lastSpace) + spaces + "\n" + paragraph.substring(lastSpace+1, paragraph.length());
				index += spaces.length() + 1;
				lineIndex = 0;
			}

			lineIndex++;
			index++;
		}
		for (int i = 0; i < (lineWidth - lineIndex) / 2; i++) {
			spaces += " ";
		}
		paragraph = paragraph.substring(0,index-lineIndex) + spaces + paragraph.substring(index-lineIndex, paragraph.length()); 

		return paragraph;
	}

	// -r flag: right-justify the paragraph
	private String right(String paragraph) {
		int index = 0;
		int lineIndex = 0;
		
		char current;
		String spaces = "";
		int lastSpace = 0;
		while (index < paragraph.length()) {
			current = paragraph.charAt(index);

			if (current == ' ') {
				lastSpace = index;
			}

			if (lineIndex >= lineWidth) {
				spaces = "";
				for (int i = 0; i < index - lastSpace; i++) {
					spaces += " ";
				}
				if (index - lineIndex == 0) {
					paragraph = paragraph.substring(0,index-lineIndex) + spaces + paragraph.substring(index-lineIndex, paragraph.length());
				}
				else {
					paragraph = paragraph.substring(0,index-lineIndex+1) + "\n" + spaces + paragraph.substring(index-lineIndex+1, paragraph.length());
				}
				lineIndex = 0;
			}

			lineIndex++;
			index++;
		}
		for (int i = 0; i < lineWidth - lineIndex; i++) {
			spaces += " ";
		}
		paragraph = paragraph.substring(0,index-lineIndex+1) + "\n" + spaces + paragraph.substring(index-lineIndex+1, paragraph.length());

		return paragraph;
	}
	
	// -e flag: Add an empty line
	private String empty(String paragraph) {
		return "\n" + paragraph;
	}

	// -i flag: Indent first line in paragraph
	private String indent(String paragraph) {
		return "     " + paragraph;
	}

	// -b flag: Block indent the paragraph
	private String blockIndent(String paragraph) {
		// Block indent indents 10 spaces on every line
		int index = 0;
		paragraph = "          " + paragraph;

		char current;
		while (index < paragraph.length()) {
			current = paragraph.charAt(index);
			if (current == '\n') {
				paragraph = paragraph.substring(0, index+1)
					+ "          "
					+ paragraph.substring(index+1, paragraph.length());
				index += 10;
			}
			index++;
		}

		return paragraph;
	}

	// -n flag: Remove indentation from paragraph
	private String noIndent(String paragraph) {
		return paragraph;
	}

	// -1 flag: Paragraph is in one column
	private String oneColumn(String paragraph) {
		return paragraph;
	}

	// -2 flag: Split paragraph into two columns
	private String twoColumn(String paragraph) {
		int index1;
		int index2;
		index1 = paragraph.indexOf(" ", paragraph.length() / 2);
		String column1 = paragraph.substring(0, index1);
		column1 = left(column1);
		String column2 = paragraph.substring(index1, paragraph.length());
		column2 = left(column2);

		paragraph = "";
		index1 = 0;
		index2 = 0;
		int newLine1 = column1.indexOf("\n");
		int newLine2 = column2.indexOf("\n");
		String spaces = "";
		int i = 0;

		while (newLine1 != -1 && newLine2 != -1) {
			for (i = 0, spaces = ""; i + (newLine1 - index1) <= 45; i++) {
				spaces += " ";
			}
			paragraph += column1.substring(index1, newLine1) + spaces
				+ column2.substring(index2, newLine2) + "\n";
			index1 = newLine1 + 1;
			index2 = newLine2 + 1;
			newLine1 = column1.indexOf("\n", newLine1+1);
			newLine2 = column2.indexOf("\n", newLine2+1);
		}

		paragraph += column1.substring(index1, column1.length()) + spaces
			+ column2.substring(index2, column2.length()) + "\n";
		return paragraph;
	}

	// -s flag: Single spaces words
	private String singleSpace(String paragraph) {
		int index = 0;
		while (index < paragraph.length() - 1) {
			if (paragraph.charAt(index) == ' '
				&& paragraph.charAt(index+1) == ' ') {
				paragraph = paragraph.substring(0, index+1)
					+ paragraph.substring(index+1, paragraph.length());
			}
			index++;
		}
		return paragraph;
	}	

	// -d flag: Double spaces words
	private String doubleSpace(String paragraph) {
		int index = 0;
		while (index < paragraph.length()) {
			if (paragraph.charAt(index) == ' ') {
				paragraph = paragraph.substring(0, index) + " "
					+ paragraph.substring(index, paragraph.length());
				index++;
			}
			index++;
		}

		return paragraph;
	}
}
