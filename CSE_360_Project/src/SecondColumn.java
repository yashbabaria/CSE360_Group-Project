import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;


public class SecondColumn {

	private JFrame frmTexteditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondColumn window = new SecondColumn();
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
	public SecondColumn() {
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
		
		JTextPane leftSide = new JTextPane();
		leftSide.setBounds(6, 6, 306, 400);
		frmTexteditor.getContentPane().add(leftSide);
		leftSide.setText("This is 35 strings:0000000000000000");
		
		JTextPane rightSide = new JTextPane();
		rightSide.setBounds(386, 6, 306, 400);
		frmTexteditor.getContentPane().add(rightSide);
		rightSide.setText("This is 35 strings:0000000000000000");
		
		JButton btnSaveAs = new JButton("SAVE AS");
		btnSaveAs.setBounds(290, 418, 117, 29);
		frmTexteditor.getContentPane().add(btnSaveAs);
		
	}
}
