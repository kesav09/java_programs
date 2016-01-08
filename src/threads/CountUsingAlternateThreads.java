package threads;

/**
 * Making two threads print numbers from 1-100 alternatively.
 * thread 1 - 1
 * thread 2 - 2
 * thread 1 - 3
 * thread 2 - 4
 * etc.
 * @author abpatil1
 *
 */
public class CountUsingAlternateThreads {
	static Object lock = new Object();
	static boolean t1turn = true;
	public static void main(String[] args){
		Thread t1 = new Thread(new Runnable() {

	        @Override
	        public void run() {
	            synchronized (lock) {
	                for (int i = 1; i <= 50; i += 2) {
	                    System.out.println("T1=" + i);

	                    t1turn = false;
	                        try {
	                            lock.notifyAll();
	                            lock.wait();
	                        } catch (InterruptedException e) {
	                        }
	                }
	            }

	        }
	    });
	    Thread t2 = new Thread(new Runnable() {

	        @Override
	        public void run() {
	            synchronized (lock) {
	                for (int i = 2; i <= 50; i += 2) {
	                    if (t1turn)
	                        try {
	                            lock.wait();
	                        } catch (InterruptedException e) {
	                        }
	                    System.out.println("T2=" + i);
	                    t1turn = true;
	                    lock.notify();
	                }
	            }
	        }
	    });
	    t1.start();
	    t2.start();
	    
	    try {
			t1.join();
		    t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
