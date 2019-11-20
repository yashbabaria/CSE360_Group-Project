import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SecondColumn {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondColumn window = new SecondColumn();
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
	public SecondColumn() {
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
		
		JTextPane leftSide = new JTextPane();
		leftSide.setBounds(6, 6, 242, 215);
		frame.getContentPane().add(leftSide);
		leftSide.setText("This is 35 strings:0000000000000000");
		
		JTextPane rightSide = new JTextPane();
		rightSide.setBounds(362, 6, 242, 215);
		frame.getContentPane().add(rightSide);
		rightSide.setText("This is 35 strings:0000000000000000");
		
		JButton btnSaveAs = new JButton("SAVE AS");
		btnSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Save File into a .txt
			}
		});
		btnSaveAs.setBounds(240, 243, 117, 29);
		frame.getContentPane().add(btnSaveAs);
		
	}
}
