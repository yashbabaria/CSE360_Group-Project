import java.io.*;

public class ProcessFile {
	private String fileString = "";
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
					this.currentFlags = getFlags(line);
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

	/* Find a way to save the file into a txt when user clicks on save as
	public File saveAs(){
		File savingFile = new File();
	}*/

	// Returns the flags set in a line
	// @param: line, a String of content
	// @return: char[] an array of flags (e.g. { '1', 't' })
	private String getFlags(String flagLine) {
		String flags = "";
		
		int index = 0;
		
		// Read line one char at a time, checking for flags
		while (index < flagLine.length()
			&& flagLine.charAt(index) != '\n') {
			
			if (flagLine.charAt(index) == '-') {
				flags += flagLine.charAt(index+1);
			}
			index++;
			
		}
		
		return flags;
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

		// First line indentation
		if (currentFlags.contains("i")) {
			paragraph = indent(paragraph);
		}

		// Word Spacing
		if (currentFlags.contains("d")) {
			paragraph = doubleSpace(paragraph);
		}

		// Apply Indentation
		if (currentFlags.contains("t")) {
			paragraph = title(paragraph);
		}
		else if (currentFlags.contains("l")) {
			paragraph = left(paragraph);
		}

		return paragraph;
	}

	
	// -t tag: format as title
	private String title(String paragraph){
		return "\t" + paragraph.toUpperCase();
	}

	// -l flag: left-justify the paragraph
	private String left(String paragraph) {
		int index = 0;
		
		/* This should split up the lines into 80 chars
		while (index < paragraph.length()) {
		}
		*/

		return paragraph;
	}

	// -c flag: center-justify the paragraph
	private String center(String paragraph) {
		// ToDo
		return paragraph;

	}

	// -r flag: right-justify the paragraph
	private String right(String paragraph) {
		// ToDo
		return paragraph;
	}
	
	// -e flag: Add an empty line
	private String empty(String paragraph) {
		return "\n" + paragraph;
	}

	// -i flag: Indent first line in paragraph
	private String indent(String paragraph) {
		return "\t" + paragraph;
	}

	// -b flag: Block indent the paragraph
	private String blockIndent(String paragraph) {
		// ToDo
		return paragraph;
	}

	// -n flag: Remove indentation from paragraph
	private String noIndent(String paragraph) {
		// ToDo
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
		// ToDo
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
