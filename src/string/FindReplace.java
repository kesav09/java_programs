package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://stackoverflow.com/a/14518026
 *
 */
public class FindReplace {
	static String replace2(String s, String target, String replacement) {
		StringBuilder sb = null;
		int start = 0;
		for (int i; (i = s.indexOf(target, start)) != -1;) {
			if (sb == null)
				sb = new StringBuilder();
			sb.append(s, start, i);
			sb.append(replacement);
			start = i + target.length();
		}
		if (sb == null)
			return s;
		sb.append(s, start, s.length());
		return sb.toString();
	}

	static String replace(String s, String target, String replacement) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; (i = sb.indexOf(target, i)) != -1; i += replacement.length()) {
			sb.replace(i, i + target.length(), replacement);
		}
		return sb.toString();
	}
	
	public static void replaceAll(StringBuilder builder, String from, String to)
	{
	    int index = builder.indexOf(from);
	    while (index != -1)
	    {
	        builder.replace(index, index + from.length(), to);
	        index += to.length(); // Move to the end of the replacement
	        index = builder.indexOf(from, index);
	    }
	}

	public static void main(String... ignored) {
		String s1 = "11112233211";
		System.out.println(s1);
		timeReplace(s1);
		timeReplace2(s1);
		timeStringReplaceRefactored(s1);
		timeStringReplace(s1);
	}

	private static void timeReplace(String s1) {
		System.out.println(replace(s1, "11", "xxx"));
	}

	private static void timeReplace2(String s1) {
		System.out.println(replace2(s1, "11", "xxx"));
	}

	private static void timeStringReplace(String s1) {
		System.out.println(s1.replace("11", "xxx"));
	}

	private static void timeStringReplaceRefactored(String s1) {
		Pattern compile = Pattern.compile("11", Pattern.LITERAL);
		String xxx = Matcher.quoteReplacement("xxx");
		System.out.println(compile.matcher(s1).replaceAll(xxx));
	}
}
