import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class TextEditor extends JFrame {
	
	// Constructor for the text editor when no file chosen
	public TextEditor() {
		window();
	}
	
	// Overload constructor for the text editor
	// @param file, chosen by the user
	public TextEditor(String fileName) {
		processFile(fileName);
		window();
	}

	// Text Editing window
	private void window() {
		
		// Create Window and set the title to "TextFormat"
		JFrame window = new JFrame("TextFormat");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create panel for layout management
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// Create Text Area, and set the text area to the contents of the input file
		JTextPane textArea = new JTextPane();
		textArea.setText("This should be the content of the file, or empty if no file is loaded.");
		
		panel.add(textArea, BorderLayout.PAGE_START);
		
		JButton btnSaveAs = new JButton("Save As...");
		panel.add(btnSaveAs);
		
		window.getContentPane().add(panel);
		window.pack();
		window.setVisible(true);
	}
	
	
	// Method for reading in the text file
	// @param fileName, the name of the plaintext file
	private void processFile(String fileName) {
		
		// ToDo: Add error checking etc.
		try {
			BufferedReader fr = new BufferedReader(new FileReader(fileName));
			String line = fr.readLine();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			e.printStackTrace();
		}
	}
	
	// Method for processing each line from the input file
	// @param line, a line that was read from the file
	private void processLine(String line) {
		
	}

}
