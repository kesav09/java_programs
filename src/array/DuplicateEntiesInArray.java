package array;

/*
 * Given an array of integers, find if the array contains any 
 * duplicates. Your function should return true if any value appears
 * at least twice in the array, and it should return false if every element is distinct.
 * https://leetcode.com/problems/contains-duplicate/
 */

	
import java.util.HashSet;
import java.util.Set;

public class DuplicateEntiesInArray {
	public static void main(String[] args){
		int[] arry = {1,2,3,1,5};
		System.out.println(containsDuplicate(arry));
	}
	
	public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 1){
            return false;
        }
        Set<Integer> arry = new HashSet<Integer>();
        for (Integer num: nums){
            if (arry.contains(num)){
                return true;
            }
            arry.add(num);
        }
        return false;
    }
}
