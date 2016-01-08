package threads;

public class ThreadSpawning {
	public static void main(String[] args){
		ThreadSpawning thread = new ThreadSpawning();
		ThreadClass threadClass = thread.new ThreadClass();
		threadClass.start();
		Thread runnableThread = new Thread(thread.new RunnableThread());
		runnableThread.start();
	}
	
	class RunnableThread implements Runnable{
		public void run(){
			System.out.println("running runnable thread: "+Thread.currentThread()+" run method.");
		}
	}
	
	class ThreadClass extends Thread{
		public void run(){
			System.out.println("inside threadClass "+Thread.currentThread()+" run method.");
		}
	}

}
