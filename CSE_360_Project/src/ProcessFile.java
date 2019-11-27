import java.io.*;


public class ProcessFile {
	private String fileString = "";
	// Create string to format the file string
	public ProcessFile(File file){
		try {
			BufferedReader fr = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fr.readLine()) != null) {
				this.fileString += line + "\n";
				/**
				 * if(line.chArt(0) == "-"){
				 * 		whichFlag(line.chArt(1),the next line);
				 * } or something like this
				 */
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
	
	public String printFile(){
		return fileString;
	}
	
	// Find which flag to implement to the next line or strings
	public void whichFlag(char letter, String line){
		
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
