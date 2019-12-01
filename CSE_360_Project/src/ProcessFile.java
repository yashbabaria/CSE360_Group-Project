import java.io.*;

public class ProcessFile {
	private String fileString = "";
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
		while (index < flagLine.length()
			&& flagLine.charAt(index) != '\n') {
			
			if (flagLine.charAt(index) == '-') {
				next = flagLine.charAt(index+1);

				if (next == '1' || next == '2') {
					columnFlag = next;
				}
				else if (next == 'b' || next == 'i' || next == 'n') {
					indentationFlag = next;

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
		// Insert empty line
		if (currentFlags.contains("e")) {
			paragraph = empty(paragraph);
		}
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

		// First line indentation
		if (indentationFlag == 'i') {
			paragraph = indent(paragraph);
		}
		if (indentationFlag == 'b') {
			paragraph = blockIndent(paragraph);
		}

		// Apply text justification
		if (justificationFlag == 'l') {
			paragraph = left(paragraph);
		}
		else if (justificationFlag == 'c') {
			paragraph = center(paragraph);
		}
		else if (justificationFlag == 'r') {
			paragraph = right(paragraph);
		}

		// Test for column flag
		if (columnFlag == '1') {
			paragraph = oneColumn(paragraph);
		}
		else if (columnFlag == '2') {
			paragraph = twoColumn(paragraph);

		}

		return paragraph;
	}

	
	// -t tag: format as title
	private String title(String paragraph){
		return "     " + paragraph.toUpperCase();
	}

	// -l flag: left-justify the paragraph
	private String left(String paragraph) {
		int index = 0;
		int lineIndex = 0;
		
		// Split up the lines into 80 chars
		char current;
		int offset;
		while (index < paragraph.length()) {
			current = paragraph.charAt(index);
			if (current == ' ') {
				offset = findNextSpace(paragraph, index);
				if (offset + lineIndex > 80) {
					paragraph = paragraph.substring(0, index+1)
					+ "\n" + paragraph.substring(index+1, paragraph.length());
					lineIndex = 0;

				}

			}
			lineIndex++;
			index++;
		}

		return paragraph;
	}

	// -c flag: center-justify the paragraph
	private String center(String paragraph) {
		// ToDo
		return paragraph;

	}

	// -r flag: right-justify the paragraph
	private String right(String paragraph) {
		int index = 0;
		int lineIndex = 0;
		
		// Split up the lines into 80 chars
		char current;
		int offset;
		String spaces = "";
		int i;
		int wordSpace = 1;
		if (spacingFlag == 'd') {
			wordSpace = 2;
		}
		while (index < paragraph.length()) {
			current = paragraph.charAt(index);
			if (current == ' ' && index > 80) {
				offset = findNextSpace(paragraph, index);
				if (offset + lineIndex > 80) {
					for (i = 0, spaces = ""; i < offset; i++){
						spaces += " ";
					}
					/*
					paragraph = paragraph.substring(0, index - lineIndex)
					+ spaces + paragraph.substring(index+1, paragraph.length());
					*/
					paragraph = paragraph.substring(0, index) + "\n" + spaces + paragraph.substring(index+wordSpace, paragraph.length());
					lineIndex = 0;

				}

			}
			lineIndex++;
			index++;
		}

		return paragraph;
	}

	// Finds the next occurence of the ' ' character in a line
	// @return: integer representation of the offset from the index
	private int findNextSpace(String paragraph, int index) {
		int offset = 1;
		index++;

		// Account for double spacing flag
		if (spacingFlag == 'd') {
			index++;
			offset++;
		}

		while (index < paragraph.length()) {
			if (paragraph.charAt(index) == ' ') {
				return offset;
			}
			offset++;
			index++;
		}

		return -1;
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
		return "          " + paragraph;
	}

	// -n flag: Remove indentation from paragraph
	private String noIndent(String paragraph) {
		return paragraph;
	}

	// -1 flag: Paragraph is in one column
	private String oneColumn(String paragraph) {
		// ToDo
		return paragraph;
	}

	// -2 flag: Split paragraph into two columns
	private String twoColumn(String paragraph) {
		// ToDo
		return paragraph;
	}

	// -s flag: Single spaces words
	private String singleSpace(String paragraph) {
		int index = 0;
		while (index < paragraph.length()) {
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
