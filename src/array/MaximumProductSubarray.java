package array;

public class MaximumProductSubarray {
	
	public static void main(String[] args){
		int[] array = {1, -2, -3, 0, 7, -8, -2,-100};
		//int[] array = {0,0,0,-20};
		//int[] array = {0,0,0,0};
		System.out.println(maxProductSubArray(array));
	}
	
	//logic is similar to geekforgeeks. 
	public static int maxProductSubArray(int[] array) {
		if (array == null) {
			return 0;
		}
		int max = array[0];
		int min = array[0];
		int maxProd = array[0];
		for (int i = 1; i < array.length; i++) {

			int temp = max;
			max = Math.max(Math.max(array[i], max * array[i]), min * array[i]);
			min = Math.min(Math.min(array[i], min * array[i]), temp * array[i]);

			if (max > maxProd) {
				maxProd = max;
			}
		}
		return maxProd;
	}

	/*
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
	 * 
	 * -2,3,-4,-6 2,3,4,-6
	 * 
	 * geeks for geeks:http://www.geeksforgeeks.org/maximum-product-subarray/
	 */
	public int maxProductSubArray1(int[] array) {
		int tempMaxProd = 1;
		int tempMinProd = 1;

		int maxProd = 1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				tempMaxProd = tempMaxProd * array[i];
				tempMinProd = min(tempMinProd * array[i], 1);
			}

			if (array[i] == 0) {
				tempMaxProd = 1;
				tempMinProd = 1;
			}

			if (array[i] < 0) {
				int temp = tempMaxProd * array[i];
				tempMaxProd = max(tempMinProd * array[i], 1);
				tempMinProd = temp * array[i];
			}

			if (tempMaxProd > maxProd) {
				maxProd = tempMaxProd;
			}
		}
		return maxProd;
	}

	public int min(int a, int b) {
		return a > b ? b : a;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}



	public int maxProduct(int[] A) {
		if (A == null || A.length == 0){
			return 0;
		}
		int max_here = 1;
		int min_here = 1;
		int max_so_far = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++){
			if (A[i] > 0) {
				max_here *= A[i];
				min_here *= A[i];
				max_so_far = Math.max(max_so_far, max_here);
			} else if (A[i] < 0){
				max_so_far = Math.max(max_so_far, min_here * A[i]);
				int temp = max_here;
				max_here = Math.max(1, min_here * A[i]);
				min_here = temp * A[i];
			} else {
				max_so_far = Math.max(max_so_far, 0);
				max_here = 1;
				min_here = 1;
			}
		}
		return max_so_far;
	}
}