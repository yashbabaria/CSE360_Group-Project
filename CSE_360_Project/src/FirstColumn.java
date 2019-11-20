import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FirstColumn {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstColumn window = new FirstColumn();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(6, 6, 600, 204);
		frame.getContentPane().add(textPane);
		textPane.setText("This is 80 characters:0000000000000000000000000000000000000000000000000000000000");
		
		JButton btnSaveAs = new JButton("SAVE AS");
		btnSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Save the text just like the editor
			}
		});
		btnSaveAs.setBounds(240, 243, 117, 29);
		frame.getContentPane().add(btnSaveAs);
	}
}
