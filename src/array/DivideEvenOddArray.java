
//Given an array of integers write a function so that all the even numbers are on the left side of the array and 
//all the odd numbers are on the right side of the array.

package array;

public class DivideEvenOddArray {
	private static int [] num = new int[] {3,2,5,12,18,15};

	public static void main(String [] args){
		getOrderedArray(num);
		display(num);
	}

	private static void getOrderedArray(int [] num){
		if (num == null || num.length < 1){
			return;
		}

		int i = 0;
		int j = num.length - 1;
		while(i < j){
			while (num[i] % 2 == 0){
				i++;
			}
			while(num[j] % 2 != 0){
				j--;
			}

			if (i < j){
				swap(num, i, j);
				i++;
				j--;
			}
		}
	}

	private static void swap(int [] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	private static void display(int [] num){
		for (int i = 0; i < num.length; i++){
			System.out.print(num[i]+",");
		}
	}
}


