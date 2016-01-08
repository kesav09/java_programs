package array;

public class MissingNumber {

	public static void main(String [] args){
		int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10, 11,12, 13, 14, 15, 16, 17, 18 ,19, 20};
//		int[] arr = new int []{1, 2, 3, 5, 6};
		System.out.println("__"+findMissingNumber(arr));
//		System.out.println(findMissingNumber(arr));
		System.out.println(findMissingNumber(arr,arr.length));
		// FIXME what if there are multiple numbers missing in a array
		findMissingNumbers(arr);
	}

	
	//using xor operator
	//1. xor all the elements in the array
	//2. xor the array again with result with 1st step
	//3. remaining will be the result
	// O(n) complexity
	public static int findMissingNumber(int [] num){
		int xor = 0;
		for (int i = 0 ; i < num.length; i++)
			xor = xor ^ num[i];
		
		for (int i = 0; i < num.length; i++)
			xor = xor ^ num[i];
		
		return xor;
	}

	//using binary search 
	//log n
	public static int findMissingNumber(int [] a, int n)
	{
		int low = 0, mid = 0, high = n-1;
		while (low <= high)
		{
			mid = (low+high)/2;
			if( mid == 0 || a[mid] - a[mid - 1] > 1 ) // order of logic must be preserved as shown.
				return a[mid] - 1;

			if (a[mid] > mid)
				high = mid - 1;
			else //(a[mid] - mid == 1)
				low = mid + 1;
		}

		return 0;
	}
	
	public static void findMissingNumbers(int[] arr){
		int min = arr[0];
		int max = arr[0];
		// find min and max in a array
		for (int i : arr){
			if (min > i){
				min = i;
			}
			
			if (i > max){
				max = i;
			}
		}
		// Update the boolean array when element is found
		System.out.println(" min :-"+min+" max :-"+max);
		boolean[] outArry = new boolean[max+1];
		for (int i=0; i < arr.length; i++){
			outArry[arr[i] - min] = true;
		}
		// which ever is not found, then 
		for (int j = 0; j < outArry.length; j++){
			if (!outArry[j]){
				System.out.println("Missing number :- "+(j+min));
			}
		}
		
	}
}
