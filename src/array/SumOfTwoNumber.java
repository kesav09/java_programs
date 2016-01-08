package array;

import java.util.*;

public class SumOfTwoNumber {
															
	static int [] num = new int[]{5, 3, -1, 10, 6, 9, 15, 1, -3}; 
//	static int [] num = new int[]{1, -2, 3, 6}; 

	public static void main(String [] args){
		findTwoNumberSumToK(num, 15);
//		findTwoNumberSumEqualToK(num, 0);
//		findTwoNumberSumCloseToZero(num);
		TwoSumImplementation two = new TwoSumImplementation();
		two.store(1);
		two.store(-2);
		two.store(3);
		two.store(6);
//		System.out.println(two.test(10));
	}

	//if the array is unsorted
	//time complexity O(n)
	public static void findTwoNumberSumToK(int [] num, int sum){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < num.length; i++){
			if (!set.contains(sum - num[i]))
				set.add(num[i]);
			else
				System.out.print("("+num[i]+","+(sum - num[i])+")"+",");
		}
	}

	//1. sort the array
	//2. keep track of the minimum
	public static void findTwoNumberSumCloseToZero(int [] num){
		int i = 0;
		int j = num.length - 1;
		int nextsum = 0;
		int minsum = Integer.MAX_VALUE;
		int minIndex = 0;
		int maxIndex = 0;
		
		while (i < j){	
			nextsum = num[i] + num[j];
			
			if (Math.abs(nextsum) < Math.abs(minsum)) {
				minsum = nextsum;
				minIndex = i;
				maxIndex = j;
			}
			
			if (nextsum > 0) j--;
			if (nextsum < 0) i++;
		}
		System.out.println("sum "+minsum);
		System.out.println("i = "+minIndex);
		System.out.println("j = "+maxIndex);
	}
}

interface TwoSum{
	public void store(int input);
	public boolean test(int test);
}

class TwoSumImplementation implements TwoSum{
	
	static ArrayList<Integer> array = new ArrayList<Integer>();
	
	public void store(int input){
		array.add(input);
	}
	
	public boolean test(int test) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < array.size(); i++){
			if (!set.contains(test - array.get(i)))
				set.add(array.get(i));
			else{
				System.out.print("("+array.get(i)+","+(test - array.get(i))+")"+",");
				return true;
			}
		}
		return false;
	}
}
