package sorting;

public class InsertionSort{
	public static void main(String[] args){
		int num[] = {10,1,8,4,6,9,2,5,7};
		System.out.println("Before Sort :-");
		printArray(num);
		insertionSort(num);
		System.out.println("After Sort :-");
		printArray(num);
	}
	
	public static void insertionSort(int[] numbers){
		int i;
		for(int j=1;j<numbers.length;j++) {
			int temp = numbers[j];
			i=j;
			while(i>0 && numbers[i-1] >= temp) {
				numbers[i] = numbers[i-1];
				i--;
			}
			numbers[i] = temp;
			
		}
	}
	
	public static void printArray(int[] num){
		for(int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}