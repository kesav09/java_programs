package array;

public class RotationArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {4, 5, 6, 1, 2, 3};
		
		System.out.println(getIndexOfRotatedArray(arr));
		System.out.println(isElementPresent(arr, 7));
	}
	
	//get pivot with which sorted array rotated
	//1 2 3 4 5
	//o/p - 3 4 5 1 2
	public static int getIndexOfRotatedArray(int [] arr){
		if (arr == null || arr.length < 1)
			return -1;
		
		int start = 0;
		int end = arr.length - 1;
		
		
		while (start < end){
			if(arr[start] < arr[end]){
				return end + 1;
				
			}else{
				int mid = (end - start) / 2;
				if (arr[start] <= arr[mid] && arr[mid+1] <= arr[end]){
					return mid + 1;
				}else if (arr[start] < arr[mid]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}	
		}
		return -1;
	}
	
	//search an element in the rotated sorted array
	//3 4 5 1 2
	//divide array into 2 halves left and right and then do the binary search
	public static boolean isElementPresent(int [] arr, int key){
		if (arr == null || arr.length < 1)
			return false;
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end){
			int mid = start + ((end - start) / 2);
			
			if (arr[mid] == key) return true;
			
			//left half 
			if (arr[start] <= arr[mid]){//4 5 6 1 2 3
				if (arr[start] <= key && key < arr[mid]){
					end = mid - 1;
				}else{
					start = mid + 1;
				}
			
			//right half
			}else {
				if (arr[mid] < key && key <= arr[end]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}
		}
		return false;
	}
}