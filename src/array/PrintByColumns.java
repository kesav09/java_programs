package array;

public class PrintByColumns {
	
	/**
	 * 
	 * Display an integer array of [1, 2, 3, 4, 5, 6, 7] in the following format 

		1 4 6 
		2 5 7 
		3 

		The method signature takes in an array of integers and the number of columns. In the above example, noOfCols = 3. The columns should contain equal number of elements as much as possible.


	1 4 6 
	2 5 7 
	3 
	*/
	public static void formatArrayVertically(int[] array, int col){
		if(array == null || col <= 0){
			return;
		}
		int mod = array.length % col;
		int div = array.length / col;
		
		int tempMod;
		int j=0;
		for(;j<div;j++){
		tempMod = mod;
		System.out.print(array[j]+" ");
			for(int i=j;i+div<array.length;){
				if(tempMod > 0 && i+div+1 < array.length){
					System.out.print(array[i+div+1] + " ");
					i=i+div+1;
					tempMod--;
				} else {
					System.out.print(array[i+div] + " ");
					i = i+div;
				}
			}
		System.out.println();
		}
		
		tempMod = 0;
		while(tempMod<mod){
			System.out.print(array[j] + " ");
			j=j+div+1;
			tempMod++;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		formatArrayVertically(array,3);
		System.out.println();
		formatArrayVertically(array,4);
		System.out.println();
		formatArrayVertically(array,0);
		System.out.println();
		formatArrayVertically(array,5);
		System.out.println();
		formatArrayVertically(array,8);
	}
	
	/**
	 * 1 2 3 
	   4 5 6 
	   7 

	 * @param array
	 * @param col
	 */
	public static void formatArrayHorizontaly(int[] array, int col){
		if(array == null || col <= 0){
			return;
		}
		
		int k=0;
		
		while(k<array.length){
			for(int i=0;i<col;i++){
				if(k<array.length){
					System.out.print(array[k++]+" ");
					continue;
				} else {
					break;
				}
			}
		System.out.println();
		}
	}
}
