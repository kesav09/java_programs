package string;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {

	static String word = "aabbddefffgiig";
	
	
	public static void main(String [] args){
		System.out.println(getNonRepeatedChracter(word));
		System.out.println(oddManOut(word.toCharArray()));
		
	}
	
	//using linkedhashmap
	public static Character getNonRepeatedChracter(String word){
		
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for (int i = 0; i < word.length(); i++){
			if (!map.containsKey(word.charAt(i))) 
				map.put(word.charAt(i), 1);
			else if (map.containsKey(word.charAt(i)))
				map.put(word.charAt(i), (map.get(word.charAt(i)) + 1));
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return null;
	}
	
	//using xor
	//time complexity : O(n)
	//space complexity : O(1)
	public static char oddManOut(char [] chars) {
		   
		int val = 0;
	    for (int i = 0; i < chars.length; i++) {
	        val ^= (int)chars[i];//converting to ascii
	    }
	    return (char)val;//converting back from ascii to char
	}
	
}
