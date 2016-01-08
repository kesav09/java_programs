package array;

//[Question 2]:  Find the point of rotation of rotated sorted array
//For ex. Integers in the array Example: if the input is (5,6,7,8,1,2,3) answer should be 8.

public class SortedRotatedArray {
	public static void main(String[] args){
		int[] input = {5,6,7,8,1,2,3};
		int start = 0;
		int end = input.length-1;
		while (start <= end){
			if (input[start] >= input[end]){
				start++;
				end--;
			}
		}
		System.out.println("Found. rotated at "+input[start-1]);
		System.out.println(findRotatePoint(input));
		//FIXME This might be correct solution. Complexity is O(n)
		System.out.println(rotationPoint(input));
		
		// TODO this is more optimal with quick select whose complexity is O(log(n))
		System.out.println(rotationPointQuick(input));
	}
	private static int rotationPointQuick(int[] input) {
		if (input == null || input.length == 0){
	        return -1;
	    }
		
		return -1;
	}
	public static int findRotatePoint(int[] input){
	    if (input == null || input.length == 0){
	        return -1;
	    }
	    
	    int i = 0;
	    int j = input.length - 1;
	    while ( input[i] > input[j]){
	        i++;
	        j--;
	    }
	    if (i == 0 || i >= j ){
	        return input[j];
	    } else {
	        return input[i];
	    }
	}
	
	public static int rotationPoint(int[] input){
		if (input == null || input.length == 0){
	        return -1;
	    }
		int len = input.length;
		for (int i = 0; i < len - 1; i++){
			if (input[i] > input[i+1]){
				return input[i];
			}
		}
		return -1;
	}
}
