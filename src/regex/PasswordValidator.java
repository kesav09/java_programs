package regex;

import java.util.ArrayList;
import java.util.List;
/*
^				match the beginning of the line
(?=.*[0-9].*[0-9]) 		a look-ahead expression, requires 2 digits to be present
.*				match n characters, where n >= 0
[0-9]				match a digit from 0 to 9
[0-9a-zA-Z]			match any numbers or letters
{8,12}				match 8 to 12 of whatever is specified by the last group
$				match the end of the line
 */
public class PasswordValidator {
	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		input.add("password");
		input.add("p4ssword");
		input.add("p4ssw0rd");
		input.add("p45sword");

		for (String ssn : input) {
			if (ssn.matches("^(?=.*[0-9].*[0-9])[0-9a-zA-Z]{8,12}$")) {
				System.out.println(ssn + ": matches");
			} else {
				System.out.println(ssn + ": does not match");
			}
		}
	}
}
