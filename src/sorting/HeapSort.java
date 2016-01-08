
//Heap sort is slowest  but it is better option for large data sets.
//n log n
//A variation of Selection Sort which uses Heap
//n place sort, thus no extra memory is used.
//not a stable sort
//

package sorting;

public class HeapSort {

	public static void main(String[] args) {
		int num[] = {10,1,8,4,6,9,2,5,7};
		heapsort(num);
	}

	/**
	 * Selection Sort but using Heap data structure
	 * 
	 * @param num
	 */
	public static void heapsort(int[] num) {
		constructHeap(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}

		System.out.println("heap constructed ");

		// Now do Selection sort by retrieving max/min element and swapping with elements at top/END

		int end = num.length-1;
		while(end>0){
			// swap first elem with last
			int temp = num[0];
			num[0] = num[end];
			num[end] = temp;
			bubbleDown(num,0,end-1);
			end--;
		}



		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}

	}

	/**
	 * Create Max heap from given array
	 * 
	 * Heap is a datastructure which is loosely sorted Children are always
	 * greater than the parent, thus the root of the heap will always be the
	 * minimum element or vice versa in case of max-heap
	 * 
	 * root is i, its left child is 2*i+1 and right child is 2*i+2
	 * 
	 * @param num
	 */
	public static void constructHeap(int[] num) {
		int start = (num.length/2)-1; // Starting from last parent
		int end = num.length-1;
		while(start>=0){
			bubbleDown(num,start, end);
			if(start==0)
				break;
			start= start-1;            
		}
	}

	/**
	 * Bubble down method to insert new elements into heap
	 * 
	 * @param num
	 * @param start
	 * @param end
	 */


	public static void bubbleDown(int[] num, int start, int end){
		int root = start;


		while(root*2+1<=end){ // at least one child exists
			int swap = root;
			int child = root*2+1;
			int rchild = root*2+2;
			if(num[swap]<num[child]){
				swap = child;
			}
			if(rchild<=end && num[swap]<num[rchild]){
				swap = rchild;
			}
			if(swap!=root){
				// swap here
				int temp = num[root];
				num[root] = num[swap];
				num[swap] = temp;
				root = swap;
			}else
				return;
		}
	}

	/**
	 * Construct Bubble down for Min Heap
	 * @param num
	 * @param start
	 * @param end
	 */
	public static void bubbleDownMin(int[] num, int start, int end){
		int root = start;


		while(root*2+1<=end){ // at least one child exists
			int swap = root;
			int child = root*2+1;
			int rchild = root*2+2;
			if(num[swap]>num[child]){
				swap = child;
			}
			if(rchild<=end && num[swap]>num[rchild]){
				swap = rchild;
			}
			if(swap!=root){
				// swap here
				int temp = num[root];
				num[root] = num[swap];
				num[swap] = temp;
				root = swap;
			}else
				return;
		}
	}

	// functions to find kth smallest/largest element in heap

}