package array;

/**
 * Given array [1,2,3,4,5] expected [120,60,40,30,24]
 * https://leetcode.com/problems/product-of-array-except-self/
 * @author kvenkata
 *
 */
public class productExceptSelf {
	public static void main(String[] args){
		int[] input = {1,2,3,4,5};
//		int[] output = new int[input.length];
//		int total = 1;
//		System.out.println("Input Array :");
//		printArry(input);
//		for (int i = 0; i < input.length; i++){
//			total *= input[i];
//		}
//		
//		System.out.println();
//		for (int i = 0; i < input.length; i++){
//			output[i] = total / input[i];
//		}
//		System.out.println("Output Array :");
//		printArry(output);
		// FIXME This is the correct solution 
		printArry(productExceptSelfFinalSol(input));
		
		printArry(productExceptSelf(input));
		
		
	}
	
	public static void printArry(int[] arry){
		for (int i: arry){
			System.out.print(i + " ");
		}
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int total = 1;
		for (int i = 0; i < nums.length; i++){
			total *= nums[i];
		}
		
		System.out.println();
		for (int i = 0; i < nums.length; i++){
			nums[i] = total / nums[i];
		}
		
		return nums;
    }
	
	/**
	 * Idea is to get the total product of the array
	 * Then divide product with each element. update that element
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelfFinalSol(int[] nums) {
		int product = 1;
		for (int num:nums){
			product *= num;
		}
		
		for (int i=0; i< nums.length;i++){
			nums[i] = product/nums[i];
		}
		return nums;
		/*int[] result = new int[nums.length];
	    result[result.length-1] = 1;
	 
	    for(int i=nums.length-2; i>=0; i--) {
	        result[i] = result[i+1] * nums[i+1];
	    }
	 
	    int left = 1;
	    for(int i=0; i<nums.length; i++) {
	        result[i] *= left;
	        left *= nums[i];
	    }
	 
	    return result;*/
    }
}
