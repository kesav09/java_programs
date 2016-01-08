package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Two words are called isomorphic if the letters in one word can be remapped to get the second word. 
 * "foo", "app"; returns true
 * "turtle", "tletur"; returns true
 * "turtle","tletru"; returns false
 * "bar", "foo"; returns false
 * 
 * This code works for all cases!
*/
public class IsomorphicTest{
	public static void main(String[] args){
		System.out.println(isIsomorphic("turtle","tletru"));//false (expected)
		System.out.println(isIsomorphic("turtle","tletur"));//true
		System.out.println(isIsomorphic("foo", "bar"));//false
		System.out.println(isIsomorphic("bar", "foo"));//false
		System.out.println(isIsomorphic("tletur", "turtle"));//true
		System.out.println(isIsomorphic("foo","app"));//true
		System.out.println(isIsomorphic("foo","pap"));//false
		System.out.println(isIsomorphic("pap","foo"));//false
		
		System.out.println();
		System.out.println("List of Strings");
		List<String> list1 = new ArrayList<String>();
		list1.add("turtle");
		list1.add("tletur");
		System.out.println(isListIsomorphic(list1));//true
		
		List<String> list2 = new ArrayList<String>();
		list2.add("foo");
		list2.add("bar");
		System.out.println(isListIsomorphic(list2));//false
		
		List<String> list3 = new ArrayList<String>();
		list3.add("foo");
		list3.add("app");
		System.out.println(isListIsomorphic(list3));//true
		
		List<String> list4 = new ArrayList<String>();
		list4.add("foo");
		list4.add("app");
		list4.add("apa");
		list4.add("pap");
		System.out.println(isListIsomorphic(list4));//false
		
		List<String> list5 = new ArrayList<String>();
		list5.add("turtle");
		list5.add("tletre");
		System.out.println(isListIsomorphic(list5));//false
	}
	
	public static boolean isIsomorphic(String str1,String str2){
		if(str1 == null || str2 == null){
			return false;
		}
		
		if(str1.length() != str2.length()){
			return false;
		}
	
		Map<Character,Character> map = new HashMap<Character,Character>();
		Character value;
		for(int i=0;i<str1.length();i++){
			value = map.get(str1.charAt(i));
			
			// check whether value is present 
			if(map.containsValue(str1.charAt(i)) || map.containsValue(str2.charAt(i))){
					Character key = getKeyByValue(map,str1.charAt(i));
					if(key != null && key != str2.charAt(i)){
						return false;
					}
					if(key == null){
						key = getKeyByValue(map, str2.charAt(i));
						if(key != null && key != str1.charAt(i)){
							return false;
						}
					}
			} else if(value != null && value != str2.charAt(i)){	//contains key
				return false;
			} else  if(value == null){
				map.put(str1.charAt(i),str2.charAt(i));
			}  
		}
		return true;
	}
	
	public static Character getKeyByValue(Map<Character,Character> map,Character value){
		for(Map.Entry<Character,Character> entry:map.entrySet()){
			if(entry.getValue() == value){
				return entry.getKey();
			}
		}
		return null;
	}
	
	public static boolean isListIsomorphic(List<String> list){
		for(int i=0;i<list.size();i++){
			for(int j=i+1;j<list.size();j++){
				if(!isIsomorphic(list.get(i),list.get(j))){
					return false;
				}
			}
		}
		return true;
	}
}
