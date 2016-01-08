package string;

import java.util.HashSet;
import java.util.Set;
/*
 * This is the optimized code for string permutations
 * Best solution here http://www.roseindia.net/tutorial/java/core/stringPermutations.html
 */
public class StringPermutations {
	public static int count = 0;
	public static void main(String[] args){
		String str = "abc";
		// FIXME use this as it very simple to understand
		System.out.println("Permutations for "+str+" are "+permutationFinder(str));
		// this is awesome solution but above one is little simple
		// http://www.roseindia.net/tutorial/java/core/stringPermutations.html
		showPattern("",str);
	}

	private static Set<String> permutationFinder(String str) {
		//System.out.println("Count :- "+count++);
		Set<String> perm = new HashSet<String>();
		
		if (str == null || str.length() == 0){
			perm.add("");
			return perm;
		}
		
		char initial = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = permutationFinder(rem);
		
		for (String word:words){
			for (int i = 0 ; i <= word.length(); i++){
				//System.out.println("Count :- "+count++);
				perm.add(charInsert(word,initial,i));
			}
		}
		return perm;
	}

	private static String charInsert(String word, char initial, int i) {
		String first = word.substring(0,i);
		String last = word.substring(i);
		//System.out.println(first + initial + last);
		return first + initial + last;
	}
	
	public static void showPattern(String st, String chars) {
		if (chars.length() <= 1)
			System.out.println(st + chars);
		else
			for (int i = 0; i < chars.length(); i++) {
				try {
					System.out.println("Count :- "+count++);
					String newString = chars.substring(0, i) + chars.substring(i + 1);
					showPattern(st + chars.charAt(i), newString);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
}
