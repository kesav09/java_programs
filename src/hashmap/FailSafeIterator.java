package hashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html
 * Fail Safe Iterator makes copy of the internal data structure (object array)
 *  and iterates over the copied data structure.Any structural modification
 *   done to the iterator affects the copied data structure.  
 *   So , original data structure remains  structurally unchanged .
 *   Hence , no ConcurrentModificationException throws by the fail safe iterator.

Two  issues associated with Fail Safe Iterator are :

1. Overhead of maintaining the copied data structure i.e memory.

2.  Fail safe iterator does not guarantee that the data being read is the data currently in the original data structure. 
 * @author kvenkata
 *
 */
public class FailSafeIterator {
	public static void main(String[] args){
		Map<String,String> map = new ConcurrentHashMap<String,String>();
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
