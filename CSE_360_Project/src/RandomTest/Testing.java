package RandomTest;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Testing {
	
	public static void main(String[] args) throws IOException{
		String input = (String)JOptionPane.showInputDialog("What is the name of the File?");
		
		
		//System.out.println(s);
		//String input = "testing";
		String fileName = input + ".txt";
		
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()){
			System.out.println(scan.nextLine());
		}

	}
}
