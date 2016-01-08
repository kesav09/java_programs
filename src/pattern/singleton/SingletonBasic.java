package pattern.singleton;

public class SingletonBasic {
	private volatile static SingletonBasic INSTANCE;
	private SingletonBasic(){
		System.out.println("inside singleton basic");
	}
	
	public static SingletonBasic getInstance(){
		if(INSTANCE == null){
			INSTANCE = new SingletonBasic();
		}
		return INSTANCE;
	}
}
