package array;

public class IntegerAppearsOnce {

	/**
	 * @param args
	 */
	static int [] num = new int[]{3, 9, 1, 3, 9};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oddManOut(num));
	}
	
	//using xor
	//time complexity:  O(n)
	//space complexity: O(1)
	//remember 
	// 0 0 = 0
	// 0 1 = 1
	// 1 0 = 1
	// 1 1 = 0
	
	public static int oddManOut(int[] num) {
	   
		int val = num[0];
	    for (int i = 1; i < num.length; i++) {
	        val ^= num[i];
	    }
	    return val;
	}
}
