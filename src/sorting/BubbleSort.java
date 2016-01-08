package sorting;


public class BubbleSort {
	public static void main(String[] args) {
		int num[] = {10,1,8,4,6,9,2,5,7};
		System.out.println("Before Sort :-");
		printArray(num);
		bubbleSort(num);
		System.out.println("After Sort :-");
		printArray(num);
	}
	
	public static void bubbleSort(int[] num){
		int temp;
		for (int i = num.length - 1 ; i > 1; i--){
			for (int j = 0; j < i; j++){
				if (num[j] > num[j + 1]){
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}
	}
	
	public static void printArray(int[] num){
		for(int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
