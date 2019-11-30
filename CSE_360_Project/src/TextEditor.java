import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class TextEditor extends JFrame {
	
	private String content = "";
	private JFrame initial;
	// Constructor for the text editor when no file chosen
	public TextEditor() {
		window();
	}
	
	// Overload constructor for the text editor
	// @param file, chosen by the user
	public TextEditor(File file) {
		ProcessFile proc = new ProcessFile(file);
		content = proc.returnFile();
		formatContent();
		window();
	}
	
	// Formats the classes content based on the flags
	private void formatContent() {
		String[] lines = content.split("\n");
	}

	// Text Editing window
	private void window() {
		
		// Create Window and set the title to "TextFormat"
		initial = new JFrame("TextFormat");
		initial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initial.setBounds(100, 100, 500, 750);
		
		// Create panel for layout management
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// Create Text Area, and set the text area to the contents of the input file
		JScrollPane scrollPane = new JScrollPane();
		JTextPane textArea = new JTextPane();
		scrollPane.setViewportView(textArea);
		textArea.setText(content);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JButton btnSaveAs = new JButton("Save As...");
		panel.add(btnSaveAs, BorderLayout.PAGE_END);
		
		initial.getContentPane().add(panel);
		initial.pack();
		initial.setVisible(true);
	}
}
