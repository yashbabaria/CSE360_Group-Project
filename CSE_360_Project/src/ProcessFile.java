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
					this.fileString += line + "\n";
					this.currentFlags = getFlags(line);
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
		while (index < flagLine.length() && flagLine.charAt(index) != '\n') {
			
			if (flagLine.charAt(index) == '-') {
				// Line contains a supported flag
				if (supportedFlags.indexOf(flagLine.charAt(index+1)) != 1) {
					flags += flagLine.charAt(index+1);
				}
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
		if (currentFlags.contains("t")) {
			return title(line);
		}
		else if (currentFlags.contains("l")) {
			return left(line);
		}
		return line;
	}

	
	// Method for formatting a paragraph with the -t tag
	public String title(String paragraph){
		return "\t" + paragraph;
	}

	// Method for formatting a paragraph with the -l tag
	public String left(String paragraph) {
		int index = 0;
		
		/* This should split up the lines into 80 chars
		while (index < paragraph.length()) {
		}
		*/

		return paragraph;
	}
	
	//-e
	public void emptySpace(){
		
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
