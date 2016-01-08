package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// FIXME refer to RemoveDuplucatesFromString.java file
// If additional space is allowed then use HashMap solution shown below
public class RemoveDuplicates {
	
	public static void main(String[] args){
		String s = "abcd";
		System.out.println(removeDuplicates(s.toCharArray()));
		// This solution is using hashMap
		System.out.println(removeDuplicates(s));
		System.out.println(removeDuplicatesOptimized(s.toCharArray()));
		s = "aaadeefccd" ;
		System.out.println(removeDuplicates(s.toCharArray()));
		System.out.println(removeDuplicates(s));
		System.out.println(removeDuplicatesOptimized(s.toCharArray()));
		
	}
	public static char[] removeDuplicates(char[] c){
		if(c==null || c.length == 1){
			return c;
		}
		int tail = 1;
		for(int i=1;i<c.length;i++){
			int j;
			for(j=0;j<tail;j++){
				if(c[i] == c[j]){
					break;
				}
			}
			
			if(j==tail){
				c[tail] = c[i];
				tail++;
			}
		}
		if(tail < c.length){
			c[tail] = 0;
		}
		
		return c;
	}
	
	/**
	 * Best case solution and very optimized
	 * But this will not work if duplicates are not consicutive
	 */
	public static char[] removeDuplicatesOptimized(char[] c){
		if(c==null || c.length == 1){
			return c;
		}
		int i = 1;
		int j = 0;
		while( i < c.length && j < c.length){
			if (c[j] == c[i]){
				i++;
				continue;
			} 
			j++;
			c[j] = c[i];
			i++;
		}
		return Arrays.copyOfRange(c,0,j+1);
	}
	
	public static String removeDuplicates(String str){
		if (str == null || str.length() < 2){
			return str;
		}
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		StringBuilder sb = new StringBuilder();
		for(char c:str.toCharArray()){
			if (false == map.containsKey(c)){
				sb.append(c);
				map.put(c,0);
			}
		}
		
		return sb.toString();
	}
}
