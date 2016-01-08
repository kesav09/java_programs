package threads;
/*
 * in a muti threaded environment, print 2 'H's and 1 'O'.
 * valid sequences: HOH,OHH,HHO
 * invalid: OOH,HOO,OHO
 */
public class H2O {

    private static final Object obj=new Object();
    private static volatile Integer count = 0;
    private static volatile int counth = 0;
    private static volatile int counto = 0;

    public static void main(String[] args) {

        Thread o = new Thread(new ThreadO());
        Thread h = new Thread(new ThreadH());
        Thread h2 = new Thread(new ThreadH());
        
        h.start();
        h2.start();
        o.start();
    }

    static class ThreadO implements Runnable {

        public void run() {
           
            while (true) {
                synchronized (obj) {
                    if (count > 0 ) {
                        if(counto==0){
                        System.out.print("O");
                        counto++;
                        counth++;
                        
                        count=count-1;
                        }
                        if(counth % 3 == 0){
                            counto=0;
                            System.out.println();
                        }
                    }
                    
                    if (count > 0) {
                        count=count-1;
                    }
                    

                }

            }
        }
    }

    static class ThreadH implements Runnable {

   

        public void run() {

            while (true) {
                synchronized (obj) {
                    if (count <= 1) {
                        System.out.print("H");
                        counth++;
                        if(counth % 3 == 0){
                            System.out.println();
                            counto=0;
                        }
                        count = count + 1;
                    }
                    

                }

            }
        }
    }
    
   
}