package string;

import java.util.List;
/**
 * FIXME If ask to find anagram on array of word
 * Then make HashMap<String,List<String>> where key will be sort
 * of the word and keep the actual word in the value list
 * At the end loop through the HashMap to the result
 */

/**
 * 
 * Anagram variations:
 * 1. isAnagram - check if given two strings are anagrams or not.
 * 2. printAnagrams/permute - print all possible anagrams for a given string.
 * 3. groupAnagrams - align anagrams next to each other.
 * 
 * 
 * @author abpatil1
 */
public class AnagramVariations {
	public static void main(String[] args) {
		//System.out.println(isAnagram("cat", "tac"));
		//System.out.println(isAnagram("cate", "taci"));
		
		//permute("abh");
		
		//printPermutations("abh".toCharArray(),0);
		char c = 'a';
		int i = c;
		System.out.println(i);
		permute("abh".toCharArray(),0);
		
	}
	
	/**
	 * links: http://karmaandcoding.blogspot.com/2012/02/print-all-anagrams-for-word-from.html
	 * 
	 * Approach 1: Maintain a Map<String,ArrayList<String>> where key would resemble unique sorted key and arraylist would be the list of anagrams for the string. 
	 * Approach 2: Assign prime numbers to each letter from a-z (a=2,b=3,c=5,..) and create hashvalues for all strings in the list of Strings.
	 * Approach 3: (http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/) using trie data structure.
	 * 
	 * 
	 * Approach 1 (detail):We need to develop a key for a given word such that all the words in an anagram set can be represented uniquely.
	 *	one way is to convert the word string to lowecase and sort the words lexicographically.
	 *	example: Tea, Eat, Ate will become: aet.
	 *	Then we can use a HashMap to store the anagram set, with "aet" as key and "Tea, Eat, Ate" as the list of words. 
	 *
	 * The order for this solution is ( O(n^2 log n (sorting n strings with n characters each) + n^2 (hashing n strings) + n (n insertions into hash table) = O(n^2 log n) 
	 * assuming hashing each string is O(n) ).
	 *
	 *
	 *
	 * Approach 2:Another approach could be we can assign each letters from a..z a prime numbers (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, .. so on)
	 *	and then for any word, we can calculate its key as the multiples of all the prime number corresponding to characters in the word.
	 *	say tea = 71*11*2 = 1562
	 *	similarly eat and ate will yeild 1562. Now 1562 is the key in your hashMap and value will be the list of words - "tea, eat, ate";
	 *	a=2, b=3, c=5, d=7, e=11, f=13, g=17, h=19, i=23, j=29, 
	 *	k=31, l=37, m=41, n=43, o=47, p=53, q=59, r=61, s=67, t=71, 
	 *	u=73, v=79, w=83, x=89, y=97, z=101
	 *
	 */
	private static void groupAnagrams(List<String> dictionary){
		
	}
	
	
	private static void printPermutations(char[] cArr, int currentFocus) {
        if(currentFocus == cArr.length-1){
            System.out.println(new String(cArr));
            return;
        }
        printPermutations(cArr, currentFocus+1);
        
        for(int i= currentFocus+1; i< cArr.length;++i){
            if(cArr[i] != cArr[currentFocus]){
                char t = cArr[currentFocus];
                cArr[currentFocus] = cArr[i];
                cArr[i] = t;

                printPermutations(cArr, currentFocus+1);
                
                t = cArr[currentFocus];
                cArr[currentFocus] = cArr[i];
                cArr[i] = t;
            }
        }
    }
	
	public static boolean isAnagram(String string1, String string2) {
		if (string1 == null || string2 == null || (string1.length() != string2.length())) {
			return false;
		}

		char character;
		StringBuilder stringBuilder = new StringBuilder(string2);
		int index;
		for (int i = 0; i < string1.length(); i++) {
			character = string1.charAt(i);
			index = stringBuilder.indexOf(String.valueOf(character));
			if (index < 0) {
				return false;
			}
			stringBuilder.delete(index, index + 1);
		}

		return stringBuilder.toString().isEmpty();
	}
	
	public static void permute(char[] str, int currFoc){
		if(str.length == currFoc) {
			System.out.println(str);
			return;
		}
		permute(str,currFoc + 1);
		
		for(int i=currFoc + 1; i < str.length; i++) {
			if(str[i] != str[currFoc]) {
				//swap
				char temp = str[i];
				str[i] = str[currFoc];
				str[currFoc] = temp;
				
				permute(str,currFoc + 1);
				
				//swap
				temp = str[i];
				str[i] = str[currFoc];
				str[currFoc] = temp;
				
			}
		}
	}
	
	/**
	 * This method is to remove duplicates from permutations
	 * 
	 * we need to call: permutate( sort("Hello World"), 0 );
	 * 
	 * link: http://www.mytechinterviews.com/permutations-of-a-string
	 * @param str
	 * @param index
	 */
	void permutate( char[] str, int index )
	{
	    int i = 0;
	    int lastChar = 0;
	    if( index == str.length )
	    { // We have a permutation so print it
	        System.out.println(str);
	        return;
	    }
	    // Permutate once without any swaps.
	    permutate( str, index + 1 );
	    lastChar = str[index];
	    for( i = index + 1; i < str.length; i++ )
	    {
	        if( lastChar == str[i] ) {
	            continue;
	        } else {
	            lastChar = str[i];
	        }
	       // swap( str[index], str[i] ); // It doesn't matter how you swap.
	        permutate( str, index + 1 );
	        // swap( str[index], str[i] );
	    }
	}
	    
}
