package threads;

public class Deadlock {
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	public static void main(String[] args){
		Thread thread1 = new Thread(new Thread1());
		Thread thread2 = new Thread(new Thread2());
		thread1.start();
		thread2.start();
	}
	
	static class Thread1 implements Runnable{
		public void run(){
			synchronized(lock1){
				System.out.println("Thread1 holding lock on lock1...");
				
				synchronized(lock2){
					System.out.println("Thread1 holding lock on lock2...");
				}
			}
		}
	}
	
	static class Thread2 implements Runnable{
		public void run(){
			synchronized(lock2){
				System.out.println("Thread2 holding lock on lock2...");
				synchronized(lock1){
					System.out.println("Thread2 holding lock on lock1...");
				}
			}
		}
	}
}