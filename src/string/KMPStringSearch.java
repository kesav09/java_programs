
//the main thing in KMp is it tells where to start when there is a mismatch 
//it creates a pre process partial match table where we can look when there is a mismatch 
//partial match table - tells next start position when there is a mismatch

package string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KMPStringSearch {

	private static List<Integer> partialTable = new ArrayList<Integer>();
	//	static String pattern = "";
	//	static String text = "";
	//
	//	static int [] table = new int[pattern.length()];
	//
	//
	public static void main(String [] args){
		search("ababdbab", "a");
	}
	//
	//
	//	/**
	//	 * Searches for all occurances of the word in the sentence. Runs in O(n+k) where n is the word length and k is the
	//	 * sentence length.
	//	 * 
	//	 * @param word The word that is being searched
	//	 * @param sentence The collections of word over which the search happens.
	//	 * @return The list of starting indices of the matched word in the sentence. Empty list in case of no match.
	//	 */
	//	public static List<Integer> searchString(final String word, final String sentence) {
	//		final List<Integer> matchedIndices = new ArrayList<Integer>();
	//
	//		final int sentenceLength = sentence.length();
	//		final int wordLength = word.length();
	//		int beginMatch = 0; // the starting position in sentence from which the match started
	//		int idxWord = 0; // the index of the character of the word that is being compared to a character in string
	//		final List<Integer> partialTable = createPartialMatchTable(word);
	//		while (beginMatch + idxWord < sentenceLength)
	//			if (word.charAt(idxWord) == sentence.charAt(beginMatch + idxWord)) {
	//				// the characters have matched
	//				if (idxWord == wordLength - 1) {
	//					// the word is complete. we have a match.
	//					matchedIndices.add(beginMatch);
	//					// restart the search
	//					beginMatch = beginMatch + idxWord - partialTable.get(idxWord);
	//					if (partialTable.get(idxWord) > -1) idxWord = partialTable.get(idxWord);
	//					else idxWord = 0;
	//				} else idxWord++;
	//			} else {
	//				// mismatch. restart the search.
	//				beginMatch = beginMatch + idxWord - partialTable.get(idxWord);
	//				if (partialTable.get(idxWord) > -1) idxWord = partialTable.get(idxWord);
	//				else idxWord = 0;
	//			}
	//
	//		return Collections.unmodifiableList(matchedIndices);
	//	}
	//
	//	/**
	//	 * Creates the Partial Match Table for the word. Runs in O(n) where n is the length of the word.
	//	 * 
	//	 * @param word The word whose Partial Match Table is required.
	//	 * @return The table as a list of integers.
	//	 */
	//	public static List<Integer> createPartialMatchTable(final String word) {
	//		//		if (StringUtils.isBlank(word)) return Collections.EMPTY_LIST;
	//
	//		final int length = word.length();
	//		final List<Integer> partialTable = new ArrayList<Integer>(length + 1);
	//		partialTable.add(-1);
	//		partialTable.add(0);
	//
	//		final char firstChar = word.charAt(0);
	//		for (int idx = 1; idx < word.length(); idx++) {
	//			final int prevVal = partialTable.get(idx);
	//			if (prevVal == 0) {
	//				if (word.charAt(idx) == firstChar) 
	//					partialTable.add(1);
	//				else 
	//					partialTable.add(0);
	//			}else if (word.charAt(idx) == word.charAt(prevVal)) {
	//				partialTable.add(prevVal + 1);
	//			}else 
	//				partialTable.add(0);
	//		}
	//		System.out.println(partialTable);
	//		return Collections.unmodifiableList(partialTable);
	//	}

	public static void createPartialMatchTable(String pattern){
		partialTable.add(0);
		if (pattern.length() > 1){
			if(pattern.charAt(1) == pattern.charAt(0))
				partialTable.add(1);
			else
				partialTable.add(0);
			for (int i = 2; i < pattern.length();i++){
				int suffixCounter = 1;
				int prefixCounter = i;
				int j = i;
				int k = i+1;
				while(prefixCounter >= 0 && suffixCounter <= i){
					String prefix = pattern.substring(0, prefixCounter);
					String suffix = pattern.substring(suffixCounter, j+1);
					suffixCounter++;
					prefixCounter--;
					if (prefix.equals(suffix)){
						partialTable.add(prefix.length());
						break;
					}else if (suffixCounter == k)
						partialTable.add(0);

				}
			}
		}
		System.out.println(partialTable);
	}

	public static void search(String text, String pattern){
		if (text.length() == 0 || pattern.length() == 0) return;
		createPartialMatchTable(pattern);
		int partialMatchLength = 0;
		int patternCounter = 0;
		int count = 0;
		for (int i = 0; i <= text.length(); i++){
			
			if (patternCounter == pattern.length()){
				System.out.println("found at index "+(i - patternCounter));
				count++;
				patternCounter = 0;
				partialMatchLength = 0;

				if (text.substring(i).length() < pattern.length()){
					break;
				}
			}

			if (i == text.length())
				break;

			if ((pattern.charAt(patternCounter) == text.charAt(i))){
				partialMatchLength++;
				patternCounter++;
			}else if (!(pattern.charAt(patternCounter) == text.charAt(i)) && partialMatchLength > 1){
				i = i + (partialMatchLength - partialTable.get(partialMatchLength - 1));
			}else{
				patternCounter = 0;
				partialMatchLength = 0;
			}
		}
		System.out.println("count : "+count);
	}
}