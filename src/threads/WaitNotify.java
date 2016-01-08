package threads;

public class WaitNotify{
	static Object lock = new Object();
	
	public static void main(String[] args){
		WaitNotify waitNotify = new WaitNotify();
		Thread t1 = new Thread(waitNotify.new Thread1());
		Thread t2 = new Thread(waitNotify.new Thread2());
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();
	}
	
	class Thread1  implements Runnable{

		@Override
		public void run() {
			System.out.println(new Throwable().getStackTrace()[0].toString().split("\\(")[0]);
			while(true){
				synchronized(lock){
					System.out.println("Thread1 run");
					try {
						System.out.println("T1"+Thread.currentThread().getName());
						lock.notify();
						Thread.sleep(1000);
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	
	class Thread2  implements Runnable{

		@Override
		public void run() {
			while(true){
				synchronized(lock){
					System.out.println("Thread2 run");
					System.out.println("T2"+Thread.currentThread().getName());
					try {
						lock.wait();
						Thread.sleep(1000);
						lock.notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	
}
