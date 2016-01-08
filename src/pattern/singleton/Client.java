package pattern.singleton;

/**
 * Singleton pattern: restricts the instantiation of a class to one object. 
 * This is useful when exactly one object is needed to coordinate actions across the system.
 * 
 * examples:
 * 1. database connections
 * 2. config files.
 * 3. Logger class.
 * 4. java.lang.Runtime. runtime allows the application to interface with the environment in which the application is running.
 * 
 * Hot Spot:
 * Multithreading - A special care should be taken when singleton has to be used in a multithreading application.
 * Serialization - When Singletons are implementing Serializable interface they have to implement readResolve method in order to avoid having 2 different objects.
 * Classloaders - If the Singleton class is loaded by 2 different class loaders we'll have 2 different classes, one for each class loader.
 * Global Access Point represented by the class name - The singleton instance is obtained using the class name. At the first view this is an easy way to access it, 
 * but it is not very flexible. If we need to replace the Sigleton class, all the references in the code should be changed accordinglly.
 * 
 * 
 * 
 * why enum practice is better than other singleton patterns: http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples#reflection-and-singleton
 */
public class Client {
	public static void main(String[] args){
		System.out.println("****************** INITIALIZATION ON DEMAND ******************");
		SingletonInitializationOnDemand.singletonMethod();
		SingletonInitializationOnDemand.getInstance();
		System.out.println("****************** ENUM ******************");
		// print message inside the sinleton enum should be called only once. 
		SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
		SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
		System.out.println("****************** SINGLETON BASIC ******************");
		SingletonBasic.getInstance();
		System.out.println("****************** LAZY LOADING ( THREAD SAFE ) ******************");
	}
}
