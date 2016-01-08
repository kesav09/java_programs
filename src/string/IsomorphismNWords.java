package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * FIXME this does not work as solution is not looking for char mapping
 */
public class IsomorphismNWords{
	
	private static java.util.List<String> list =  new ArrayList<String>();
	
	public static void main(String [] args){
		/*list.add("turtle");
		list.add("tletur");
		list.add("tletus");*/
		list.add("bus");
		list.add("car");
		list.add("rat");
		String first = getIsomorohicCode(list.get(0));
		System.out.println(isListIsomorphic(list, first));	
	}
	
	private static boolean isListIsomorphic(java.util.List<String> list, String first){
		for (int i = 1; i < list.size(); i++){
			if (!getIsomorohicCode(list.get(i)).equals(first)){
				return false;
			}
		}
		return true;
	}

	// for 2 strings
	public static boolean isIsomorphic(String word1, String word2){
		String first = getIsomorohicCode(word1);
		String second = getIsomorohicCode(word2);
		if (first.equals(second)){
			return true;
		}
		return false;
	}

	public static String getIsomorohicCode(String word1){
		StringBuffer buffer = new StringBuffer();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char c;
		for (int i = 0; i < word1.length(); i++){
			c = word1.charAt(i);
			if (!map.containsKey(c)){
				map.put(c, i);
				buffer.append(i);
			}else{
				buffer.append(buffer.append(map.get(c)));
			}
		}
		return buffer.toString();
	}
}
