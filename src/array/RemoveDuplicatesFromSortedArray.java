package array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
	// Manipulate original array
	public static int removeDuplicatesNaive(int[] arr) {
		if (arr.length < 2)
			return arr.length;
	 
		int j = 0;
		int i = 1;
		
		while (i < arr.length) {
			if (arr[i] == arr[j]) {
				i++;
			} else {
				j++;// increment pointer
				arr[j] = arr[i]; // replace duplicate element with fresh
				i++; // increment to next element
			}
		}
		//TODO Here we can return below output or return length of modified array based on interviewer expectation. 
		int[] output = Arrays.copyOfRange(arr, 0, j + 1);
		for (int k : output){
			System.out.print(k+" ");
		}
		System.out.println();
		return j + 1;
		
	}
	
	public static void main(String[] args){
		int[] arry = {1,2,3,3,5,6};
		System.out.println(removeDuplicatesNaive(arry));
	}
}
