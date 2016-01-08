package array;
//FIXME refer quickselect.java which has correct implementation for partition
public class IndexOfANumber {

	static int [] num = new int[]{4, 1, 9, 6, 3, 15, 19, 17, 18}; 
	
	public static void main(String [] args){
		getIndexOfNumber(num, 4);
	}
	
	public static void getIndexOfNumber(int [] num, int k){
		System.out.println(getIndexOfNumber(num, 0, num.length-1, k));
	}
	
	public static int getIndexOfNumber(int [] num, int start, int end, int k){
		
		if (num.length > 1){ 
			int pivot = partition(num, start, end);
			if (k < num[pivot])
				return getIndexOfNumber(num, 0, pivot-1, k);
			else if (k > num[pivot])
				return getIndexOfNumber(num, pivot+1, end, k);
			else 
				return pivot;
		}else 
			return 0;
	}
	
	public static int partition(int [] num, int start, int end){
		
		int pivot = num[(start+end)/2];
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
	
	public static void swap(int [] num, int a, int b){
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
 } 