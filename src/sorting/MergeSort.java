
//algorithm belongs to Divide & Conquer class of Algorithms
//we keep on dividing the list into half until only one element is left in the list. 
//Dividing the list into halves takes logn time. 
//merge function's complexity is O(n)

package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSort {

	static int [] num = new int[]{4, 1, 9, 6, 3, 15, 19, 17, 18};

	public static void main(String [] args){

		display(mergesort(num));
	}

	public static int[] mergesort(int[] num) {
		if (num.length <= 1)
			return num;
		int middle = num.length / 2;
		int left[] = new int[middle];
		int right[] = new int[num.length-middle];

		for (int i = 0; i < middle; i++) {
			left[i] = num[i];
		}

		for (int i = middle, j = 0; i < num.length && j < right.length; i++, j++) {
			right[j] = num[i];
		}

		left = mergesort(left);
		right = mergesort(right);

		int[] result = merge(left, right);

		return result;
	}

	public static int[] merge(int a[], int b[]) {
		int result[] = new int[a.length + b.length];
		int j = a.length - 1;
		int k = b.length - 1;
		int i = j + k + 1;
		while (j >= 0 || k >= 0) {
			if (j >= 0 && k >= 0) {
				if (a[j] >= b[k]) {
					result[i] = a[j];
					// remove from a
					--j;
				} else {
					result[i] = b[k];
					// remove from b
					--k;
				}
			} else if (j >= 0) {
				result[i] = a[j];
				--j;
				// remove from a
			} else {
				result[i] = b[k];
				--k;
			}
			--i;

		}
		return result;
	}

	public static void display(int [] num){
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i]+",");
		System.out.println("");
	}

	//Simple N-Way Merge Algorithm

	public static List<Integer> mergeN(List<List<Integer>> data){
		int totalSize = 0;
		for(List<Integer> l:data)
			totalSize = totalSize + l.size();

		List<Integer> result = new ArrayList<Integer>();
		List<Integer> min ;

		while(result.size()<totalSize){
			min = null;
			for(List<Integer> l: data){

				if(min==null)
					min = l;
				else if(l!=null && l.get(0)<min.get(0)){
					min = l;
				}
			}

			result.add(min.get(0));
			min.remove(0);
		}

		return result;

	} 

	//N - Way Merge using PriorityQueue

	public static List<Integer> mergeNPriorityQueue(List<List<Integer>> data) {
		int totalSize = 0;
		for (List<Integer> l : data)
			totalSize = totalSize + l.size();

		List<Integer> result = new ArrayList<Integer>();

		Queue<List<Integer>> q = new PriorityQueue<List<Integer>>(data.size(),
				new Comparator<List<Integer>>() {
			public int compare(List<Integer> l1, List<Integer> l2) {
				return l1.get(0).compareTo(l2.get(0));

			}

		});
		List<Integer> min = null;
		while (result.size() < totalSize) {
			min = null;
			for (List<Integer> tmp : data) {
				q.add(tmp);
			}
			min = q.poll();
			result.add(min.remove(0));
			if (min != null && min.size() > 0)
				q.add(min);
		}
		return result;

	}
}
