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
public class CountUsingAlternateThreadsSemaphore2 {

        static Semaphore hello = new Semaphore(1);// first thread is allowed to run immediately
        static Semaphore world = new Semaphore(0);// second thread has to wait

        public static void main(String[] args) throws InterruptedException {
        	CountUsingAlternateThreadsSemaphore2 countUsingAlternateThreadsSemaphore2 = new CountUsingAlternateThreadsSemaphore2();
            MyThread mt=countUsingAlternateThreadsSemaphore2.new MyThread();     
            mt.hello = hello;
            mt.world = world;
            mt.start();

            for (int i=0; i<5; i++) {
                hello.acquire(); //wait for it
                System.out.println("Hello - "+Thread.currentThread().getName());

                world.release(); //go say world
            }
        }

    class MyThread extends Thread{

        Semaphore hello, world;

        public void run(){
            try {
                for(int i = 0; i<5; i++) {
                    world.acquire(); // wait-for it
                    System.out.println("  World! - " + Thread.currentThread().getName());

                    hello.release(); // go say hello
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
