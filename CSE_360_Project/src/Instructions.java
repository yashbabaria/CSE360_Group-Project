import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;


public class Instructions {

	private JFrame frame;

	public Instructions() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblFlagInstructions = new JLabel("All Flag Functions");
		lblFlagInstructions.setBounds(161, 6, 115, 16);
		frame.getContentPane().add(lblFlagInstructions);
		
		JLabel lbllLeftJustified = new JLabel("-l: Left Justified");
		lbllLeftJustified.setBounds(6, 53, 102, 16);
		frame.getContentPane().add(lbllLeftJustified);
		
		JLabel lblNewLabel = new JLabel("-r: Right Justified");
		lblNewLabel.setBounds(315, 53, 115, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblcCenterJustified = new JLabel("-c: Center Justified");
		lblcCenterJustified.setBounds(147, 53, 129, 16);
		frame.getContentPane().add(lblcCenterJustified);
		
		JLabel lblNewLabel_1 = new JLabel("-s: Single Spacing");
		lblNewLabel_1.setBounds(6, 167, 115, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbldDoubleSpacing = new JLabel("-d: Double Spacing");
		lbldDoubleSpacing.setBounds(315, 167, 122, 16);
		frame.getContentPane().add(lbldDoubleSpacing);
		
		JLabel lblNewLabel_2 = new JLabel("-i: Indent First Line");
		lblNewLabel_2.setBounds(6, 114, 129, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblbIndentsAll = new JLabel("-b: Indents All Line");
		lblbIndentsAll.setBounds(147, 114, 129, 16);
		frame.getContentPane().add(lblbIndentsAll);
		
		JLabel lblx = new JLabel("-n: Removes all Indents");
		lblx.setBounds(288, 114, 156, 16);
		frame.getContentPane().add(lblx);
		
		JLabel lblNewLabel_3 = new JLabel("-1: One Column");
		lblNewLabel_3.setBounds(6, 229, 102, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lbleEmptyLine = new JLabel("-e: Empty Line");
		lbleEmptyLine.setBounds(161, 167, 92, 16);
		frame.getContentPane().add(lbleEmptyLine);
		
		JLabel lblTwoColumns = new JLabel("-2: Two Columns");
		lblTwoColumns.setBounds(315, 229, 129, 16);
		frame.getContentPane().add(lblTwoColumns);
		
		frame.setVisible(true);
	}
}
