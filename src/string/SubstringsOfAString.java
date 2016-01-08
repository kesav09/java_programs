package string;
/**
 * Java program to find substrings of a string :- This program find all substrings of a string and the prints them. For example substrings of "fun" are :- "f", "fu", "fun", "u", "un" and "n". 
 * substring method of String class is used to find substring
 * @author kvenkata
 *
 */
public class SubstringsOfAString {
	public static void main(String[] args){
		String str = "fun";
		for (int i = 0; i < str.length();i++){
			for (int j = 1; i+j <= str.length();j++){
				System.out.println(str.substring(i,i+j));
			}
		}
	}
}
