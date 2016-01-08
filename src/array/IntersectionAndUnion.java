package array;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class IntersectionAndUnion {

	static int [] num1 = new int[]{3, 5, 6};
	static int [] num2 = new int[]{3, 5, 6};
	
	public static void main(String [] args){
//		findIntersection(num1, num2);
//		findUnion(num1, num2);
		findUnionIfSorted(num1, num2);
		findIntersectionIfSorted(num1, num2);
	}
	
	//using HashSet
	//time complexity : O(n) + O(n) = 2 O(n) = O(n)
	public static void findIntersection(int [] num1, int [] num2){
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> result = new ArrayList<Integer>(); 
		
		for (int i = 0 ; i < num2.length; i++) set.add(num2[i]);
		for (int i = 0; i < num1.length; i++){
			if (set.contains(num1[i])) {
				if (!result.contains(num1[i])) result.add(num1[i]);
			}
		}
		
		System.out.println(result);
	}
	
	//using hashset
	public static void findUnion(int [] num1, int [] num2){
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0 ; i < num1.length; i++) result.add(num1[i]);
		
		for (int i = 0 ; i < num1.length; i++) set.add(num1[i]);
		
		for (int i = 0; i < num2.length; i++){
			if (!set.contains(num2[i])) {
				result.add(num2[i]);
			}
		}
		System.out.println(result);
	}
	
	//if both are sorted arrays
	public static void findUnionIfSorted(int [] num1, int [] num2){
		
		int indexNum1 = 0;
		int indexNum2 = 0;
		List<Integer> result = new ArrayList<Integer>(); 
		
		while(indexNum1 < num1.length && indexNum2 < num2.length){
				
			if (num1[indexNum1] < num2[indexNum2]){
				result.add(num1[indexNum1]);
				indexNum1++;
			}else if (num1[indexNum1] > num2[indexNum2]){
				result.add(num2[indexNum2]);
				indexNum2++;
			}else{
				result.add(num1[indexNum1]);
				indexNum1++;
				indexNum2++;
			}
			
		}
		
		while (indexNum2 < num2.length) result.add(num2[indexNum2++]);
		while (indexNum1 < num1.length) result.add(num1[indexNum1++]);
		
		System.out.println(result);
	}
	
	public static void findIntersectionIfSorted(int [] num1, int [] num2){
		
		int indexNum1 = 0;
		int indexNum2 = 0;
		List<Integer> result = new ArrayList<Integer>(); 
		
		while(indexNum1 < num1.length && indexNum2 < num2.length){
				
			if (num1[indexNum1] == num2[indexNum2]){
				result.add(num1[indexNum1]);
				indexNum1++;
				indexNum2++;
			}else if (num1[indexNum1] < num2[indexNum2])
				indexNum1++;
			else
				indexNum2++;
		}
		System.out.println(result);
	}
	
}
