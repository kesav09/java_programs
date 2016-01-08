package array;

public class BinarySearchModifiied {
	/** 
	 * Return the smallest character that is strictly larger than the search character,
	 * otherwise return the first character in the array.
	 * @param sortedArr : sorted list of letters, sorted in ascending order.
	 * @param c : character for which we are searching.
	 * Given the following inputs we expect the corresponding output:
	 * ['c', 'f', 'j', 'p', 'v'], 'a' => 'c'
	 * ['c', 'f', 'j', 'p', 'v'], 'c' => 'f'
	 * ['c', 'f', 'j', 'p', 'v'], 'k' => 'p'
	 * ['c', 'f', 'j', 'p', 'v'], 'z' => 'c' // The wrap around case
	 
	 
	 null,c //exception
	 "",c //exception
	 "",char not from a to z
	  * ['c', 'f', 'j', 'p', 'v'], 'v' => 'c'
	 [z,z,z],z // 
	 
	 
	 */
	 public static void main(String[] args){
		 BinarySearchModifiied bs = new BinarySearchModifiied();
		 String input = "dgkp";
		 char c = 'f';
		 // Recursive solution
		 System.out.println(bs.findInsPoint(input, c));
		 // Iterative solution
		 // FIXME use this approach as this looks simple even though both the solutions are same
		 System.out.println(bs.findInsPointIteratively(input, c));
	 }
	 

	char findInsPoint(String sortedArr, char c){
	    if(!isChar(c)){
	        throw new IllegalArgumentException("");
	    }
	    
	    if(sortedArr == null || sortedArr.isEmpty()){
	        throw new IllegalArgumentException("");
	    }
	    
	    if(c >= sortedArr.charAt(sortedArr.length()-1)){
	        return sortedArr.charAt(0);
	    }
	       
	    return binarySearch(sortedArr.toCharArray(),0,sortedArr.length() - 1,c);
	}

	public char binarySearch(char[] sortedArr, int start, int end, char c) {
		if (start > end) {
			return sortedArr[start];
		}

		int mid = (start + end) / 2;
		if (sortedArr[mid] == c) {
			return sortedArr[mid];
		} else if (sortedArr[mid] > c) {
			return binarySearch(sortedArr, start, mid - 1, c);
		} else {
			return binarySearch(sortedArr, mid + 1, end, c);
		}
	}
	
	public char findInsPointIteratively(String input, char c) {
		if (input == null || input.length() == 0){
			throw new IllegalArgumentException();
		}
		if (!isChar(c)){
			throw new IllegalArgumentException();
		}
		int start = 0;
		int end = input.length() - 1;
		char[] cArry = input.toCharArray();
		if (cArry[start] > c || cArry[end] <= c){
			return cArry[start];
		}
		while (start <= end){
			int mid = (start + end)/2;
			if (cArry[mid] == c){
				return cArry[mid];
			} else if (cArry[mid] < c){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return cArry[start];
	}

	boolean isChar(char c){
	    if(c > 'a' || c < 'z'){
	        return true;
	    }
	    return false;
	}
}
