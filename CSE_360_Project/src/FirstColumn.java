import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;


public class FirstColumn {

	private JFrame frmTexteditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstColumn window = new FirstColumn();
					window.frmTexteditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstColumn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTexteditor = new JFrame();
		frmTexteditor.setTitle("TextEditor");
		frmTexteditor.setBounds(100, 100, 700, 500);
		frmTexteditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTexteditor.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(6, 6, 686, 400);
		frmTexteditor.getContentPane().add(textPane);
		textPane.setText("This is 80 characters:0000000000000000000000000000000000000000000000000000000000");
		
		JButton btnSaveAs = new JButton("SAVE AS");
		btnSaveAs.setBounds(294, 443, 117, 29);
		frmTexteditor.getContentPane().add(btnSaveAs);
	}
}