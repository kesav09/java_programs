package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Given array of string return array which are anagrams
 * Idea here is to sort the of the word and keep the actual word in the value list
 * At the end loop through the HashMap to the result
 * @author kvenkata
 *
 */
public class AnagramInArray {

	public void printAnagrams(String[] input){
		Map<String,ArrayList<String>> result = new HashMap<String,ArrayList<String>>();
		for (String str:input){
			String revStr = sortString(str);
			if (result.containsKey(revStr)){
				ArrayList<String> strList = result.get(revStr);
				strList.add(str);
				result.put(revStr, strList);
			} else {
				ArrayList<String> strList = new ArrayList<String>();
				strList.add(str);
				result.put(revStr,strList);
			}
		}
		
		Set<String> keys = result.keySet();
		for (String key:keys){
			ArrayList<String> strList = result.get(key);
			if (strList.size() > 1){
				for (String str:strList){
					System.out.print(str);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	
	private String sortString(String str){
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public static void main(String[] args){
		AnagramInArray ana = new AnagramInArray();
		String[] arry = {"bat", "code", "cat", "tab", "cab", "crazy", "act"};
		ana.printAnagrams(arry);
		
		String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1 == s2 is"+ s1 == s2);
	}
}
