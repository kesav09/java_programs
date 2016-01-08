package string;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class generateRandomString {
	
	public static void main(String[] args){
		System.out.println(getRandomString(10));
	}
	/**
	 * Returns a random generated String of length 'randLength'
	 * @param randLength 
	 * @return
	 */
	public static String getRandomString(int randLength)
	{
		Random r = new Random();
		byte[] bytes = new byte[50];
		String randomString = null;
		String result = null;
		while ( null == randomString || null == result || ( null != result &&  result.length() < randLength ))
		{
			r.nextBytes(bytes);
			try {
				randomString = new String(bytes,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			Pattern an = Pattern.compile("[a-z]*[A-Z]*");
			Matcher matcher = an.matcher(randomString);
			StringBuilder buf = new StringBuilder();
			while ( matcher.find() )
			{
				int start = matcher.start();
				int end = matcher.end();
				buf.append(randomString.substring(start, end ));
			}
			result = buf.toString();
		}
		return result;
	}
}
