package array;

public class MedianOfSortedArray {
	public static void main(String[] args){
		int[] arry1 = {1,2,3,4,6};
		int[] arry2 = {-1,5,6,7,8};
		int len = (arry1.length + arry2.length);
		int medianPos =  len / 2;
		
		int i = 0, j = 0, counter = 0, temp1 = 0, temp2 = 0;
		while (i < arry1.length && j < arry2.length && counter <= medianPos){
			if (arry1[i] < arry2[j] ){
				temp1 = temp2;
				temp2 = arry1[i];
				i++;
			} else {
				temp1 = temp2;
				temp2 = arry2[j];
				j++;
			}
			counter++;
		}
		if ((medianPos & 1) == 0){
			System.out.println("odd "+temp2);
		} else {
			System.out.println("even "+(float)(temp1 + temp2)/2);
		}
	}
}
