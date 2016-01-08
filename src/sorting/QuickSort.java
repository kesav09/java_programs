package sorting;
//in place quick sort algorithm which means that no extra memory will be used while sorting
//space complexity is O(1) 
// https://www.youtube.com/watch?v=COk73cpQbFQ
//
/**
 * FIXME this is the best answer possible with quicksort
 * @author kvenkata
 */
public class QuickSort {

	final static int [] num = new int []{-10,-5,-1,-5,15};
	public static void main(String [] args) {
		quickSort(num, 0, num.length-1);
		printArray(num);
	}
	
	public static void quickSort(int [] num, int start, int end) {
		if (start >= end) {// This is the condition to break recursion
			return;
		}
		int pivotIndex = partition(num, start, end);
		System.out.println("pivotIndex :-"+pivotIndex);
		quickSort(num, start, pivotIndex - 1);
		quickSort(num, pivotIndex+1, end);
	}
	
	public static int partition(int [] num, int start, int end) {
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

	public static void swap(int [] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	public static void printArray(int [] num){
		for (int i:num){
			System.out.print(i+" ");
		}	
	}
}
