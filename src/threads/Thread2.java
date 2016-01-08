package threads;

public class Thread2 extends Thread1{

	@Override
	public void run() {
		System.out.println("Thread2 started");
		
	}
	
	public static void main(String[] args){
		Thread2 t = new Thread2();
		Thread th = new Thread(t);
		th.start();
	}
}
