import java.io.*;

public class ProcessFile {
	private String fileString = "";
	String currentFlags = "";
	String supportedFlags = "terlsdibn12";

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
					this.fileString += formatLine(paragraph);
					// Reset paragraph to empty string
					paragraph = "";

					// Print the flag line
					this.fileString += line + "\n";
					// Get the new flags from the line
					this.currentFlags = getFlags(line);
					System.out.println("\nFlags:" + currentFlags);
				}
				// Add normal line
				else {
					paragraph += line + "\n";
				}
			}
			// Apply formatting to the last paragraph
			this.fileString += formatLine(paragraph);

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
	private String formatLine(String line) {
		// Format title line
		if (currentFlags.contains("e")) {
			line = empty(line);
		}
		if (currentFlags.contains("t")) {
			line = title(line);
		}
		else if (currentFlags.contains("l")) {
			line = left(line);
		}
		return line;
	}

	
	// -t tag: format as title
	public String title(String paragraph){
		return "\t" + paragraph;
	}

	// -l flag: left-justify the paragraph
	public String left(String paragraph) {
		int index = 0;
		
		/* This should split up the lines into 80 chars
		while (index < paragraph.length()) {
		}
		*/

		return paragraph;
	}
	
	// -e flag: Add an empty line
	public String empty(String paragraph) {
		return "\n" + paragraph;
	}
	//-r
	//-l
	
	//-s
	//-d
	
	//-i
	//-b
	//-n
	
	//-1
	//-2
	
}
