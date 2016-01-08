package string;

import java.util.Arrays;


public class SortListOfStrings {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr = {"rat", "don", "dog", "apple", "mat", "dal"};
		sort(arr);
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+",");
		}
	}

	static void sort(Object[] a) {
		sort(a, 0, a.length);
	}
	
	static void sort(Object[] a, int lo, int hi) {
		int initRunLen = countRunAndMakeAscending(a, lo, hi);
		binarySort(a, lo, hi, lo + initRunLen);
		return;		
	}

	private static int countRunAndMakeAscending(Object[] a, int lo, int hi) {
		assert lo < hi;
		int runHi = lo + 1;
		if (runHi == hi)
			return 1;

		// Find end of run, and reverse range if descending
		if (((Comparable) a[runHi++]).compareTo(a[lo]) < 0) { // Descending
			while (runHi < hi && ((Comparable) a[runHi]).compareTo(a[runHi - 1]) < 0){
				//System.out.print(a[runHi]+",");
				runHi++;
			}
			reverseRange(a, lo, runHi);
		} else {                              // Ascending
			while (runHi < hi && ((Comparable) a[runHi]).compareTo(a[runHi - 1]) >= 0)
				runHi++;
		}

		return runHi - lo;
	}
	
	private static void reverseRange(Object[] a, int lo, int hi) {
        hi--;
        while (lo < hi) {
            Object t = a[lo];
            a[lo++] = a[hi];
            a[hi--] = t;
        }
    }
	
	private static void binarySort(Object[] a, int lo, int hi, int start) {
        assert lo <= start && start <= hi;
        if (start == lo)
            start++;
        for ( ; start < hi; start++) {
            @SuppressWarnings("unchecked")
            Comparable<Object> pivot = (Comparable) a[start];

            // Set left (and right) to the index where a[start] (pivot) belongs
            int left = lo;
            int right = start;
            assert left <= right;
            /*
             * Invariants:
             *   pivot >= all in [lo, left).
             *   pivot <  all in [right, start).
             */
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (pivot.compareTo(a[mid]) < 0)
                    right = mid;
                else
                    left = mid + 1;
            }
            assert left == right;

            /*
             * The invariants still hold: pivot >= all in [lo, left) and
             * pivot < all in [left, start), so pivot belongs at left.  Note
             * that if there are elements equal to pivot, left points to the
             * first slot after them -- that's why this sort is stable.
             * Slide elements over to make room for pivot.
             */
            int n = start - left;  // The number of elements to move
            // Switch is just an optimization for arraycopy in default case
            switch (n) {
                case 2:  a[left + 2] = a[left + 1];
                case 1:  a[left + 1] = a[left];
                         break;
                default: System.arraycopy(a, left, a, left + 1, n);
            }
            a[left] = pivot;
        }
    }
}