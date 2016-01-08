package array;


public class RotateCharacterArray {

	public static void main(String[] args){
		char[] characterArray = {'a','b','c','d','e'};
		int k = 5;
		rotateArray(characterArray,k);
		System.out.println(new String(characterArray));
		
		int[] intArray = {1,2,3,4,5};
		rotateArray(intArray,k);
		for(int i:intArray){
			System.out.print(i+" ");
		}
	}
	
	/**
	 * O(n*k) - k is the number of time we want to rotate. 
	 * 
	 * @param characterArray
	 * @param k
	 */
	public static void rotateArray(char[] characterArray, int k) {
		char temp;
		int j;
		for (int i=0;i<k;i++) {
			temp = characterArray[0];
			for(j = 1;j<characterArray.length;j++) {
				characterArray[j-1] = characterArray[j];
			}
			characterArray[j - 1] = temp; 
		}
	}
	
	//easier solution
	//a,b,c,d,e
	public static void rotateArray(int[] a, int k){
		//e,d,c,b,a
		for(int i=0;i<k;i++){
			swap(a,i,a.length-i-1);
		}
		
		//d,e,c,b,a
		reverse(a,0,k - 1);
		
		//d,e,c,a,b
		reverse(a,k,a.length - 1);
	}
	
	public static void rotateArrayOld(int[] a, int k){
		reverse(a,0,k-1);
		reverse(a,k,a.length-1);
		reverse(a,0,a.length-1);
	}

	public static void reverse(int[] a, int start,int end){
		for(int i=start,j=end;i<j;i++,--j){
			swap(a,i,j);
		}
	}

	public static void swap(int[] a, int start, int end){
		int temp = a[start];
		a[start] = a[end];
		a[end] = temp;
	}
}
