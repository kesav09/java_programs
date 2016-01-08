package threads;

import java.util.concurrent.Semaphore;

/**
 * Making two threads print numbers from 1-100 alternatively (using semaphores) 
 * thread 1 - 1
 * thread 2 - 2
 * thread 1 - 3
 * thread 2 - 4
 * etc.
 * @author abpatil1
 *
 */
public class CountUsingAlternateThreadsSemaphore {

	public static void main(String[] args) {
		Semaphore a = new Semaphore(1); // first thread is allowed to run immediately
		Semaphore b = new Semaphore(0); // second thread has to wait
		CountUsingAlternateThreadsSemaphore countUsingAlternateThreadsSemaphore = new CountUsingAlternateThreadsSemaphore();
		ThreadPrinter tp1 = countUsingAlternateThreadsSemaphore.new ThreadPrinter(1, a, b);
		ThreadPrinter tp2 = countUsingAlternateThreadsSemaphore.new ThreadPrinter(2, b, a);

		Thread t1 = new Thread(tp1);
		Thread t2 = new Thread(tp2);

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

	class ThreadPrinter implements Runnable {
		int counter;
		Semaphore ins, outs;

		ThreadPrinter(int counter, Semaphore ins, Semaphore outs) {
			this.counter = counter;
			this.ins = ins;
			this.outs = outs;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 25; i++) {
					ins.acquire();

					System.out.println("" + counter + " " + Thread.currentThread().getName());
					outs.release(); // allow another thread to run
					counter += 2;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // wait for permission to run
		}
	}
}
