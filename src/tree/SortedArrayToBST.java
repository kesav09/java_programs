package tree;

public class SortedArrayToBST {
	// Definition for binary tree
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	 
		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	
	public static TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return sortedArrayToBST(num, 0, num.length - 1);
	}
 
	private static TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
 
		return root;
	}
	
	public static void main(String[] args){
		int[] nums = {1,3,5,6,9};
		TreeNode root = sortedArrayToBST(nums);
		System.out.println(heightOfTree(root));
		printTree(root);
	}
	
	public static void printTree(TreeNode node){
		if (node == null) return;
		
		printTree(node.left);
		System.out.print(node.val+" ");
		printTree(node.right);
	}
	
	public static int heightOfTree(TreeNode node){
		if (node == null){
			return 0;
		}
		
		return 1 + Math.max(heightOfTree(node.left),heightOfTree(node.right));
	}
}
