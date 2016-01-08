package pattern.singleton;

public class SingletonEagerInitialization{
	private final static SingletonEagerInitialization INSTANCE = new SingletonEagerInitialization();
	
	public static SingletonEagerInitialization getInstance(){
		return INSTANCE;
	}
}
