package dynamicProgramming;

import java.io.FileNotFoundException;
import java.util.Scanner;

//FIXME refer CoinChangeProblem.java which is optimial solution
public class CoinChangeRecursive {   
	 
    public static int MEM[] = new int[10001];   // Can support up to 10000 peso value
    public static int coins[] = {1, 5, 7, 10};  // Available coin denominations
     
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);    
         
        int count = CC(in.nextInt());
 
        // Test if the amount can be represented with the given denominations
        System.out.println(count == Integer.MAX_VALUE ? "Cannot Represent" : count);
    }
     
    public static int CC(int n) {
        if(n < 0)
            return Integer.MAX_VALUE-1;
        else if(n == 0)
            return 0;
        else if(MEM[n] != 0)    // If solved previously already
            return MEM[n];
        else {
            // Look for the minimal among the different denominations
            MEM[n] = 1+CC(n-coins[0]);
            for(int i = 1; i < coins.length; i++)
                MEM[n] = Math.min(MEM[n], 1+CC(n-coins[i]));
            return MEM[n];
        }
    }
     
}
