package string;

public class SumOfString {

	/*
	 * To execute Java, please define "static void main" on a class named Solution.
	 * 
	 * If you need more classes, simply define them inline.
	 * 
	 * "1+2+3" -> 6 "-4+1" -> -3
	 * 
	 * 0-9 + or - binary or unary
	 */

	public static void main(String[] args) {
		System.out.println(getValue("----11+22-3-"));
	}

	/*
	 * "1+2+3" -> 6 "-4+1" -> -3
	 * 
	 * 0-9 + or - binary or unary
	 * 
	 * Character.isDigit
	 * 
	 * array = {0..9} operators = +,-
	 */
	public static int getValue(String string) {
		if(string == null){
			return 0;
		}

		int sum = 0;
		char c;
		
		//if first character is not an operand. take first character as sum.
		if(!(string.charAt(0) == '+') && !(string.charAt(0) == '-')){
			sum = string.charAt(0) - '0';
		}

		for (int i = 0; i < string.length(); i++) {
			c = string.charAt(i);
			if (c == '+' && i + 1 < string.length() && Character.isDigit(string.charAt(i + 1))) {
				sum = sum + (string.charAt(i + 1) - '0');
			} else if (c == '-' && i + 1 < string.length() && Character.isDigit(string.charAt(i + 1))) {
				sum = sum - (string.charAt(i + 1) - '0');
			}
		}
		return sum;
	}

}
