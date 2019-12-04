import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import javax.swing.*;

public class TextEditor extends JFrame {
	
	private String content = "";
	private JFrame initial;
	private ProcessFile proc;

	// Constructor for the text editor when no file chosen
	public TextEditor() {
		proc = new ProcessFile();
		window();
	}
	
	// Overload constructor for the text editor
	// @param file, chosen by the user
	public TextEditor(File file) {
		proc = new ProcessFile(file);
		this.content = proc.returnFile();
		formattedWindow();
	}

	// Overload constructor for the text editor
	// @param textArea, of an existing TextEditor
	public TextEditor(JTextPane textArea) {
		proc = new ProcessFile();
		proc.updateFile(textArea.getText());
		this.content = proc.returnFile();
		formattedWindow();
	}

	// Text Editing window
	private void window() {
		
		// Create Window and set the title to "TextFormat"
		initial = new JFrame("TextFormat");
		initial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initial.setResizable(false);
		
		// Create panel for layout management
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(700,500));

		// Create Text Area, and set the text area to the contents of the input file
		JScrollPane scrollPane = new JScrollPane();
		JTextPane textArea = new JTextPane();
		scrollPane.setViewportView(textArea);
		textArea.setText(content);
		textArea.setFont(new Font("monospaced", Font.PLAIN, 12));

		panel.add(scrollPane, BorderLayout.CENTER);


		// Button panel
		JPanel btnPanel = new JPanel();
		
		// Create Buttons
		JButton btnFormat = new JButton("Format Text");
		btnFormat.addActionListener(e -> {
			new TextEditor(textArea);
			// formatFile(textArea);
		});
		btnPanel.add(btnFormat);

		JButton btnSaveAs = new JButton("Save As...");
		btnSaveAs.addActionListener(e -> {
			saveToFile(textArea, btnSaveAs);
		});
		btnPanel.add(btnSaveAs);
		panel.add(btnPanel, BorderLayout.PAGE_END);

		
		initial.getContentPane().add(panel);
		initial.pack();
		initial.setVisible(true);
		initial.setLocationRelativeTo(null);
	}

	// Window for showing the formatted text
	private void formattedWindow() {
		
		// Create Window and set the title to "TextFormat"
		initial = new JFrame("TextFormat");
		initial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initial.setResizable(false);
		
		// Create panel for layout management
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(600,500));

		// Create Text Area, and set the text area to the contents of the input file
		JScrollPane scrollPane = new JScrollPane();
		JTextPane textArea = new JTextPane();
		scrollPane.setViewportView(textArea);
		textArea.setText(content);
		textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
		// textArea.setEditable(false);

		panel.add(scrollPane, BorderLayout.CENTER);


		// Button panel
		JPanel btnPanel = new JPanel();
		
		JButton btnSaveAs = new JButton("Save As...");
		btnSaveAs.addActionListener(e -> {
			saveToFile(textArea, btnSaveAs);
		});
		btnPanel.add(btnSaveAs);
		panel.add(btnPanel, BorderLayout.PAGE_END);

		
		initial.getContentPane().add(panel);
		initial.pack();
		initial.setVisible(true);
		initial.setLocationRelativeTo(null);
	}

	// Saves the content of the window to a .txt file
	private void saveToFile(JTextPane textArea, JButton btnSaveAs) {
		JFileChooser fileChooser = new JFileChooser();
		int pressed = fileChooser.showSaveDialog(btnSaveAs);
		if (pressed == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			if (file == null) {
				return;
			}
			if (!file.getName().endsWith(".txt")) {
				file = new File(file.getParentFile(), file.getName() + ".txt");
			}
			try {
				textArea.write(new OutputStreamWriter(new FileOutputStream(file),
							"utf-8"));
				Desktop.getDesktop().open(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
