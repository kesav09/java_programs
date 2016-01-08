package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Extract number from a given string
 */
public class ExtractNumber {
	public static void main(String[] args){
		String str = "abcd153xyz124";
		//Pattern pattern = Pattern.compile("^.+(\\d+).+$");
		Pattern pattern = Pattern.compile("-?\\d+");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()){
			System.out.println(str.substring(matcher.start(),matcher.end()));
			System.out.println(matcher.group());
		}
	}

}
