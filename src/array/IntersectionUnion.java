package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionUnion{
	
	public static void main(String[] args){
		int[] array1 = {1,2,3};
		int[] array2 = {3,4,5};
		
		Object[] array3 = getIntersection(array1, array2);
		Object[] array4 = getUnion(array1,array2);
		
		print(array3);
		print(array4);
	}
	
	//COMPLEXITY: O(n) + O(n) = O(2n) ~ O(n)
	public static Object[] getIntersection(int[] array1, int[] array2){
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for(int i:array1){
			set.add(i);
		}
		
		for(int j:array2) {
			if(set.contains(j)) {
				list.add(j);
			}
		}
		return  list.toArray();
	}

	//COMPLEXITY: O(n) + O(n) = O(2n) ~ O(n)
	public static Object[] getUnion(int[] array1, int[] array2){
		Set<Integer> set = new HashSet<Integer>();
		for(int i: array1) {
			set.add(i);
		}
		
		for(int j:array2) {
			set.add(j);
		}
		
		return set.toArray();
	}
	
	public static void print(Object[] array) {
		System.out.println("Printing array: ");
		for(Object i: array){
			System.out.println(i);
		}
	}
}