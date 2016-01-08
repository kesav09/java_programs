package number;

//O(n!/2) ~ O(n!) - time, where n is the input number.

/**
32*1 16*2 8*4 8*2*2 4*4*2 4*2*2*2 2*2*2*2*2

-> "32*1"
32,"",32
-> "16*2"
	2,"16*",16

->8*4
4,"",8

-> "8*2*2"
	2,"8*",2
...
...
*/
public final class PrintFactors {

    private PrintFactors() {}

    public static void printFactors(int number) {
        if (number <= 0) throw new IllegalArgumentException("The number should be greater than 0.");
        System.out.println(number + "*1");
        printFactorsList(number, "", number);
    }

    private static void printFactorsList(int dividend, String factorString, int prevDivisor) {
        /*
         * This function contains factorString as an argument to facilitate the recursive call for subsequent
         * factors until it reaches prime values. For example, let's say input number = 32 and when i = 8 it prints
         * 8*(32/8) ==> 8 * 4 but the subsequent reduction of 4 is needed and this is done by recursively passing in 4
         * as number. But we also want to maintain the chain "8 * ". So this makes the carry over string as an input
         * argument for the helper function printFactorsList
         */
        for (int divisor = dividend/2; divisor >= 2; divisor--) {

            if (dividend % divisor != 0) {
                continue;
            }

            // divisor should be lesser than prevDivisor.
            if (divisor > prevDivisor) { 
            	continue;
            }

            int quotient = dividend / divisor;

            /*
             * 32*1 16*2 8*4 8*2*2 4*4*2 4*2*2*2 2*2*2*2*2
             * 
             * Note: as we go right, the values keeps descending.
             */
            if (quotient <= divisor) {
                    System.out.println(factorString + divisor + "*" + quotient);
            }
            printFactorsList(quotient, factorString + divisor + "*", divisor);
        }
    }

    public static void main(String[] args) {
        //printFactors(12);
        System.out.println();
        printFactors(32);
    }
}
