package string;

import java.util.StringTokenizer;

/*
 * This is optimized code for word reverse and string reverse
 */
public class ReverseString {
	// FIXME this is optimal solution here
	private static String reverseWord(String in) {
		if (in.length() < 2) {
			return in;
		}
		return reverseWord(in.substring(1)) + in.substring(0, 1);
	}

	private static String reverseSentence(String in) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in);
		while (st.hasMoreTokens()) {
			if (sb.length() > 0)
				sb.append(' ');
			sb.append(reverseWord(st.nextToken()));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String sentence = "Hi dog cat";
		String expectedOutput = "iH god tac";
		System.out.println(expectedOutput.equals(reverseSentence(sentence)));
		
		String test = " This  is a test ";

		System.out.println("Orignal String: " + test);

		char[] chars = reverseString(test.toCharArray(), 0, test.toCharArray().length - 1);
		System.out.println(String.valueOf("Reverse string: " + String.valueOf(chars)));
		
		
		chars = reverseStringWordsInPlace(test.toCharArray());
		System.out.println(String.valueOf("Reverse words in place: " + String.valueOf(chars)));
		
		chars = reverseStringWordsInPlace(chars);
		System.out.println(String.valueOf("Reverse only words: " + String.valueOf(chars)));
	}

	/*
	 * There are three types of problems possible with String reverse 1) Reverse
	 * the whole string: Input: This is a test Output: tset a si sihT 2) Reverse
	 * words in place Input: This is a test Output: sihT si a tset 3) Reverse
	 * only the words: Input: This is a test Output: test a is This
	 * 
	 * So for first problem just we need to divide this into smaller problem to
	 * reverse this string Then second one can be done by just reversing the Sub
	 * strings in place Then third one , just a combination of first and two.
	 * Reverse this string, then reverse the words in place.
	 */
	public static char[] reverseStringWordsInPlace(char[] chars) {
		int start = 0;
		for (int i = 0; i < chars.length; i++) {
			if (" ".equals(String.valueOf(chars[i]))) {
				reverseString(chars, start, i - 1);
				start = i + 1;
			}
		}

		reverseString(chars, start, chars.length - 1);

		return chars;
	}

	public static char[] reverseString(char[] chars, int start, int end) {
		if (end < start) {
			return chars;
		}

		if (chars.length == 0 || chars.length == 1) {
			return chars;
		}
		swap(chars, start, end);

		return reverseString(chars, ++start, --end);
	}

	public static char[] swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
		return chars;
	}

	public static String reverseString(String s) {
		if (s == null || "".equals(s)) {
			return "";
		}

		int length = s.length();
		if (s.length() == 1) {
			return s;
		}

		return s.charAt(length - 1) + reverseString(s.substring(1, length - 1))
				+ s.charAt(0);
	}
}
