package pattern.singleton;

public class SingletonInitializationOnDemand {
	private SingletonInitializationOnDemand(){
		System.out.println("Singleton instance created.");
	}
	
	/**
	 *  Initialization-on-demand holder idiom
	 * @author abpatil1
	 *
	 */
	private static class SingletonHolder{
		private final static SingletonInitializationOnDemand INSTANCE = new SingletonInitializationOnDemand();;
		
		/*static {
			INSTANCE = new Singleton();
		}*/
	}
	
	public static SingletonInitializationOnDemand getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	public static void singletonMethod(){
		System.out.println("inside singleton static method.");
	}
}
