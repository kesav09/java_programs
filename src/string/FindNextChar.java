package string;

/**
 * This has been asked in LinkedIn
 * For given array [a,d,f] and given char is c then return d.
 * if given char is f then return a etc
 * @author kvenkata
 *
 */
public class FindNextChar {
	public static void main(String[] args){
		char[] input = {'b','d','g','k','m'};
		System.out.println(findNextChar(input,'c',0,input.length-1));
	}

	/**
	 * This can be solved using binary search.
	 * We have implemented BS both iterative and recursive way.
	 */
	private static char findNextChar(char[] input, char c,int start, int end) {
		if (input == null || input.length == 0){
			throw new IllegalArgumentException();
		}
		if (!isChar(c)){
			throw new IllegalArgumentException();
		}
		if (input[start] > c || input[end] < c){
			return input[start];
		}
		while (start <= end){
			int mid = (start + end)/2;
			if (input[mid] == c){
				return input[mid];
			} else if (input[mid] < c){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return input[start];
		//return binarySearch(input, c, start, end);
	}

	private static char binarySearch(char[] input, char c, int start, int end) {
		System.out.println("binarySearch : c :-"+c+" start:- "+start+" end:- "+end);
		if (start >= end){
			return input[start];
		}
		int mid = (start + end )/2;
		System.out.println("binarySearch : c :-"+c+" start:- "+start+" end:- "+end+" mid:- "+mid+" midChar:- "+input[mid]);
		if (input[mid] == c){
			return input[mid+1];
		} else if (input[mid] > c){
			return binarySearch(input,c,start,mid - 1);
		} else {
			return binarySearch(input,c,mid + 1, end);
		}
	}

	private static boolean isChar(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
			return true;
		}
		return false;
	}
}
