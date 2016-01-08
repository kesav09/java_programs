package sorting;

/***********************************************************************
 * Author: Isai Damier
 * Title: Find Kth Greatest Value
 * Project: geekviewpoint
 * Package: algorithms
 *
 * Statement:
 *   Given a list of values, find the highest kth. Assume indexing starts
 *   at one and not at zero so that the greatest number in the list is
 *   the 1st and not the 0th number.
 *
 * Time Complexity: average = O(n log n); worse O(n^2)
 * 
 * Sample Input: {21,3,34,5,13,8,2,55,1,19}; 4
 * Sample Output: 19
 * 
 * Details: This is a selection algorithm, where the task is to select
 *   an elite out of a group. In the sample input, for instance, we are
 *   to select the 4th greatest number in the list; which happens to be 13
 *   since 55, 34, and 21 are all greater than 13.
 * 
 *   Generally, selection algorithms are modified sort algorithms; where
 *   instead of sorting the whole list, we sort up to the kth value.
 *   Hence, a selection algorithm is bounded by whatever sort algorithm
 *   is used to implement it.
 * 
 *   Here for example we are using quickselect to find the kth largest
 *   value. Consequently, this algorithm is bounded by quicksort; leading
 *   to a worse case time complexity of O(n^2) and an average case
 *   time complexity of O( n log n).
 * 
 *   Note: Finding the kth largest is essentially the same as finding
 *   the kth smallest.
 * 
 **********************************************************************/
/**
 * FIXME this is the best answer possible with quicksort
 * @author kvenkata
 */
public class QuickSelect {
	public static void main(String[] args){
		int[] input = {3,2,1,5,6,4,0,9,8,7};//{1,5,2,10,0,34,3,6};
		// Find kth smallest
		System.out.println(quickselect(input,3));
		for (int i:input){
			System.out.print(i+" ");
		}
	}
	
	public static int quickselect(int[] G, int k) {
		return quickselect(G, 0, G.length - 1, k - 1);
	}

	private static int quickselect(int[] G, int first, int last, int k) {
		if (first <= last) {
			int pivot = partition(G, first, last);
			if (pivot == k) {
				return G[k];
			}
			if (pivot > k) {
				return quickselect(G, first, pivot - 1, k);
			}
			return quickselect(G, pivot + 1, last, k);
		}
		return Integer.MIN_VALUE;
	}

	private static int partition(int[] num, int start, int end) {
		int pivot = num[end];// Always keep pivot to end
		int pIndex = start;
		for (int i = start; i < end; i++){
			if (num[i] <= pivot){
				swap(num,i,pIndex);
				pIndex++;
			}
		}
		swap(num,pIndex,end);
		return pIndex;
	}

	private static void  swap(int[] G, int x, int y) {
		int tmp = G[x];
		G[x] = G[y];
		G[y] = tmp;
	}
}
