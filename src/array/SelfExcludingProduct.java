package array;

public class SelfExcludingProduct {

	public static void main(String[] args){
		int [] num = new int []{2, 6, 4, 8};
		getProductArray(num, 4);
		//FIXME this is very optimal solution
		selfExcludingProduct2(num);
	}
	
	public static void getProductArray(int arr[], int n){
	 int temp = 1;
	 
	  int [] prod = new int[arr.length];
	 
	  /* In this loop, temp variable contains product of
	    elements on left side excluding arr[i] */
	  for(int i = 0; i < n; i++){
	    prod[i] = temp;	
	    temp *= arr[i];
	  }
	 
	  /* Initialize temp to 1 for product on right side */
	  temp = 1;
	 
	  /* In this loop, temp variable contains product of
	    elements on right side excluding arr[i] */
	  for(int i = n-1; i >= 0; i--){
	    prod[i] *= temp;
	    temp *= arr[i];
	  }
	 
	  /* print the constructed prod array */
	  for (int i = 0; i < n; i++){
	    System.out.print(prod[i]+",");
	  }
	}


	public static void selfExcludingProduct2(int[] array){
		int product = 1;
		for(int i=0;i<array.length;i++){
			product = product * array[i];
		}
		
		for(int i=0;i<array.length;i++){
			array[i] = product / array[i];
		}
		System.out.println();
		for(int i : array){
			System.out.print(i + " ");	
		}
	}
}
