
//eg : i/p abcabcbb o/p abc

package string;


import java.util.HashMap;

public class LongestSubstringWithoutRepetition {

	private static String word = "abbcdb";//dvdf aaca aaabcdebafg abcabcbb
	public static void main(String [] args){
		// This is the optimal
		//System.out.println(lengthOfLongestSubstring(word));
		// this has infinite loop with aaca
		//getLongestSubstringWithoutRep(word);
		//execute(word);
		// FIXME this is optimial whose complexity is O(n)
		System.out.println("Sol "+tempSol(word));
	}
	
	private static String tempSol(String str){
		char[] s = str.toCharArray();
		String max = "";
		String temp = "";
		int startIndex = 0;
		HashMap<Character,Integer> saved = new HashMap<Character,Integer>();
		for (int i = 0; i < str.length(); i++){
			if (saved.containsKey(s[i])){
				temp = str.substring(startIndex,i);
				if (temp.length() > max.length()){
					max = temp;
					temp = "";
				}
				startIndex++;
			} else {
				temp += s[i];
				saved.put(s[i],i);
			}

		}
		temp = str.substring(startIndex,s.length);
		if (temp.length() > max.length()){
			max = temp;
		}
		return max;
	}
	
	
	private static int execute(String str){
		if(str == null || str.trim().isEmpty()){
			System.out.println("Empty String");
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		int index = -1;
		String longest = new String();
		char current = ' ';
		char next = ' ';
		int len = str.length();
		char[] input = str.toCharArray();
		for(int i=0; i< len - 1; i++){
			current = input[i];
			next = input[i+1];
			sb.append(current);
			if(sb.indexOf(String.valueOf(next)) == -1){
				if(index == -1){
					index = i;
				}
				if(i == len - 2){
					sb.append(next);
				}
				continue;
			}else{
				if(index != -1){
					if(longest.length() < sb.length()){
						longest = sb.toString();
					}
					i = str.indexOf(next, index);
					index = i + 1;
				}
				sb.setLength(0);
			}
		}
		if(longest.length() < sb.length()){
			longest = sb.toString();
		}else if (longest.isEmpty()){
			longest = str.substring(0,1);
		}
		System.out.println("Longest String Is : " + longest + " and Length Is : " + longest.length());
		return longest.length();
	}
	
	// This does not work. it just return same string back
	/*private static String getLongestSubstringWithoutRepetition(String word){
		if (word.length() < 1) return null;
		if (word.length() == 1) return word;
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < word.length(); i++){
			if (output.indexOf(String.valueOf(i)) < 0)
				output.append(word.charAt(i));
			else 
				output.setLength(0);
			
		}
		System.out.println(output.toString());
		return output.toString();
	}*/
	
	public static int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
	char[] arr = s.toCharArray();
	int pre = 0;
 
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
	for (int i = 0; i < arr.length; i++) {
		if (!map.containsKey(arr[i])) {
			map.put(arr[i], i);
		} else {
			pre = Math.max(pre, map.size());
			i = map.get(arr[i]);
			map.clear();
		}
	}
 
	return Math.max(pre, map.size());
}
	
	public static int getLongestSubstringWithoutRep(String s){
		if (s == null) return 0;
		else if (s.length() <= 1) return s.length();
		
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		String longest = sb.toString();
		
		for (int i = 1; i < s.length(); i++){
			int index = sb.lastIndexOf(new Character(s.charAt(i)).toString());
			if ( index < 0){
				sb.append(s.charAt(i));
				continue;
			} else if (s.charAt(i-1) != s.charAt(i)){
				sb.setLength(0);
				sb.append(s.charAt(index + 1));
				i = index + 1;
			} 
			if (longest.length() < sb.length()){
				longest = sb.toString();
			}
			
		}
		if (longest.length() < sb.length()){
			longest = sb.toString();
		}
		System.out.println("=="+longest);
		return longest.length();
	}
}
