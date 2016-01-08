package pattern.singleton;

public class SingletonLazyInitialization{
	private volatile static SingletonLazyInitialization instance;
	
	private SingletonLazyInitialization(){
	}
	
	public static SingletonLazyInitialization getInstance(){
		if(instance == null) {
			synchronized(SingletonLazyInitialization.class){
				if(instance == null){
					instance = new SingletonLazyInitialization();
				}
			}
		}
		return instance;
	}
}