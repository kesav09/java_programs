package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html
 * Fail fast iterator while iterating through the collection , instantly throws Concurrent
 * Modification Exception if there is structural modification  of the 
 * collection . Thus, in the face of concurrent modification, 
 * the iterator fails quickly and cleanly, rather than risking arbitrary, 
 * non-deterministic behavior at an undetermined time in the future
 * @author kvenkata
 *
 */
public class FastFailIterator {
	public static void main(String[] args){
		Map<String,String> map = new HashMap<String,String>();
		map.put("abcd","key");
		map.put("xyz","honey");
		map.put("pug","donkey");
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(map.get(iterator.next()));
			map.put("bug","monkey");
		}
	}
}
