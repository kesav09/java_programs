package dynamicProgramming;

import java.util.Hashtable;


public class CoinChangeProblem {
	public static Hashtable<Integer, Integer> solved = new Hashtable<Integer, Integer>();
	
	public static void main(String[] args){
		int amount = 13;
		int[] coins = {1,2,6,7,10};
		// FIXME this is the optimal solution
		System.out.println(kovanci(coins,amount));
		System.out.println(minChange(coins,amount));
	}
	
	 public static int kovanci(int[] k, int val) {
	  // we've reached the end of recursion - a leaf
	  // if the value is less than zero it means that the current combination is not solvable
	  // if the value is zero, it means it is solvable
	  if (val <= 0) return val;

	  // for as many coins try to decrease the value for the coin value 
	  // and try to solve the smaller problem
	  int min = -1; //default: if it's not solvable
	  for (int i = k.length - 1; i >= 0; i--) {
	   if (val < k[i]) {
		   continue;
	   }
		   
		
	   // if the coin k[i] exists in the solution, it means the solution is
	   // solutions(value - coin_value) + 1
	   // eg. we have coins: 1, 3, 5 and the value is 11
	   // if the coin 5 exists in the solution, try to solve the problem for value 11-5 = 6
	   // the solution is smaller_solution + 1
	   int newVal = val - k[i];
	   int r;

	   // dynamic programming - memoization
	   // if we already have the minimum for the new value, fetch it (with time complexity O(1)), 
	   // so that we don't recursively re-solve the problem and waste time
	   if (solved.get(newVal) != null) {
	    //solution = smaller_sollution + 1
	    r = solved.get(newVal) + 1;
	   } else {
	    //try to solve the smaller problem
	    r = kovanci(k, newVal);
	    //if the solution is valid, the new solution is smaller_solution + 1
	    if (r >= 0) r++;
	    //else, keep the negative value - it means that it's not valid
	    //eg: coins 3, 5, value 11 is not solvable, the solution is -1
	   }
	   // from all of the solutions, get the minimum value
	   // and skip invalid solutions ( less than zero )
	   if ((r > 0) && (min == -1 || r < min)) {
	    min = r;
	   }
	  }
	  // dynamic programming - memoization
	  // once we do get the smallest possible solution, save it for later use
	  // it saves A LOT of time and useless work, that's already been done
	  solved.put(val, min);
	  //System.out.println(solved);
	  return min;
	 }
	 
	 //it used only O(M) memory and has O(N*M) complexity:
	 public static int[] minChange(int[] denom, int changeAmount)
	    {
	        int n = denom.length;
	        int[] count = new int[changeAmount + 1];
	        int[] from = new int[changeAmount + 1];

	        count[0] = 1;
	        for (int i = 0 ; i < changeAmount; i++)
	            if (count[i] > 0)
	                for (int j = 0; j < n; j++)
	                {
	                    int p = i + denom[j];
	                    if (p <= changeAmount)
	                    {
	                        if (count[p] == 0 || count[p] > count[i] + 1)
	                        {
	                            count[p] = count[i] + 1;
	                            from[p] = j;
	                        }
	                    }
	                }

	        // No solutions:
	        if (count[changeAmount] == 0)
	            return null;

	        // Build answer.
	        int[] result = new int[count[changeAmount] - 1];
	        int k = changeAmount;
	        while (k > 0)
	        {
	            result[count[k] - 2] = denom[from[k]];
	            k = k - denom[from[k]];
	        }
	        //System.out.println(result);
	        return result;
	    }
}
