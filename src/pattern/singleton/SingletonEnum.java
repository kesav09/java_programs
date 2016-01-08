package pattern.singleton;

/**
 * enum fields are compile time constants, but they are instances of their enum type. 
 * And, they're constructed when the enum type is referenced for the first time.
 * 
 * 
 * @author abpatil1
 *
 */
public enum SingletonEnum {
	INSTANCE;
	
	private SingletonEnum(){
		System.out.println("inside singleton Enum explicit constructor.");
	}
}
