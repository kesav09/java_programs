package array;


public class KthSmallestAndLargestNumber {

	static int [] num = new int []{99,99};
	
	public static void main(String [] args) {
		
		//System.out.println(findKthSmallest(num, 0, num.length - 1, 1));
//		System.out.println(findKthLargest(num, 0, num.length - 1, 10));
	}
	
	public static int findKthLargest(int [] num, int start, int end, int k){
		if (k < 1 || k > num.length) return -1;
		k = (num.length - k) + 1;
		return findKthSmallest(num, start, end, k);
	}
	
	//randomize quicksort
	public static int findKthSmallest(int [] num, int start, int end, int k){
		
		if (k < 1) return -1;
		
		if (num.length > 1){
			int pivot = partition(num, start, end);	
			
			if(k == pivot+1)
				return num[pivot];
			else if (k > pivot+1)
				return findKthSmallest(num, pivot+1, end, k);
			else 
				return findKthSmallest(num, start, pivot-1, k);
		}
		return -1;
	}
	
	public static int partition(int [] num, int start, int end) {
		
		int pivot = num[(start + end) / 2];
		int i = start;
		int j = end;
		while (i < j) {
			while(num[i] < pivot)
				i++;
			while(num[j] > pivot)
				j--;
			if(i < j) {
				swap(num, i, j);
			}
		}
		return j;
	}
	
	
	public static void swap(int [] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	public static void display(int [] num){
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i]+",");
		System.out.println("");
	}
	
}
