package recursive;


import java.util.ArrayList;
import java.util.List;

public class RecursivePhoneNumberProblem {
	static String[] array = new String[] { "0", "1", "abc", "def", "ghi",
			"jkl","lmno", "pqrs"};


	public static List<String> arrayList = new ArrayList<String>();

	public static void convert(String phoneNumber) {
		convertSubstring(phoneNumber, "");
	}

	private static void convertSubstring(String phoneNumber,
			String convertedLetters) {
		int digit = Integer.parseInt(phoneNumber.substring(0, 1));
		String letters = array[digit];
		String remainingString = phoneNumber.substring(1);

		for (int i = 0; i < letters.length(); ++i) {
			char letter = letters.charAt(i);
			String result = convertedLetters + letter;
			if (remainingString.length() == 0)
				System.out.println(result);
			else
				convertSubstring(remainingString, result);
		}
	}

	public static List<String> create(int n) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		return recursiveFunction2(n, "", arrayList);
	}

	private static void recursiveFunction(int n, String convertedAlphabets) {
		if (n!=0 && (n / 10) >= 0) {
			int unitDigit = n % 10;
			String alphabets = array[unitDigit];

			int restDigits = n / 10;

			for (int i = 0; i < alphabets.length(); i++) {
				char alphabet = alphabets.charAt(i);
				String result = convertedAlphabets + alphabet;
				if (restDigits == 0) {
					arrayList.add(result);
				} else {
					recursiveFunction(restDigits, result);
				}
			}
		}
		
	
	}
	
	private static List<String> recursiveFunction2(int n, String convertedAlphabets, ArrayList<String> arrayList) {
		
		if (n!=0 && (n / 10) >= 0) {
			int unitDigit = n % 10;
			String alphabets = array[unitDigit];

			int restDigits = n / 10;

			for (int i = 0; i < alphabets.length(); i++) {
				char alphabet = alphabets.charAt(i);
				String result = convertedAlphabets + alphabet;
				if (restDigits == 0) {
					arrayList.add(result);
				} else {
					recursiveFunction2(restDigits, result,arrayList);
				}
			}
		}
		return arrayList;
	}
	
	public static int reverseNumber(int number){
		int reverse = 0;
		while(number!=0){
			reverse = reverse * 10 + number % 10;
			number = number / 10;
		}
		return reverse;
	}
	
	
	public static void main(String[] args){
		
		int number = 34;
		arrayList = create(reverseNumber(number));
		
		for(String s: arrayList){
			System.out.println("combo: "+ s);
		}
	}
}
