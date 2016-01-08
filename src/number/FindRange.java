package number;


/**
 *	given a sorted array with duplicates and a number 
 *	find range of (startIndex,endIndex) of that number
 *
 * findRange({ 0, 2, 3, 3, 3, 10, 10 },3) -> output: (2,4)
 * findRange({ 0, 2, 3, 3, 3, 10, 10 },6) -> output: (-1,-1)
 * 
 * FIXME idea is to find the number position using quick sort
 * Once number is found, have two pointers, one to increment and check
 * another to decrement and check until number is not same
 */
public class FindRange {
	public static Range getRange(int[] array, int num) {
		Integer index = getIndex(array, num, 0, array.length);
		if (index == null) {
			System.out.println("start: -1 end: -1");
			return new Range(-1,-1);
		} else {
			int start = index, end = index;

			while (start > 0 && array[start] == array[index]) {
				start--;
			}

			while (end < array.length && array[end] == array[index]) {
				end++;
			}

			System.out.println("start: " + (start + 1) + " End: " + (end - 1));
			for(int i=(start + 1);i<end;i++){
				System.out.print(array[i] + " ");
			}
			System.out.println();
			Range range = new Range(start, end);
			return range;
		}
	}

	private static Integer getIndex(int[] array, int num, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		if (array[mid] == num) {
			return array[mid];
		} else if (array[mid] > num) {
			return getIndex(array, num, mid + 1, end);
		} else {
			return getIndex(array, num, start, mid - 1);
		}
	}

	static class Range {
		int start;
		int end;

		Range(int start, int end) {
			this.start = start;
			this.end = start;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 0, 2, 3, 3, 3, 10, 10 };
		getRange(array, 3);
		getRange(array, 6);
	}
}
