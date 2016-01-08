package sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int num[] = {10,1,8,4,6,9,2,5,7};
		System.out.println("Before Sort :-");
		printArray(num);
		selectionSort(num);
		System.out.println("After Sort :-");
		printArray(num);
	}
	
	public static void selectionSort(int[] num){
		int min;
		for (int i = 0 ; i < num.length - 1; i++){
			min = i;
			for (int j = i + 1; j < num.length; j++){
				if (num[j] <  num[min]){
					min = j;
				}
			}
			swap(i , min , num);
		}
	}
	
	public static void swap(int one, int two,int[] num){
		if (one == two){
			return;
		}
		int temp = num[one];
		num[one] = num[two];
		num[two] = temp;
	}
	
	public static void printArray(int[] num){
		for(int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
