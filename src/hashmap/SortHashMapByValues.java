package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SortHashMapByValues {
	public static void main(String[] args){
		Map<String, String> map;
		map = new HashMap<String, String>();
		map.put("John", "Mary");
		map.put("Jack", "Mary");
		map.put("Smith", "Jack");
		map.put("Steve", "Jack");
		map.put("Harry", "Steve");
		map.put("Tom", "John");
		
		SortHashMapByValues obj = new SortHashMapByValues();
		obj.sort(map,true);
		System.out.println("=====");
		obj.sort(map,false);
		
	}
	public void sortHashMapByValue(final Map<String, String> map) {
		// Since Collection.sort only takes List as argument,
		// We need to convert hashset to arraylist
	    ArrayList<String> keys = new ArrayList<String>();
	    keys.addAll(map.keySet());
	    Collections.sort(keys, new Comparator<String>() {
	        public int compare(String lhs, String rhs) {
	            String val1 = map.get(lhs);
	            String val2 = map.get(rhs);
	            return val1.compareTo(val2);
	        }
	    });

	    for (String key : keys) {
	        String c = map.get(key);
	        if (c != null) {
	            System.out.println("key:"+key+", Value:"+c.toString());
	        } 
	    }
	}
	
	public void sort(final Map<String,String> map,final boolean isAsc){
		ArrayList<String> keys = new ArrayList<String>();
		keys.addAll(map.keySet());
		Collections.sort(keys, new Comparator<String>() {
			public int compare(String lf,String rt){
				String val1 = map.get(lf);
				String val2 = map.get(rt);
				return isAsc? val1.compareTo(val2):val2.compareTo(val1);
			}
		});
		
		for(String key:keys){
			System.out.println("key :-"+key+" value :-"+map.get(key));
		}
		
	}
}
