package array;

/**
 * Basic idea to apply here
 * Get min/max
 * 1. max-min + 1 == n
 * 2. Have visited boolean array. if index is found mark as true and if it is repeated then return false
 * http://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
 * 
 * This problem can be solved using (len*(len-1))/2 = sum of all numbers in array. But this will cause array 
 * out of bound exception. Better to use visited array to solve this
 */
public class CheckIfArrayElementsAreConsecutive {
	 public boolean areConsecutive(int input[]){
	        int min = Integer.MAX_VALUE;
	        for(int i=0; i < input.length; i++){
	            if(input[i] < min){
	                min = input[i];
	            }
	        }
	        for(int i=0; i < input.length; i++){
	            if(Math.abs(input[i]) - min >= input.length){
	                return false;
	            }
	            if(input[Math.abs(input[i]) - min] < 0){
	                return false;
	            }
	            input[Math.abs(input[i]) - min] = -input[Math.abs(input[i]) - min];
	        }
	        for(int i=0; i < input.length ; i++){
	            input[i] = Math.abs(input[i]);
	        }
	        return true;
	    }
	 
	 public boolean areConsecutiveUsingBinary(int[] input){
		 boolean[] used = new boolean[input.length];
		 int max = Integer.MIN_VALUE;
		 // Get the max value from array
		 for (int i: input){
			 if (i > max){
				 max = i;
			 }
		 }
		 
		 for (int i:input){
			 if (((max - i) < input.length && (max - i) >= 0) || used[max - i]){
				 return false;
			 }
			 used[max-i] = true;
		 }
		 return true;
	 }
	    
	    public static void main(String args[]){
	        int input[] = {76,77,75,77,73,74};
	        CheckIfArrayElementsAreConsecutive cia = new CheckIfArrayElementsAreConsecutive();
	        System.out.println(cia.areConsecutive(input));
	        System.out.println(cia.areConsecutiveUsingBinary(input));
	    }
}
