package misc;

public class TestRecursiveProblems {

	static String[] mappedAlphabets = { "0", "1", "abc", "def", "ghi", "jkl", "mnop" };

	public static void main(String[] args) {
		recursiveCall(34, "");
	}

	public static void recursiveCall(Integer phoneNumber, String combination) {
		int digit = phoneNumber % 10;
		int remainingDigits = phoneNumber / 10;

		String alphabets = mappedAlphabets[digit];
		for (int i = 0; i < alphabets.length(); i++) {
			StringBuilder tempCombo = new StringBuilder(combination);
			tempCombo.append(alphabets.charAt(i));
			if (remainingDigits > 0) {
				recursiveCall(remainingDigits, tempCombo.toString());
			} else {
				System.out.println("combo: " + tempCombo.toString());
			}
		}
		return;
	}
}
