package tree;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 * Given an array of numbers, return true if given array can represent preorder traversal 
 * of a Binary Search Tree, else return false. Expected time complexity is O(n).
 * @author kvenkata
 */
public class CanRepresentBST {
	public static void main(String[] args){
		//int pre1[] = {40, 30, 35, 80, 100};
		int pre1[] = {2,4,1};
		Stack<Integer> s = new Stack<Integer>();
		int root = Integer.MIN_VALUE;
		for (int i = 0; i < pre1.length; i++){
			if (pre1[i] < root){
				System.out.println("Can not form BST");
				break;
			}
			
			while (!s.isEmpty() && s.peek() < pre1[i]){
				root = s.pop();
			}
			s.push(pre1[i]);
		}
		System.out.println("Can form BST");
	}
}
