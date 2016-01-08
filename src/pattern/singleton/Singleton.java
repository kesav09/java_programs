package pattern.singleton;

public class Singleton {

	private static Singleton instance = null;;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstanceNonThreadVersion(){
		
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
	
	public static synchronized Singleton getInstanceThreadVersion(){
		
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
	
	public static synchronized Singleton getInstanceBestExample(){
		
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
	
public static Singleton getInstanceDubleCheckedLocking(){
		
		if(instance == null) {
			
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
			
		}
		return instance;
	}
	
	
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public static void main(String [] args) {
		
	}
}

//multi threaded
//based on mutual exclusion on the class that indicates that the object is being instantiated
class SingletonBestExample {
	private static SingletonBestExample instance = new SingletonBestExample();
	
	private SingletonBestExample(){
		
	}
	
	public static SingletonBestExample getInstance(){
		return instance;
	}
}
