package Project;

import java.io.*;
import java.util.*;
import javax.swing.*;


public class TextFormat {

	public static void main(String[] args) throws IOException
	{
		File file = new File("testing.txt");
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()){
			System.out.println(scan.nextLine());
		}

	}

}
