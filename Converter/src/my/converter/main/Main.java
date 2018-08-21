package my.converter.main;

import java.util.Scanner;

public class Main {

	static String[] hexSymbols = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

	public static void main(String[] args) {
		int number;

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
			
		}
	}

	private static String convertToBinary(int number) {
		
		String binarynumber  = "";
		
		while(number > 0) {
			int reminder = number % 2;
			binarynumber = String.valueOf(reminder) + binarynumber; 
			number = (number >> 1);	
		}
		
		return binarynumber; 
	}
	
	private static String convertToHex(int number) {
		String hexnumber  = "";

		while(number > 0) {
			int reminder = number % 16;
			hexnumber = hexSymbols[reminder] + hexnumber; 
			number = (number >> 4);	
		}

		return hexnumber; 
	}
	
	private static String convertToOctan(int number) {
		String octannumber  = "";

		while(number > 0) {
			int reminder = number % 8;
			octannumber = hexSymbols[reminder] + octannumber; 
			number = (number >> 3);	
		}

		return octannumber; 
	}
	
	private static String octanToDecimal(String number) {
		int octValue = Integer.parseInt(number, 8);
		return String.valueOf(octValue);
	}
	
	private static String hexToDecimal(String number) {
		int hexValue = Integer.parseInt(number, 16);
		return String.valueOf(hexValue);
	}
	
	private static String binaryToDecimal(String number) {
		int binaryValue = Integer.parseInt(number, 2);
		return String.valueOf(binaryValue);
	}
	
	
}
