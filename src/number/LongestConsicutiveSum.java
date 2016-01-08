package number;

/*
 * You are given an array of integers (both positive and negative). Find the continuous sequence with the largest sum. Return the sum.
 EXAMPLE
 Input: {2, -8, 3, -2, 4, -10}
 Output: 5 (i.e., {3, -2, 4} )
 */
public class LongestConsicutiveSum {
	public static int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxsum < sum) {
				maxsum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, -8, 3, 2, 4, -2,35};
		System.out.println(getMaxSum(nums));
	}
}
