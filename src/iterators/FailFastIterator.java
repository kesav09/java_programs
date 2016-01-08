package iterators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html
 * Expected to throw ConcurrentModificationExample
 * @author abpatil1
 *
 */
public class FailFastIterator {
	  public static void main(String[] args)
	    {
	        Map<String,String> premiumPhone = new HashMap<String,String>();
	        premiumPhone.put("Apple", "iPhone");
	        premiumPhone.put("HTC", "HTC one");
	        premiumPhone.put("Samsung","S5");
	        
	        Iterator<String> iterator = premiumPhone.keySet().iterator();
	        
	        while (iterator.hasNext())
	        {
	            System.out.println(premiumPhone.get(iterator.next()));
	            premiumPhone.put("Sony", "Xperia Z");
	        }
	        
	    }
}
