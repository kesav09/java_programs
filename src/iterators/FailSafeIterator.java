package iterators;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html
 * 
 * @author abpatil1
 *
 */
public class FailSafeIterator {
	public static void main(String[] args)
    {
        ConcurrentHashMap<String,String> premiumPhone = 
                               new ConcurrentHashMap<String,String>();
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
