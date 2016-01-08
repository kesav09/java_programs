package number;


public class TriangleOperations implements Triangle{

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		//int[] array = {5,7,9};

		//nlogn + n
		new TriangleOperations().getTriangleSides3(array);
		/**
		 * (nlogn + logn)
		1) Sort the list. O(n lg n)
		2) Do "modified" binary search.
		a) set a=the smallest number
		b) set c=the biggest number
		c) search b between a and c s.t. a+b >= c using binary search
		d) advance a pointer or decrement c*/
		
		System.out.println(new TriangleOperations().findNumberOfTriangles(array,10));
	}

	/**
	 * a,b,c 
	 * a+b > c 
	 * c+b > a 
	 * a+c > b
	 * 
	 * 4,5,6,8,12,11 - sort - (4+5 = 9) 4,5,6,8
	 */
	public int[][] getTriangleSides(int[] sides) {
		int[][] triangleSides = new int[sides.length * sides.length][3];
		int[] sortedSides = new int[sides.length];
		// sortedSides = sort(sortedSides);
		sortedSides = sides;
		
		int count = 0;
		int c;
		for (int a = 0; a < sortedSides.length; a++) {
			for (int b = a + 1; b < sortedSides.length; b++) {
				c = b + 1;
				for (; c < sortedSides.length && (sortedSides[a] + sortedSides[b]) > sortedSides[c]; c++) {
					System.out.println("a:" + sortedSides[a] + " b:" + sortedSides[b] + " c:" + sortedSides[c]);
					triangleSides[count][0] = sortedSides[a];
					triangleSides[count][1] = sortedSides[b];
					triangleSides[count][2] = sortedSides[c];
					count++;
				}
			}
		}
		System.out.println("total no. of possible triangles : "+count);
		return triangleSides;
	}
	
	
	//to give atmost one side.
	public int[] getTriangleSides2(int[] array){
		//quickSort(array);
		int[] validSides = new int[3];
		for(int k=2;k<array.length;k++){
			if(array[k-2] + array[k-1] > array[k]){
				validSides[0] = array[k-2];
				validSides[1] = array[k-1];
				validSides[2] = array[k];
				System.out.println("a:" + validSides[0] + " b:" + validSides[1] + " c:" + validSides[2]);
			}
		}
		return validSides;
	}
	
	
	//to give atmost one side.
	public int[] getTriangleSides3(int[] array){
		//quickSort(array);
		int[] validSides = new int[3];
		for(int k=array.length - 1;k>2;k--){
			if(array[k-2] + array[k-1] > array[k]){
				validSides[0] = array[k-2];
				validSides[1] = array[k-1];
				validSides[2] = array[k];
				System.out.println("a:" + validSides[0] + " b:" + validSides[1] + " c:" + validSides[2]);
			}
		}
		return validSides;
	}
	
	// Function to count all possible triangles with arr[] elements
	public int findNumberOfTriangles(int arr[], int n)
	{
	    // Sort the array elements in non-decreasing order
	    // sort(arr);
	 
	    // Initialize count of triangles
	    int count = 0;
	 
	    // Fix the first element.  We need to run till n-3 as the other two elements are
	    // selected from arr[i+1...n-1]
	    for (int i = 0; i < n-2; ++i)
	    {
	        // Initialize index of the rightmost third element
	        int k = i+2;
	 
	        // Fix the second element
	        for (int j = i+1; j < n; ++j)
	        {
	            // Find the rightmost element which is smaller than the sum
	            // of two fixed elements
	            // The important thing to note here is, we use the previous
	            // value of k. If value of arr[i] + arr[j-1] was greater than arr[k],
	            // then arr[i] + arr[j] must be greater than k, because the
	            // array is sorted.
	            while (k < n && arr[i] + arr[j] > arr[k])
	               ++k;
	 
	            // Total number of possible triangles that can be formed
	            // with the two fixed elements is k - j - 1.  The two fixed
	            // elements are arr[i] and arr[j].  All elements between arr[j+1]
	            // to arr[k-1] can form a triangle with arr[i] and arr[j].
	            // One is subtracted from k because k is incremented one extra
	            // in above while loop.
	            // k will always be greater than j. If j becomes equal to k, then
	            // above loop will increment k, because arr[k] + arr[i] is always
	            // greater than arr[k]
	            count += k - j - 1;
	        }
	    } 
	 
	    return count;
	}
}
