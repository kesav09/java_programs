package threads;

import java.util.Random;

/**
 * Assume there are three processes: Pa, Pb, and Pc. Only Pa can output the letter A, Pb B, and Pc C.
Utilizing only semaphores (and no other variables) the processes are synchronized so that the output satisfies the following conditions:

a) A B must be output before any C’s can be output.
b) B’s and C’s must alternate in the output string, that is, after the first B is output, another B cannot be output until a C is output. Similarly, once a C is output, another C cannot be output until a B is output.
c) The total number of B’s and C’s which have been output at any given point in the output string cannot exceed the number of A’s which have been output up to that point.
 * @author kvenkata
 *
 */
public class PrintAlternativeThreadsSemaphore {
	protected static final BinarySemaphore binarySemaphore0 = new BinarySemaphore(
			0);
	protected static final BinarySemaphore binarySemaphore1 = new BinarySemaphore(
			1);
	protected static final CountingSemaphore countingSemaphore = new CountingSemaphore(
			0);

	protected static final Random random = new Random();

	public static void main(String args[]) throws InterruptedException {
		new Thread(new ProcessA()).start();
		new Thread(new ProcessB()).start();
		new Thread(new ProcessC()).start();
		Thread.sleep(9000);
		System.exit(0);
	}
}

class ProcessA extends PrintAlternativeThreadsSemaphore implements Runnable {
	public void run() {
		while (true) {
			try {
				Thread.sleep(1 + (int) (random.nextDouble() * 500));
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.print("A");
			countingSemaphore.notifyToWakeup();
		}
	}
}

class ProcessB extends PrintAlternativeThreadsSemaphore implements Runnable {
	public void run() {
		while (true) {
			try {
				Thread.sleep(1 + (int) (random.nextDouble() * 800));
				binarySemaphore1.waitForNotify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countingSemaphore.waitForNotify();
			System.out.print("B");
			binarySemaphore0.notifyToWakeup();
		}
	}
}

class ProcessC extends PrintAlternativeThreadsSemaphore implements Runnable {
	public void run() {
		while (true) {
			try {
				Thread.sleep(1 + (int) (random.nextDouble() * 800));
				binarySemaphore0.waitForNotify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countingSemaphore.waitForNotify();
			System.out.print("C");
			binarySemaphore1.notifyToWakeup();
		}
	}
}

class CountingSemaphore {
	private int value = 0;
	private int waitCount = 0;
	private int notifyCount = 0;

	public CountingSemaphore(int initial) {
		if (initial > 0) {
			value = initial;
		}
	}

	public synchronized void waitForNotify() {
		if (value <= waitCount) {
			waitCount++;
			try {
				do {
					wait();
				} while (notifyCount == 0);
			} catch (InterruptedException e) {
				notify();
			} finally {
				waitCount--;
			}
			notifyCount--;
		}
		value--;
	}

	public synchronized void notifyToWakeup() {
		value++;
		if (waitCount > notifyCount) {
			notifyCount++;
			notify();
		}
	}
}

class BinarySemaphore {
	private boolean locked = false;

	BinarySemaphore(int initial) {
		locked = (initial == 0);
	}

	public synchronized void waitForNotify() throws InterruptedException {
		while (locked) {
			wait();
		}
		locked = true;
	}

	public synchronized void notifyToWakeup() {
		if (locked) {
			notify();
		}
		locked = false;
	}
}
