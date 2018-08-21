package my.converter.main;

import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {


	public static void main(String[] args) {
		
		Window frame = new Window(); // construct Window object
		
		frame.setPreferredSize(new Dimension(300,300));
		frame.setMaximumSize(new Dimension(300,300));
		frame.setMinimumSize(new Dimension(300,300));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/* make sure that we stop the threads in the game operations */
		frame.setResizable(false); /* make sure that we cant resize the window */
		frame.setLocationRelativeTo(null);/* having the window set to the middle */
		frame.setVisible(true);             // ask it to become visible

		
		/*int number;

		Scanner in = new Scanner(System.in);

		System.out.println("Enter a positive integer: ");
		number = in.nextInt();

		if (number < 0) {
			System.out.println("Error: Not a positive integer");
		} else {

			System.out.println("Convert to binary is:");
			System.out.println(convertToBinary(number));
			System.out.println("Converted back to decimal: "+binaryToDecimal(convertToBinary(number)));
			System.out.println("Convert to hex is:");
			System.out.println(convertToHex(number));
			System.out.println("Converted back to decimal: "+hexToDecimal(convertToHex(number)));
			System.out.println("Convet to octan is:");
			System.out.println(convertToOctan(number));
			System.out.println("Converted back to decimal: "+octanToDecimal(convertToOctan(number)));
			
		}*/
	}	
}
