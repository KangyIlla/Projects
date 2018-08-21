package my.converter.main;

import java.util.Scanner;

public class Main {

	static String[] hexSymbols = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

	public static void main(String[] args) {
		int number;

		Scanner in = new Scanner(System.in);

		System.out.println("Enter a positive integer: ");
		number = in.nextInt();

		if (number < 0) {
			System.out.println("Error: Not a positive integer");
		} else {

			System.out.print("Convert to binary is:");
			//System.out.print(binaryform(number));
			System.out.println(convertToBinary(number));
		}
	}

	private static String convertToBinary(int number) {
		
		String binarynumber  = " ";
		
		while(number > 0) {
			int reminder = number % 2;
			binarynumber = String.valueOf(reminder) + binarynumber; 
			number = (number >> 1);	
		}
		
		return binarynumber; 
	}
	
	private static String convertToHex(int number) {
		String hexnumber  = " ";

		while(number > 0) {
			int reminder = number % 16;
			hexnumber = String.valueOf(reminder) + hexnumber; 
			number = (number >> 4);	
		}

		return hexnumber; 
	}
}
