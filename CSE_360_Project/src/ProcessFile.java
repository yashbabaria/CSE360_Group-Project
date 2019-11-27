import java.io.*;


public class ProcessFile {
	private String fileString = "";
	public ProcessFile(File file){
		try {
			BufferedReader fr = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fr.readLine()) != null) {
				this.fileString += line + "\n";
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
	
	public String printFile(){
		return fileString;
	}
	
	/* Find a way to save the file into a txt when user clicks on save as
	public File saveAs(){
		File savingFile = new File();
	}*/
}
