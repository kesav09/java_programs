package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * This has answers for most of the tree related questions
 * @author kvenkata
 *
 */
class BinaryTree {
	
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		tree.insert(100);
		tree.insert(50);
		tree.insert(20);
		tree.insert(30);
		tree.insert(60);
		tree.insert(150);
		tree.insert(110);
		tree.insert(130);
		tree.insert(120);
		tree.insert(90);
		tree.insert(750);
		tree.printTree();
		tree.doubleTree();
		tree.printTree();
		List<Node> paths = tree.hasPathNodeSum(700);
		if (paths == null){
			System.out.println("Sum can not be found");
		} else {
			for (Node node:paths){
				System.out.print(node.value+" ");
			}
		}
		List<Integer> nodes = new LinkedList<Integer>();
		tree.getPreorder(nodes);
		System.out.println(nodes.toString());
		
		
	}
	private Node root;
	
	private static class Node{
		Node left;
		Node right;
		int value;
		
		Node(int val){
			value = val;
			left = null;
			right = null;
		}
	}
	
	BinaryTree(){
		root = null;
	}
	
	public void insert(int val){
		root = insert(root,val);
	}
	
	public Node insert(Node node,int val){
		if (node == null){
			node = new Node(val);
		} else {
			if (val <= node.value){
				node.left = insert(node.left,val);
			} else {
				node.right = insert(node.right,val);
			}
		}
		return node;
	}
	/** 
	 Returns the max root-to-leaf depth of the tree. 
	 Uses a recursive helper that recurs down to find 
	 the max depth. 
	*/ 
	public int getMaxLeafHeight(){//maxDepth
		return getMaxLeafHeight(root);
	}
	
	private int getMaxLeafHeight(Node node){
		if (node == null) return 0;
		else
		return 1 + Math.max(getMaxLeafHeight(node.left), getMaxLeafHeight(node.right));
	}
	
	public int getMinLeafHeight(){//maxDepth
		return getMinLeafHeight(root);
	}
	
	private int getMinLeafHeight(Node node){
		if (node == null) return 0;
		else
		return 1 + Math.min(getMinLeafHeight(node.left), getMinLeafHeight(node.right));
	}
	
	
	
	/** 
	 Returns the number of nodes in the tree. 
	 Uses a recursive helper that recurs 
	 down the tree and counts the nodes. 
	*/ 
	public int totalNode(){// size
		return totalNode(root);
	}
	
	private int totalNode(Node node){
		if (node == null) return 0;
		else
		return 1 + totalNode(node.left) + totalNode(node.right);
	}
	
	/** 
	 Given a tree and a sum, returns true if there is a path from the root 
	 down to a leaf, such that adding up all the values along the path 
	 equals the given sum.
	 Strategy: subtract the node value from the sum when recurring down, 
	 and check to see if the sum is 0 when you run out of tree. 
	*/ 
	public boolean hasPathSum(int sum){
		return hasPathSum(root,sum);
	}
	
	private boolean hasPathSum(Node node, int sum){
		if (node == null) return (sum == 0);
		else {
			int rem = sum - node.value;
			return (hasPathSum(node.right , rem) || hasPathSum(node.left, rem));
		}		
	}
	
	/** 
	 Given a tree and a sum, returns true if there is a path from the root 
	 down to a leaf, such that adding up all the values along the path 
	 equals the given sum.
	 Strategy: subtract the node value from the sum when recurring down, 
	 and check to see if the sum is 0 when you run out of tree. 
	*/ 
	public List<Node> hasPathNodeSum(int sum){
		return hasPathNodeSum(root,sum,0,new LinkedList<Node>());
	}
	
	private List<Node> hasPathNodeSum(Node node, int sum, int prev_sum, List<Node> paths){
		if (node == null){
			return null;
		}
		
		prev_sum += node.value;
		
		if (node.left == null && node.right == null && prev_sum == sum){
			paths.add(node);
			return paths;
		} else if (node.left == null && node.right == null) {
			return null;
		}
		
		paths.add(node);
		List<Node> left = hasPathNodeSum(node.left,sum,prev_sum,paths);
		List<Node> right = hasPathNodeSum(node.right,sum,prev_sum,paths);
		if (left == null && right == null){
			paths.remove(node);
			return null;
		}
		return paths;
	}
	
	
	/** 
	 Returns the min value in a non-empty binary search tree. 
	 Uses a helper method that iterates to the left to find 
	 the min value. 
	*/ 
	public int getMinVal(){
		return getMinVal(root);
	}
	
	private int getMinVal(Node node){
		while (node.left != null){
			node = node.left;
		}
		return node.value;
	}
	
	/** 
	 Returns the min value in a non-empty binary search tree. 
	 Uses a helper method that iterates to the left to find 
	 the min value. 
	*/ 
	public Node getMinNode(){
		return getMinNode(root);
	}
	
	private Node getMinNode(Node node){
		while (node.left != null){
			node = node.left;
		}
		return node;
	}
	
	/** 
	 Returns the max value in a non-empty binary search tree. 
	 Uses a helper method that iterates to the right to find 
	 the max value. 
	*/ 
	public int getMaxVal(){
		return getMaxVal(root);
	}
	
	private int getMaxVal(Node node){
		while (node.right != null){
			node = node.right;
		}
		return node.value;
	}
	
	/** 
	 Returns the max value in a non-empty binary search tree. 
	 Uses a helper method that iterates to the right to find 
	 the max value. 
	*/ 
	public Node getMaxNode(){
		return getMaxNode(root);
	}
	
	private Node getMaxNode(Node node){
		while (node.right != null){
			node = node.right;
		}
		return node;
	}
	
	/** 
	 Prints the node values in the "inorder" order. 
	 Uses a recursive helper to do the traversal. 
	*/ 
	public void printTree(){
		printTree(root);
		System.out.println(); 
	}
	
	private void printTree(Node node){
		if (node == null) return;
		
		printTree(node.left);
		System.out.print(node.value+ "  ");
		printTree(node.right);
	}
	
	/**
	 * print postOrder
	 */
	public void printPostorder(){
		printPostorder(root);
		System.out.println();
	}
	
	private void printPostorder(Node node){
		if (node == null) return;
		
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.value + " ");
	}
	
	/**
	 * print preOrder
	 */
	public void printPreorder(){
		printPreorder(root);
		System.out.println();
	}
	
	private void printPreorder(Node node){
		if (node == null) return;

		System.out.print(node.value + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	/**
	 * print preOrder
	 */
	public void getPreorder(List<Integer> nodes){
		getPreorder(root,nodes);
		System.out.println();
	}
	
	private void getPreorder(Node node,List<Integer> nodes){
		if (node == null) return;

		System.out.print(node.value + " ");
		nodes.add(node.value);
		getPreorder(node.left,nodes);
		getPreorder(node.right,nodes);
	}
	
	/** 
	 Changes the tree into its mirror image.

	 So the tree... 
	       4 
	      / \ 
	     2   5 
	    / \ 
	   1   3

	 is changed to... 
	       4 
	      / \ 
	     5   2 
	        / \ 
	       3   1

	 Uses a recursive helper that recurs over the tree, 
	 swapping the left/right pointers. 
	*/ 
	public void mirror(){
		mirror(root);
	}
	
	private void mirror(Node node){
		if (node == null) return;
		
		// do the sub-trees 
	    mirror(node.left); 
	    mirror(node.right);
	    
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
	
	public boolean sameTree(Node tree){
		return sameTree(root,tree);
	}
	
	private boolean sameTree(Node tree1, Node tree2){
		if (tree1 == null && tree2 == null){
			return true;
		}else if (tree1 != null && tree2 != null){
			return sameTree(tree1.left,tree2.right) && sameTree(tree1.right,tree2.right) && tree1.value == tree2.value;
		}else {
			return false;
		}
	}
	
	/** 
	  Efficient BST helper -- Given a node, and min and max values, 
	  recurs down the tree to verify that it is a BST, and that all 
	  its nodes are within the min..max range. Works in O(n) time -- 
	  visits each node only once. 
	*/ 
	public boolean isBST(){
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean isBST(Node node, int min, int max){
		if (node == null){
			return true;
		} else {
			if (node.value <= min || node.value >= max)
				return false;
			return isBST(node.left,min,node.value) && isBST(node.right,node.value,max);
			/*// left should be in range  min...node.data 
			boolean isLeftOK = isBST(node.left, min, node.value);
			// if the left is not ok, bail out 
			if (!isLeftOK) return false;
			
			// right should be in range node.data+1..max 
			boolean isRightOK = isBST(node.right, node.value + 1, max);
			return isRightOK;*/
		}
	}
	
	/** 
	 Changes the tree by inserting a duplicate node 
	 on each nodes's .left. 
	  
	 
	 So the tree... 
	    2 
	   / \ 
	  1   3

	 Is changed to... 
	       2 
	      / \ 
	     2   3 
	    /   / 
	   1   3 
	  / 
	 1

	 Uses a recursive helper to recur over the tree 
	 and insert the duplicates. 
	*/ 
	public void doubleTree() { 
	 doubleTree(root); 
	}

	private void doubleTree(Node node) {
	  if (node == null) return;

	  // do the subtrees 
	  doubleTree(node.left); 
	  doubleTree(node.right);

	  // duplicate this node to its left 
	  Node oldLeft = node.left; 
	  node.left = new Node(node.value); 
	  node.left.left = oldLeft; 
	} 
	 
	/**
	 An empty tree is height-balanced. A non-empty binary tree T is balanced if:
	1) Left subtree of T is balanced
	2) Right subtree of T is balanced
	3) The difference between heights of left subtree and right subtree is not more than 1.
	 */
	public boolean isBalanced(){
		return isBalanced(root);
	}
	
	private boolean isBalanced(Node node){
		if (node == null){
			return true;
		}
		
		boolean isLeftBalanced = isBalanced(node.left);
		boolean isRightBalanced = isBalanced(node.right);
		
		return isLeftBalanced && isRightBalanced && (Math.abs(getMaxLeafHeight(node.left) - getMaxLeafHeight(node.right)) <= 1);
		
	}
	
	public boolean isHeightBalanced(){
		return (getMaxLeafHeight(root) - getMinLeafHeight(root)) <= 1; 
	}
	
	
	public void deleteNode(int i){
		deleteNode(i,root);
	}
	
	private void deleteNode(int i,Node node){
		if (node == null){
			return ;
		}
		
		// If value is smaller than node value then value which needs to be deleted is on left side of tree
		if (i < node.value){
			deleteNode(i,node.left);
		}
		// If value is greater than node value then value which needs to be deleted is on right side of tree
		else if (i > node.value){
			deleteNode(i,node.right);
		} else {
			if (node.left == null && node.right == null){
				node = null;
				return;
			}
			if ((node.left != null) && (node.right != null)) {
                // node with two children
                node.value = findMinimumAndReturnWithDelete(node.right);
                return;
            }
			// When node u want to delete does not have left childs
			if (node.left != null){
				node = node.left;
			}
			// When node u want to delete does not have right childs
			else if (node.right != null){
				node = node.right;
			}
		}
	}
	
	private int findMinimumAndReturnWithDelete(Node node) {
        if (node.left == null) {
            int v = node.value;
            node = null;
            return v;
        }
        return findMinimumAndReturnWithDelete(node.left);
    }
	
	// Remove minimum node from BST
	public Node removeMin(){
		if (root == null){
			return null;
		} else if (root.left != null){
			return removeMin(root);
		} else {
			Node minNode = root;
			root = root.right;
			// No need to set to null as when Node object is created, right/left already set to null
			//minNode.right = null;
			return minNode;
		}
	}
	
	private Node removeMin(Node node){
		if (node.left.left == null){
			Node minNode = node.left;
			node.left = node.left.right;
			// No need to set to null as when Node object is created, right/left already set to null
			//minNode.right = null;
			return minNode;
		} else {
			return removeMin(node.left);
		}
	}

	
	// Convert sorted array to balanced binary search tree http://www.programcreek.com/2013/01/leetcode-convert-sorted-array-to-binary-search-tree-java/
	public void sortedArrayToBST(int[] nums){
		// Solved in differnt class SortedArrayToBST 
		// Sorted array is nothing but tree is traversed in inorder
		// which mean middle element in the array is root and left to middle are in the left time of tree
		// right to middle element in the right side of the tree
		// Time complexity is O(N)
		root = sortedArrayToBST(nums,0,nums.length - 1);
	}
	
	private Node sortedArrayToBST(int[] nums, int start, int end) {
		if (start > end){
			return null;
		}
		int mid = (start + end )/2;
		Node node = new Node(nums[mid]);
		node.left = sortedArrayToBST(nums,start,mid - 1);
		node.right = sortedArrayToBST(nums,mid + 1, end);
		return node;
	}

	// Convert Sorted Linked list to balanced BST http://www.programcreek.com/2013/01/leetcode-convert-sorted-list-to-binary-search-tree-java/
	// Different between array to linkedlist is that, most of the logic remain same
	// expect that we can not access middle on the linked list in O(1)
	public void convertLinkedListToBalancedTree(List<Integer> nums){
		int len = nums.size();
		root = convertLinkedListToBalancedTree(nums,0 , len - 1);
	}
	
	private Node convertLinkedListToBalancedTree(List<Integer> nums, int start,
			int end) {
		if (start > end){
			return null;
		}
		int mid = (start + end)/2;
		Node node = new Node(nums.get(mid));
		node.left = convertLinkedListToBalancedTree(nums,start,mid - 1);
		node.right = convertLinkedListToBalancedTree(nums,mid + 1, end);
		return node;
	}

	//http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
	public void convertBinartyTreeToLinkedList(){
		// TODO
	}
	
	//Print all root to leaf paths in a tree
	public void printPathsFromRootToLeaf(){
		printPathsFromRootToLeaf(root, 0, new int[1000]);
	}
	// We need pathLength otherwise we will not be able to print exactly what is needed
	private void printPathsFromRootToLeaf(Node node, int pathLength, int[] path) {
		if(node == null){
			return;
		} 
		path[pathLength++] = node.value;
		
		if(node.left == null && node.right == null){
			printPath(pathLength,path);
		}
		printPathsFromRootToLeaf(node.left,pathLength,path);
		printPathsFromRootToLeaf(node.right,pathLength,path);
	}
	
	private static void printPath(int pathlength, int[] path) {
		System.out.println();
		System.out.print("Path: ");
		for (int i = 0; i < pathlength; i++) {
			System.out.print(" "+path[i]);
		}
	}
	
	
	// http://www.crazyforcode.com/tree/
	//Print nodes at K distance from root in binary tree
	void printkdistanceNodeDown(int k){
		printkdistanceNodeDown(root,k);
	}
	
	void printkdistanceNodeDown(Node node, int k){
	    // Base Case
	    if (node == null || k < 0)  return;
	 
	    // If we reach a k distant node, print it
	    if (k==0){
	        System.out.println(node.value);
	        return;
	    }
	 
	    // Recur for left and right subtrees
	    printkdistanceNodeDown(node.left, k-1);
	    printkdistanceNodeDown(node.right, k-1);
	}
	
	// Deleting all Leaves from a Binary Tree
	public void deleteAllLeafNodes(){
		deleteAllLeafNodes(root);
	}
	
	private void deleteAllLeafNodes(Node node){
		if (node == null){
			return;
		}
		// If there is something to the left...
		if (node.left != null){
			if (isLeaf(node.left)){
				node.left = null; // delete it if it's a leaf...
			} else {
				deleteAllLeafNodes(node.left); // else recurse.
			}
		}
		
		// If there is something to the right...
		if (node.right != null){
			if (isLeaf(node.right)){
				node.left = null; // delete it if it's a leaf...
			} else {
				deleteAllLeafNodes(node.right); // else recurse.
			}
		}
		
	}
	private boolean isLeaf(Node node) {
		if (node == null || (node.left == null && node.right == null)){
			return true;
		}
		return false;
	}

	// Populate each next pointer to point to its next right node http://www.crazyforcode.com/populate-next-pointer-point-next-right-node/
	/*public void connectTree(Node root) {
	    if(root==null){
	        return;
	    }
	    if(root.left!=null){
	        root.left.next = root.right;
	    }
	    if(root.right!=null){
	        if(root.next!=null){
	            root.right.next = root.next.left;
	        }
	        else{
	            root.right.next = null;
	        }
	    }
	     
	    connectTree(root.left);
	    connectTree(root.right);
	}*/

	//Print BST elements in range K1 and K2
	public void printBSTWithInRange(int K1, int K2){
		printBSTWithInRange(K1, K2, root);
	}
	
	private void printBSTWithInRange(int K1, int K2, Node node){
		if (node == null){
			return;
		}
		printBSTWithInRange(K1, K2, node.left);
		if (K1 < node.value && node.value < K2){
			System.out.println(node.value);
		}
		printBSTWithInRange(K1, K2, node.right);
	}
	// TODO Recursive Spiral Order Traversal of Tree
	// TODO Cousin nodes in Binary Tree
	// Level of a given node in binary tree http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
	public int getLevelOfNode(int data){
		return getLevelOfNode(root, data, 1);
	}
	
	private int getLevelOfNode(Node node, int data, int level){
		if (node == null){
			return 0;
		}
		
		if (node.value == data){
			return level;
		}
		
		int downLevel = getLevelOfNode(node.left, data , level + 1);
		if (downLevel != 0) {
			return downLevel;
		}
		
		downLevel = getLevelOfNode(node.right, data , level + 1);
		return downLevel;
	}
	
	//Maximum Path Sum in a Binary Tree http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
	public int getMaxPathSum(){
		return getMaxPathSum(root);
	}
	
	private int getMaxPathSum(Node node){
		if (node == null){
			return 0;
		} else if (node.left == null && node.right == null){
			return node.value;
		} else {
			return Math.max(node.value + getMaxPathSum(node.left) , node.value + getMaxPathSum(node.right));
		}
	}

	//Check if a binary tree is subtree of another tree http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
	public boolean isSubtree(Node node){
		return isSubtree(root,node);
	}
	
	// Complexity O(M*N)
	// FIXME To get in O(N) follow http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
	private boolean isSubtree(Node tree1, Node tree2){
		if (tree1 == null && tree2 == null){
			return true;
		} else if (tree1 == null || tree2 == null){
			return false;
		} 
		
		if (sameTree(tree1, tree1)){
			return true;
		}
		
		/* If the tree with root as current node doesn't match then
	       try left and right subtrees one by one */
		return isSubtree(tree1.left, tree2) ||
				isSubtree(tree1.right, tree2);
		
		
	}
	//Find largest BST in a binary tree http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
	public int largestBST(){
		return largestBST(root);
	}
	
	private int largestBST(Node node){
		if (isBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE)){
			return totalNode(node);
		} else {
			return Math.max(largestBST(node.left), largestBST(node.right));
		}
	}
	
	//Binary Tree diff of sum of nodes at odd and sum of nodes at even levels
	/**
	 * The problem can also be solved using simple recursive traversal. We can recursively calculate the required difference as, 
	 * value of root’s data subtracted by the difference for subtree under left child and the difference for subtree under right child.
	 */
	public int getLevelDiff(){
		return getLevelDiff(root);
	}
	
	private int getLevelDiff(Node node){
		if (node == null){
			return 0;
		}
		// Difference for root is root's data - difference for left subtree
		// - difference for right subtree
		return node.value - getLevelDiff(node.left) - getLevelDiff(node.right);
	}
	
	
	//Diameter of a Tree http://www.cs.duke.edu/courses/spring00/cps100/assign/trees/diameter.html
	public int diameter(){
		return diameter(root);
	}
	private int diameter(Node node){
		if (node == null){
			return 0;
		}
		
		int lheight = getMaxLeafHeight(node.left);
		int rheight = getMaxLeafHeight(node.right);
		
		int ldiameter = diameter(node.left);
		int rdiameter = diameter(node.right);
		
		return Math.max(lheight + rheight + 1,
				Math.max(ldiameter,rdiameter));
	}
	
	//Replace node with sum of left and right subtree http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
	public int toSumTree(){
		return toSumTree(root);
	}
	private int toSumTree(Node node){
		if (node == null){
			return 0;
		}
		
		int oldVal = node.value;
		node.value = toSumTree(node.left) + toSumTree(node.right);
		
		return node.value + oldVal;
	}
	// Check for Children Sum Property in a Binary Tree http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
	public boolean isSumProperty(){
		return isSumProperty(root);
	}
	
	private boolean isSumProperty(Node node){
		if (node == null){
			return true;
		}
		
		int left_data = 0 , right_data = 0;
		if (node.left != null){
			left_data = node.left.value;
		}
		
		if (node.right != null){
			right_data = node.right.value;
		}
		
		if ((node.value == left_data + right_data) && isSumProperty(node.left) && isSumProperty(node.right)){
			return true;
		} else {
			return false;
		}
	}
	//Inorder Predecessor in Binary Search Tree http://www.crazyforcode.com/inorder-predecessor-binary-search-tree/
	//The predecessor of a node x in a search tree is the node with largest key that belongs to the tree and that is strictly less than x’s key.
	public Node getInOrderPredecessor(Node node){
		if (node == null || root == null){
			return null;
		}
		return getInOrderPredecessor(node, root);
	}
	
	private Node getInOrderPredecessor(Node node, Node root){
		// step 1 of the above algorithm
		if (node.left != null){
			return getMaxNode(node.left);
		}
		Node prec = null;
		// Start from root and search for successor down the tree
		while (root != null){
			if (node.value < root.value){
				root = root.left;
			} else if (node.value > root.value){
				prec = root;
				root = root.right;
			} else {
				break;
			}
		}
		return prec;
	}
	// Inorder Successor in Binary Search Tree http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
	// Inorder successor of a node is the next node in Inorder traversal of the Binary Tree. Inorder Successor is NULL for the last node in Inoorder traversal.
	public Node getInOrderSuccessor(Node node){
		if (node == null || root == null){
			return null;
		}
		return getInOrderSuccessor(node, root);
	}
	
	private Node getInOrderSuccessor(Node node, Node root){
		// step 1 of the above algorithm
		if (node.right != null){
			return getMinNode(node.right);
		}
		
		Node succ = null;
		// Start from root and search for successor down the tree
		while (root != null){
			if (node.value < root.value){
				succ = root;
				root = root.left;
			} else if (node.value > root.value){
				root = root.right;
			} else {
				break;
			}
		}
		return succ;
	}
	//Print all ancestors of a node in binary tree
	public boolean printAncestors(int val){
		return printAncestors(root , val);
	}
	
	private boolean printAncestors(Node node, int val){
		if (node == null){
			return false;
		}
		
		if (node.value == val){
			return true;
		}
		
		/* If target is present in either left or right subtree of this node,
	     then print this node */
		if (printAncestors(node.left , val) || printAncestors(node.right , val)){
			System.out.println(node.value);
			return true;
		}
		return false;
	}
	//Lowest common ancestor in a Binary Tree. (LCA) http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	public Node findLCAInNonBST(int a, int b){
		return findLCAInNonBST(root, a, b);
	}
	private Node findLCAInNonBST(Node node, int a, int b){
		if(node == null){
			return null;
		}
		
		if(node.value == a || node.value == b){
			return node;
		}
		
		Node l = findLCAInNonBST(node.left,a,b);
		Node r = findLCAInNonBST(node.right,a,b);
		
		if(l!=null && r!=null){
			return node;
		}
		
		return l!=null ? l : r;
	}
	// Lowest common ancestor in a Binary Search Tree. (LCA) http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	public Node findLca(int key1, int key2){
		return findLca(root, key1, key2);
	}
	
	private Node findLca(Node node, int key1, int key2){
		if (node == null){
			return null;
		}
		
		// If both n1 and n2 are smaller than root, then LCA lies in left
	    if (node.value > key1 && node.value > key2)
	        return findLca(node.left, key1, key2);
	 
	    // If both n1 and n2 are greater than root, then LCA lies in right
	    if (node.value < key1 && node.value < key2)
	        return findLca(node.right, key1, key2);
	 
	    return node;
		
	}
	
	// Code to count the number of leaves in a tree
	public int getNumberOfLeafNodes(){
		return getNumberOfLeafNodes(root);
	}
	
	private int getNumberOfLeafNodes(Node node){
		if (node == null){
			return 0;
		}
		if (node.left == null && node.right == null){
			return 1;
		} else {
		return getNumberOfLeafNodes(node.left) + getNumberOfLeafNodes(node.right);
		}
	}
	
	// Given a binary search tree, please check whether there are two nodes in it whose sum equals a given value.(http://codercareer.blogspot.com/2013/03/no-46-nodes-with-sum-in-binary-search.html)
	public boolean isPairPresent(int val){
		return isPairPresent(root, val);
	}
	
	public boolean isPairPresent(Node node, int sum){
		if (node == null) return false;
		else {
			int val1 = 0;
			int val2 = 0;
			boolean done1 = false;
			boolean done2 = false;

			java.util.Stack<Node> stack1 = new Stack<Node>();
			java.util.Stack<Node> stack2 = new Stack<Node>();

			Node curr1 = node;
			Node curr2 = node;
			
			//inorder traversal
			while(true){
				while (done1 == false){
					if(curr1 != null){
						stack1.push(curr1);
						curr1 = curr1.left;
					}else{
						if(stack1.isEmpty())
							done1 = true;
						else{
							curr1 = stack1.pop();
							val1 = curr1.value;
							curr1 = curr1.right;
							done1 = true;
						}
					} 
				}

				//reverse inorder traversal
				while (done2 == false){
					if(curr2 != null){
						stack2.push(curr2);
						curr2 = curr2.right;
					}else{
						if(stack2.isEmpty())
							done2 = true;
						else{
							curr2 = stack2.pop();
							val2 = curr2.value;
							curr2 = curr2.left;
							done2 = true;
						}
					} 
				}

				if (val1 + val2 > sum){
					done2 = false;
				}else if (val1 + val2 < sum){
					done1 = false;
				}else{
					System.out.print("("+"val1 = "+val1+","+"val2 = "+val2+")"+",");
					return true;
				}
				
				if (curr1 == null && stack1.isEmpty() || curr2 == null && stack2.isEmpty())
					return false;
			}
		}
	}
	// TODO binary tree to BST conversion http://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
	// TODO serialize and deserialize a binary tree http://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
	
	//DFS visit a child, then that child's child and so forth, when you reach as far as you 
	// can go via a child, x,  you move back up a level and continue the process with the sibling of x (call it y)
	public static void dfs(Node root){
	     if(root == null)
	        return;
	     System.out.println(root.value);
	     dfs(root.left);
	     dfs(root.right);
	}
	//BFS visit all children, then grandchildren, then great-grandchildren, etc..
	public static void bfs(Node root){
	     Queue<Node> queue = new LinkedList<Node>();
	     queue.add(root);
	     while (!queue.isEmpty()) {
	         Node node = queue.poll();
	         System.out.println(node.value);
	         if (node.left != null) queue.add(node.left);
	         if (node.right != null) queue.add(node.right);
	     }
	}
	//Print in-order traversal iteratively
	public void printInOrderIteratively(){
		printInOrderIteratively(root);
	}
	
	private void printInOrderIteratively(Node root){
		if (root == null) return;
		Node node = root;
		Stack<Node> stack = new Stack<Node>();
		while( ! stack.isEmpty( ) || node != null ){
			if( node != null ) {
				stack.push( node );
				node = node.left;
			}
			else {
				node = stack.pop( );
				System.out.print( node.value + " " );
				node = node.right;
			}

		}
	}
	
	//Print pre-order traversal iteratively
	public void printPreOrderIteratively(){
		printPreOrderIteratively(root);
	}
	
	private void printPreOrderIteratively(Node root){
		if( root == null ) return;
		Stack<Node> stack = new Stack<Node>( );
		stack.push( root );
		while( ! stack.isEmpty( ) ) {
			Node current = stack.pop( );
			if( current.right != null ) 
				stack.push( current.right );
			if( current.left != null ) 
				stack.push( current.left );
			System.out.print( current.value + " " );
		}
	}
	
	//Print post-order traversal iteratively
	public void printPostOrderIteratively(){
		printPostOrderIteratively(root);
	}
	
	private void printPostOrderIteratively(Node root){
		if( root == null ) return;
		Stack<Node> stack = new Stack<Node>( );
		Node current = root;
		while( true ) {
			if( current != null ) {
				if( current.right != null ) stack.push( current.right );
				stack.push( current );
				current = current.left;
				continue;
			}
			if( stack.isEmpty( ) ) return;
			current = stack.pop( );
			if( current.right != null && ! stack.isEmpty( ) && current.right == stack.peek( ) ) {
				stack.pop( );
				stack.push( current );
				current = current.right;
			}else {
				System.out.print( current.value + " " );
				current = null;
			}				
		}			
	}
	public void IpostOrder(Node rt)
	{  
	  Stack<Node> s1= new Stack<Node>( );
	  Stack<Node> s2= new Stack<Node>( );
	   
	  Node temp;
	  s1.push(rt);
	  while(!s1.isEmpty()){
	      temp=(Node) s1.pop();
	      s2.push(temp);
	      if(temp.left!=null)
	          s1.push(temp.left);
	      
	      if(temp.right!=null)
	          s1.push(temp.right);
	   }
	     
	  while(!s2.isEmpty()){
	      Node x=(Node) s2.pop();
	       System.out.print(x.value+"  ");
	  }
	     
	}
}
