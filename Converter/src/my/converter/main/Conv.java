package my.converter.main;

public class Conv{
	
	static String[] hexSymbols = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
	
	public String convertToBinary(int number) {

		String binarynumber  = "";

		while(number > 0) {
			int reminder = number % 2;
			binarynumber = String.valueOf(reminder) + binarynumber; 
			number = (number >> 1);	
		}

		return binarynumber; 
	}

	public String convertToHex(int number) {
		String hexnumber  = "";

		while(number > 0) {
			int reminder = number % 16;
			hexnumber = hexSymbols[reminder] + hexnumber; 
			number = (number >> 4);	
		}

		return hexnumber; 
	}

	public String convertToOctan(int number) {
		String octannumber  = "";

		while(number > 0) {
			int reminder = number % 8;
			octannumber = hexSymbols[reminder] + octannumber; 
			number = (number >> 3);	
		}

		return octannumber; 
	}

	public String octanToDecimal(String number) {
		int octValue = Integer.parseInt(number, 8);
		return String.valueOf(octValue);
	}

	public String hexToDecimal(String number) {
		int hexValue = Integer.parseInt(number, 16);
		return String.valueOf(hexValue);
	}

	public String binaryToDecimal(String number) {
		int binaryValue = Integer.parseInt(number, 2);
		return String.valueOf(binaryValue);
	}
}
