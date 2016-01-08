package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Client {
	public static void main(String[] args){
		CustomHashMap<String,Integer> hashMap = new CustomHashMap<String, Integer>();
		hashMap.put("abc", 1);
		hashMap.put("def", 2);
		hashMap.put("ghi", 3);
		hashMap.put("jklm", 4);
		
		//for(CustomHashMap.Entry<>)
		Map<String,Integer> map = new HashMap<String, Integer>();
		CustomHashMap<String,Integer>.Entry<String, Integer>[] table = hashMap.table;
		
		for(CustomHashMap<String,Integer>.Entry<String, Integer> entry: table){
			while(entry!=null){
				System.out.println("key: " +entry.getKey() + " Value: " +entry.getValue() + " hash: " + entry.getHash());
				entry = entry.getNext();
			}
		}
	}
}
