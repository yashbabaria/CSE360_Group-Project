import java.io.*;

public class ProcessFile {
	private String fileString = "";
	String currentFlags;
	String supportedFlags = "terlsdibn12";

	// Create string to format the file string
	public ProcessFile(File file){
		try {
			BufferedReader fr = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fr.readLine()) != null) {
				this.fileString += line + "\n";

				// Line is a flag line
				if (line.charAt(0) == '-') {
					this.currentFlags = getFlags(line);
				}
				// Get all lines, until another "flag line" appears
				// Line is a normal content line: apply the formatting
				else {
					formatLine(line);
				}
			}
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
		return line;
	}

	
	// -t
	public void title(){
		
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
