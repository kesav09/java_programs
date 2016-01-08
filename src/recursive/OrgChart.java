package recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrgChart {
	static Map<String, String> map; 
	static {
		map = new HashMap<String, String>();
		map.put("John", "Mary");
		map.put("Jack", "Mary");
		map.put("Smith", "Jack");
		map.put("Steve", "Jack");
		map.put("Harry", "Steve");
		map.put("Tom", "John");
	}
	
	public static void main(String[] args){
		System.out.println("Get all subordinates: ");
		getAllSubordinates("Mary");
		System.out.println();
		System.out.println("Direct subordinates: ");
		getDirectSubordinates("Mary");
		System.out.println();
		System.out.println("Indirect subordinates: ");
		getInDirectSubordinates("Mary");
		
		
	}
	
	public static void getDirectSubordinates(String head){
		if(head == null){
			return;
		}
		
		if(map.containsValue(head)){
			List<String> keys = getKeysByValue(head);
			for(String key:keys){
				System.out.println(key);
			}
		}
	}
	
	public static void getInDirectSubordinates(String head) {
		List<String> keys = getKeysByValue(head);
		for (String key : keys) {
			getAllSubordinates(key);
		}
	}
	
	public static void getAllSubordinates(String head){
		if(head == null){
			return;
		}
		
		if(map.containsValue(head)){
			List<String> keys = getKeysByValue(head);
			for(String key: keys){
				System.out.println(key);
				getAllSubordinates(key);
			}
		}
	}
	
	public static List<String> getKeysByValue(String value){
		List<String> list = new ArrayList<String>();
		for(Map.Entry<String, String> entry:map.entrySet()){
			if(value.equals(entry.getValue())){
				list.add(entry.getKey());
			}
		}
		return list;
	}
}
