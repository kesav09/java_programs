package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator {
	public static void main(String[] args){
		String ip = "127.0.0.1";
		final Pattern pattern = Pattern.compile(
		        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
		//^(2[0-5][0-5])|(1\\d\\d)|([1-9]?\\d)\\.){3}(2[0-5][0-5])|(1\\d\\d)|([1-9]?\\d)$
		Matcher matcher = pattern.matcher(ip);
		if (matcher.find()){
			System.out.println(matcher.group());
		}
	}
}
