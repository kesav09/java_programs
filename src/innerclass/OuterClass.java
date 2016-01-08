package innerclass;

public class OuterClass {
	public static void main(String[] args) {
		InnerClass clazz = new InnerClass();
		clazz.addNum();
		InnerClass.sun();
	}
	static class InnerClass {
		void addNum(){
			
		}
		
		static void sun(){
			
		}
	}
}
