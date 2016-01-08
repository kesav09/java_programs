package hashset;

import java.util.HashMap;

/*
 * reference: http://javahungry.blogspot.com/2013/08/how-sets-are-implemented-internally-in.html
 * 
 */
public class HashSet<E> {
	HashMap<E, Object> map;
	private final static Object DUMMY = new Object();
	public HashSet() {
        map = new HashMap<E,Object>();
    }
	
	public boolean add(E key){
		return map.put(key, DUMMY) == null;
	}
}
