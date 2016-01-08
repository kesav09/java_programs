//print the no of possible traingles from an array such that sum of any 
//two sides should be greater than 
// the 3rd side
//eg: {4, 6, 3, 7} o/p - {3, 4, 6}, {4, 6, 7}, {3, 6, 7}
// {3, 4, 7} - invalid


// brute force will take N to the power 3
// efficient method will take N to the power 2

// 1. sort the array by quicksort in increasing order 
// 2. then start from the last of the array 
// 3. keep i at the end and j = i- 1 and k = i - 2
// 4. keep shifting k till k >= 0, then move j again to the left 
package number;

public class TriangleTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getTriangleTriplets(new int[]{4, 1, 2, 6, 3, 5});
	}
	
	public static void getTriangleTriplets(int [] arr){
		if (arr.length < 1 || arr == null){
			return;
		}
		// sort the array 
		//presuming resultant array {1, 2, 3, 4, 5, 6} 
		
		arr = new int []{1, 2, 3, 4, 5, 6};
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--){
			for (int j = i - 1; j >= 0; j--){
				for (int k = j - 1; k >= 0; k--){
					if ((arr[k] + arr[j]) > arr[i]){
						System.out.println(arr[k]+","+arr[j]+","+arr[i]);
						count++;
					}
				}
			}
		}
		System.out.println("total no. of possible triangles : "+count);
	}
}
