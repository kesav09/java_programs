package string;
//https://leetcode.com/problems/isomorphic-strings/
import java.util.HashMap;
import java.util.Map;

/**
 * Given two string, they are isomorphic only when by replace char in string1 can get string2 
 * @author kvenkata
 *
 */
public class Isomorphic{
	public static void main(String[] args) {
		String str1 = "turtlel";
		String str2 = "trutele";
		Map<Character,Integer> map1 = getIsomorphicMap(str1);
		Map<Character,Integer> map2 = getIsomorphicMap(str2);
		
		boolean areMapsEqual = areMapsEqual(map1,map2);
		System.out.println("are Maps equal: " + areMapsEqual);
		System.out.println(isIsomorphicSol(str1,str2));
		//FIXME This is optimized
		System.out.println(isIsomorphic(str1,str2));
		
		// This is more optimized.. later found it is not
		System.out.println(isIsomorphicOptimized(str1,str2));
		
		//FIXME this is more awesome with just array. More memory is used but simple and better performance
		System.out.println(isIsomorphicUsingArray(str1,str2));
		
		
	}
	
	public static boolean isIsomorphicUsingArray(String s, String t) {
		if (s == null && t == null) {
			return false;
		}
		if (s.equals(t)) {
			return true;
		}
		if (s.length() != t.length()) {
			return false;
		}

		int N = s.length();
		int[] mst = new int[256];
		int[] mts = new int[256];

		for (int i = 0; i < N; i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);

			if ((mst[cs] == 0) && (mts[ct] == 0)) {
				mst[cs] = ct;
				mts[ct] = cs;
			}

			if ((mst[cs] != ct) || (mts[ct] != cs))
				return false;
		}

		return true;
	}
	public static boolean isIsomorphicSol(String s1, String s2) {
		if (s1 == null || s2 == null) {
			throw new IllegalArgumentException();
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {

			if (!map.containsKey(s1.charAt(i))) {

				if (map.containsValue(s2.charAt(i))) {

					return false;
				}

				else {
					map.put(s1.charAt(i), s2.charAt(i));
				}
			} else {
				if (map.get(s1.charAt(i)) != s2.charAt(i)) {
					return false;
				}
			}
		}

		return true;
	}
	
	private static boolean isIsomorphicOptimized(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		
		int lenght = str1.length();
		HashMap<Character,Integer> map1 = new HashMap<Character,Integer>();
		HashMap<Character,Integer> map2 = new HashMap<Character,Integer>();
		int count1 = 0 , count2 = 0;
		char char1,char2;
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0 ; i < lenght; i ++){
			char1 = str1.charAt(i);
			char2 = str2.charAt(i);
			if (map1.get(char1) == null){
				map1.put(char1, count1++);
			}
			sb1.append(map1.get(char1));
			
			if (map2.get(char2) == null){
				map2.put(char2, count2++);
			}
			sb2.append(map2.get(char2));
		}
		
		if (sb1.toString().equals(sb2.toString())){
			return true;
		}
		
		return false;
	}

	public static Map<Character,Integer> getIsomorphicMap(String str) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Character character;
		Integer count;
		for(int i=0;i<str.length();i++) {
			character = str.charAt(i);
			count = map.get(character);
			if(count == null) {
				map.put(character,1);
			} else {
				map.put(character,++count);
			}
		}
		return map;
	}
	
	public static boolean areMapsEqual(Map<?,?> map1, Map<?,?> map2) {
		if(map1 == null || map2 == null || map1.size()!=map2.size()){
			return false;
		} 
		
		for(Object key:map1.keySet()) {
			if(!map1.get(key).equals(map2.get(key))){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isIsomorphic(String s, String t) {
		if(s == null && t == null){
            return false;
        }
		if(s.equals(t)){
            return true;
        }
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        for(int i = 0; i < s_array.length; i++){
            if(!map.containsKey(s_array[i])){ // if map does not contain current key
                if(map.containsValue(t_array[i])){ // if the current value has been mapped by other keys
                    return false;
                }
                map.put(s_array[i], t_array[i]);
            }else{ // if map contains current key, judge whether current value equals the mapped value
                if(!(map.get(s_array[i]) == t_array[i])){
                    return false;
                }
            }
        }
        return true;        
    }

	private static Character getKeyFromValue(Map<Character, Character> dict, char c) {
		for (Map.Entry<Character,Character> entry : dict.entrySet()) {
	        if (entry.getValue().equals(c)) {
	            return entry.getKey();
	        }
	    }
	 
	    return null;
	}
}