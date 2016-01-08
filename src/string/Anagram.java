
//Q: StringToDouble in the next hour (following the end of the interview) and then to email it to the interviewer. This method had to include thorough 
//error checking and a method to test various cases (invalid characters, double too large, ect).

//two strings are anagrams when they contain same characters(not necessarily in the same order) and their length is same

package string;
/**
 * FIXME If ask to find anagram on array of word
 * Then make HashMap<String,List<String>> where key will be sort
 * of the word and keep the actual word in the value list
 * At the end loop through the HashMap to the result
 */
/*
 * Two strings are called anagrams only if char in first string are rearranged to get the second one
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//Below is another problem which be solved in similar manner 
/*Write a program to find common elements between two arrays. - See more at: http://java2novice.com/java-interview-programs/common-elements-in-two-arrays/#sthash.mGcCQEIS.dpuf*/
public class Anagram {

	static String word1 = "aat";
	static String word2 = "cat";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// This will not work if same char is repeated and missing another char instead
		System.out.println(isAnagram(word1, word2));
		
		//FIXME using isAnagram2 seems best optimal
		System.out.println(isAnagram2(word1, word2));
	}

	//time complexity O(n)
	//using hashset
	// FIXME this solution fails when char is occured more than once
	public static boolean isAnagram(String word1, String word2){
		
		if (word1.length() != word2.length()) return false;
		
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < word2.length(); i++)
			set.add(word2.charAt(i));
		
		for (int i = 0; i < word1.length(); i++){
			if (!set.contains(word1.charAt(i))) return false;
		}
		return true;
	}
	
	//time complexity O(n)
	//using hashmap
	public static boolean isAnagram2(String leftString, String rightString){
		
	if (word1.length() != word2.length()) return false;
	
	Map<Character, Integer> occurrencesMap = new HashMap<>();

	  for(int i = 0; i < leftString.length(); i++){
	    char charFromLeft = leftString.charAt(i);
	    int nrOfCharsInLeft = occurrencesMap.containsKey(charFromLeft) ? occurrencesMap.get(charFromLeft) : 0;
	    occurrencesMap.put(charFromLeft, ++nrOfCharsInLeft);
	    char charFromRight = rightString.charAt(i);
	    int nrOfCharsInRight = occurrencesMap.containsKey(charFromRight) ? occurrencesMap.get(charFromRight) : 0;
	    occurrencesMap.put(charFromRight, --nrOfCharsInRight);
	  }

	  for(int occurrencesNr : occurrencesMap.values()){
	    if(occurrencesNr != 0){
	      return false;
	    }
	  }

	  return true;
	}
}
