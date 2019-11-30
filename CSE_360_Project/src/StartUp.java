import java.awt.BorderLayout;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class StartUp extends JFrame {
	
	// Calls the constructor
	public static void main(String[] args) {
		new StartUp();
	}
	
	// Generates the start up screen
	public StartUp() {
		
		// Create Window and set the title to "TextFormat"
		JFrame startWindow = new JFrame("TextFormat");
		startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create panel for layout management
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		// Create a non-editable Text Area to the program
		JScrollPane scrollPane = new JScrollPane();
		JTextArea description = new JTextArea();
		description.setEditable(false);
		description.setText("Load an existing file, or create a new file by clicking “Create New File”.\n" + 
				"\n" + "Supported file formats: .txt\n" + 
				"\n" + "Read the User Guide for detailed instructions on how to use the program.");
		description.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Button panel
		JPanel btnPanel = new JPanel();
		
		// Create Buttons
		JButton btnOpen = new JButton("Open existing file");
		// Open file chooser
		btnOpen.addActionListener(e -> {
			String fileReturn = fileChoose();
			description.setText(fileReturn);
		});
		btnPanel.add(btnOpen);
		JButton btnCreate = new JButton("Create new file");
		btnCreate.addActionListener(e -> {
			description.setText("");
			description.setEditable(true);
			new TextEditor();
			//new TestingApp();
		});
		btnPanel.add(btnCreate);
		scrollPane.setViewportView(description);
		// Add elements to the panel
		panel.add(scrollPane, BorderLayout.PAGE_START);
		panel.add(btnPanel, BorderLayout.PAGE_END);
		
		// Add panel to the window
		startWindow.getContentPane().add(panel);
		startWindow.pack();
		startWindow.setVisible(true);
	}
	
	
	// Method for choosing a .txt file
	// @return String with file name if successful, else error message
	public String fileChoose() {
		JFileChooser fc = new JFileChooser("Open existing file");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Plaintext files", "txt");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(this);
		
		// Return name of the file is successful, else "unable to open file"
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			new TextEditor(f);
			return "Uploaded the file: " + fc.getSelectedFile().getName();
		}
		else {
			return "No file selected.";
		}
	}
}