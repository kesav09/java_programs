package misc;



public class Threading {
	private static int count = 0;

	public static void main(String[] args) {
		new Threading().doWork();
		
		//new Worker().performTask();
	}
	
	public synchronized void increment(){
		count++;
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					// some operation.
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					// some operation.
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("COUNT: "+count);
	}
}
