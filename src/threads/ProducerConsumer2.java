package threads;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer2 {

	static Object lock = new Object();
	static LinkedList<Integer> linkedList = new LinkedList<Integer>();
	static int LIMIT = 10;
	static int count=0;

	public static void main(String[] args) {
		ProducerConsumer2 prod = new ProducerConsumer2();
		Thread producer = new Thread(prod.new Producer());
		Thread consumer = new Thread(prod.new Consumer());

		producer.start();
		consumer.start();
	}

	class Producer implements Runnable {
		public void run() {
			Random random = new Random();
			while (count<10) {
				try {
					
					//Thread.sleep(random.nextInt(500));
					synchronized (lock) {
						System.out.println("Produce acquire lock");
						while (LIMIT == linkedList.size()) {
							System.out.println("Producer conditional waiting");
							lock.wait();
						}
						int num = random.nextInt(1000);
						linkedList.add(num);
						System.out.println("List size: " + linkedList.size() + " number added: " + num);
						System.out.println(++count);
						lock.notifyAll();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Producer exited");
		}
	}

	class Consumer implements Runnable {
		public void run() {
			System.out.println("consumer RUN method.");
			while (count<10) {
				try {
					//Thread.sleep(random.nextInt(500));
					//System.out.println("Consumer before acquire lock");
					synchronized (lock) {
						System.out.println("Consumer acquire lock");
						while (linkedList.size() == 0) {
							System.out.println("Consumer conditional waiting");
							lock.wait();
						}
						//Thread.sleep(5000);
						System.out.println("List size: " + linkedList.size() + " number removed: "
								+ linkedList.removeFirst());
						System.out.println(--count);
						lock.notifyAll();
						
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
