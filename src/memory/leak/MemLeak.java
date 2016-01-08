package memory.leak;

import java.util.Map;
// When key object does not implement equals and hashCode methods then map does not 
// know whether it is same key or different. Hence there will be memory leak
public class MemLeak {
    public final String key;
    
    public MemLeak(String key) {
        this.key =key;
    }
    
    public static void main(String args[]) {
        try {
            Map map = System.getProperties();
            
            for(;;) {
                map.put(new MemLeak("key"), "value");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
