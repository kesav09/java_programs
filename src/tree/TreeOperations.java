package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class TreeOperations {

	public static void main(String[] args) {
	
		newTree tree = new newTree(100);
		tree.left = new newTree(50);tree.right = new newTree(150);
		tree.left.left = new newTree(25); tree.left.right = new newTree(75); tree.right.left = new newTree(125); tree.right.right = new newTree(175);
		tree.left.left.left = new newTree(20);tree.left.left.left.left = new newTree(15);tree.left.left.left.left.left= new newTree(10);tree.left.left.left.left.left = new newTree(5);
		System.out.println("height: "+getHeight(tree));
		System.out.println("size: "+getSize(tree));
		System.out.println("get min value: "+getMinValue(tree));
		printPathsFromRootToLeaf(tree, 0, new int[1000]);
		System.out.println();
		System.out.println(hasSumFromRootToLeaf(tree,425));
		System.out.println();
		System.out.print("tree paths after mirroring:");
		mirror(tree);
		printPathsFromRootToLeaf(tree, 0, new int[1000]);
		System.out.println();
		
		newTree tree2 = new newTree(100);
		System.out.println(isSameTree(tree,tree2));
		System.out.println();
		
		newTree tree3 = new newTree(100);
		tree3.left = new newTree(50);tree3.right = new newTree(150);
		tree3.left.left = new newTree(25); tree3.left.right = new newTree(75); tree3.right.left = new newTree(125); tree3.right.right = new newTree(175);
		
		System.out.println(isSubTree(tree,tree3,false));
		
		mirror(tree);
		newTree t = findLCAInNonBST(tree, 20, 75);
		System.out.println("LCA: "+ t.data);

		System.out.println("Level order: ");
		printLevelOrder(tree);
		System.out.println();
		System.out.println("Zig Zag: ");
		printZigZag(tree);
		System.out.println();
		
		/*newTree tree1 = new newTree(-2);
		tree1.left = new newTree(1); */ 	// this case fails for maxPathSum due to number rotation when we add a value to Integer.MIN_VALUE.
		System.out.println("max sum: "+ maxPathSum(tree));
	}

	public static int getHeight(newTree tree) {
		if (tree == null) {
			return 0;
		}

		return 1 + Math.max(getHeight(tree.left), getHeight(tree.right));
	}
	
	public static boolean hasSumFromRootToLeaf(newTree tree, int sum){
		if(tree == null){
			return false;
		}
		
		sum = sum - tree.data;
		if(tree.left == null && tree.right == null) {
			if(sum == 0){
				return true;
			}
		}
		
		return (hasSumFromRootToLeaf(tree.left,sum) || hasSumFromRootToLeaf(tree.right,sum));
	
	}

	/**
	 * 0,new int[1000], root, 12
	 */
	public static void PrintPathEqualToSum(int pathLen, int[] paths, newTree root, int sum) {
		if (root == null) {
			return;
		}

		sum = sum - root.data; 
		paths[pathLen++] = root.data;
		if (sum == 0) {
			System.out.println();
			for (int i = 0; i < pathLen; i++) {
				System.out.print(" " + paths[i]);
			}
		}
		PrintPathEqualToSum(pathLen, paths, root.left, sum);
		PrintPathEqualToSum(pathLen, paths, root.right, sum);
	}
	
	/*
		printPathsFromRootToLeaf(tree,0,new int[1000]);
	*/
	public static void printPathsFromRootToLeaf(newTree tree, int pathLength, int[] path){
		if(tree == null){
			return;
		} 
		path[pathLength++] = tree.data;
		
		if(tree.left == null && tree.right == null){
			printPath(pathLength,path);
		}
		printPathsFromRootToLeaf(tree.left,pathLength,path);
		printPathsFromRootToLeaf(tree.right,pathLength,path);
	}

	public static void printPath(int pathlength, int[] path) {
		System.out.println();
		System.out.print("Path: ");
		for (int i = 0; i < pathlength; i++) {
			System.out.print(" "+path[i]);
		}
	}
	
	public static int getSize(newTree tree){
		if(tree == null){
			return 0;
		}
		
		return (1 + getSize(tree.left) + getSize(tree.right));
	}
	
	public static int getMinValue(newTree tree){
		while(tree.left!=null){
			tree = tree.left;
		}
		return tree.data;
	}
	
	public static void mirror(newTree tree){
		if(tree == null){
			return;
		}
		
		//swap(tree.left,tree.right)
		newTree temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		
		mirror(tree.left);
		mirror(tree.right);
	}
	
	public static boolean isSameTree(newTree tree1, newTree tree2){
		if(tree1 == null && tree2 == null){
			return true;
		} else if(tree1 != null && tree2 != null){
			return tree1.data == tree2.data && isSameTree(tree1.left,tree2.left) && isSameTree(tree1.right, tree2.right);
		} else { 
			return false;
		}
	}
	
	public static boolean isSameTreeOld(newTree tree1, newTree tree2){
		if(tree1 == null && tree2 == null){
			return true;
		}else if((tree1 == null && tree2!=null) || (tree1 != null && tree2 == null)){
			return false;
		}
		
		
		if(tree1.data != tree2.data){
			return false;
		} 
		
		return isSameTreeOld(tree1.left,tree2.left) && isSameTreeOld(tree1.right, tree2.right);
	}

	public static boolean isSubTree(newTree tree1, newTree tree2){
		if(tree1 == null && tree2 == null) return true;
		else if(tree1 == null || tree2 == null) return false;
		else{
			if(tree1.data == tree2.data) {
				if(isSubTree(tree1.left, tree2.left) && isSubTree(tree1.right, tree2.right))
					return true;
			}
			return isSubTree(tree1.left, tree2) || isSubTree(tree1.right, tree2);
		}
	}
	
	public static boolean isSubTree(newTree tree1, newTree tree2,boolean elementFound){
		if(tree1 == null && tree2 == null && elementFound) {
			return true;
		} else if(tree1 == null || tree2 == null){
			return false;
		}
		
		if(tree1.data == tree2.data) {
			elementFound = true;
			return isSubTree(tree1.left,tree2.left,elementFound) && isSubTree(tree1.right,tree2.right,elementFound);
		} else if(!elementFound){
			return (isSubTree(tree1.left,tree2,elementFound) || isSubTree(tree1.right,tree2,elementFound));
		} else {
			return true;
		}
	}
	/*
	 * 				100
	 * 		75				125
	 * 	50		85		115		150
	 * 
	 */
	public static boolean isBST(newTree tree, int min, int max){
		if(tree == null){
			return true;
		}
		if(tree.data <= min || tree.data >= max){
			return false;
		}
		return isBST(tree.left,min,tree.data) && isBST(tree.right,tree.data,max);
	}
	
	/*
	 * LCA for a binary search tree
	 */
	public newTree findLca(newTree tree, int t1, int t2) {
	    if(tree == null) {
	        return null;
	    }
	    if(tree.data > t2 && tree.data > t1) {
	        // both targets are left
	        return findLca(tree.left, t1, t2);
	    } else if (tree.data < t2 && tree.data < t1) {
	        // both targets are right
	        return findLca(tree.right, t1, t2);
	    } else {
	        // either we are diverging or both targets are equal
	        // in both cases so we've found the LCA
	        // check for actual existence of targets here, if you like
	        return tree;
	    }
	}
	
	public static newTree findLCAInBST(newTree tree, int a, int b){
		if(tree == null) {
			return null;
		}
		
		if(tree.data < a && tree.data < b){
			return findLCAInBST(tree.left,a,b);
		} else if(tree.data > a && tree.data > b){
			return findLCAInBST(tree.right,a,b);
		} else {
			return tree;
		}
	}
	
	public static newTree findLCAInNonBST(newTree tree, int a, int b){
		if(tree == null){
			return null;
		}
		
		if(tree.data == a || tree.data == b){
			return tree;
		}
		
		newTree l = findLCAInNonBST(tree.left,a,b);
		newTree r = findLCAInNonBST(tree.right,a,b);
		
		if(l!=null && r!=null){
			return tree;
		}
		
		return l!=null ? l : r;
	}
	
	/**
	 * LCA for a binary tree.
	 * 
	 */
	public static newTree lowestCommonAncestor(newTree root, newTree a, newTree b) {
	    if (root == null) {
	        return null;
	    }
	    
	    if (root.equals(a) || root.equals(b)) { 
	        // if at least one matched, no need to continue
	        // this is the LCA for this root
	        return root;
	    }
	 
	    newTree l = lowestCommonAncestor(root.left, a, b);
	    newTree r = lowestCommonAncestor(root.right, a, b);
	 
	    if (l != null && r != null) {
	    	return root;  // nodes are each on a seaparate branch
	    }
	 
	    // either one node is on one branch, 
	    // or none was found in any of the branches
	    return l != null ? l : r;
	}
	
	public void printByLevelRecursive(newTree root){
		Queue<newTree> queue = new LinkedList<newTree>();
		queue.add(root);
		printByLevelRecursive(queue);
	}
	
	public void printByLevelRecursive(Queue<newTree> queue){
		if(queue.isEmpty()){
			return;
		}
		
		newTree node = queue.poll();
		System.out.print(node.data + " ");
		if(node.left != null){
			queue.add(node.left);
		} 
		
		if(node.right!=null){
			queue.add(node.right);
		}
		
		printByLevelRecursive(queue);
	}

	/**
	 * Printing the tree in level order.
	 * @param tree
	 */
	public static void printLevelOrder(newTree tree) {
		if (tree == null)
			return;
		Queue<newTree> queue = new LinkedList<newTree>();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.add(tree);
		while (!queue.isEmpty()) {
			newTree currNode = queue.poll();
			if (currNode != null) {
				System.out.print(currNode.data + " ");
				currentLevel--;
			}
			if (currNode.left != null) {
				queue.add(currNode.left);
				nextLevel++;
			}
			if (currNode.right != null) {
				queue.add(currNode.right);
				nextLevel++;
			}
			if (currentLevel == 0) {
				System.out.println();
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
	}
	
	public static void printZigZag(newTree tree){
		if(tree == null){
			return;
		}
		Stack<newTree> eStack = new Stack<newTree>();
		Stack<newTree> oStack = new Stack<newTree>();
		oStack.push(tree);
		printZigZag(1,eStack,oStack);
	}

	public static void printZigZag(int level, Stack<newTree> eStack, Stack<newTree> oStack){
		if(eStack.isEmpty() && oStack.isEmpty()){
			return;
		}
		
		if(level % 2 != 0 && !oStack.isEmpty()){
			newTree tree;
			while(!oStack.isEmpty()){
				tree = oStack.pop();
				System.out.print(tree.data + " ");
				if(tree.left!=null){
					eStack.push(tree.left);
				}
				if(tree.right!=null){
					eStack.push(tree.right);
				}
			}
			
			
		} if(level % 2 == 0 && !eStack.isEmpty()){
			newTree tree;
			while(!eStack.isEmpty()){
				tree = eStack.pop();
				System.out.print(tree.data + " ");
				if(tree.right!=null){
					oStack.push(tree.right);
				}
				if(tree.left!=null){
					oStack.push(tree.left);
				}
			}
		}
		
		printZigZag(level + 1, eStack, oStack);
	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public static int maxPathSum(newTree root) {

		if (root == null) {
			return -1;
		}

		if (root.left == null && root.right == null) {
			return root.data;
		}

		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;

		maxPath(root, max);
		return max[0];
	}

	public static int maxPath(newTree node, int[] max) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int left = maxPath(node.left, max);
		int right = maxPath(node.right, max);

		int current = Math.max(node.data, Math.max(node.data + left, node.data + right));
		int rootLeftRight = Math.max(current, node.data + left + right);
		int maxOfRootLeftRight = Math.max(node.data, Math.max(left, right));
		max[0] = Math.max(max[0], Math.max(rootLeftRight, maxOfRootLeftRight));
		return current;
	}
}

class newTree{
	int data;
	newTree left;
	newTree right;
	
	newTree(int data){
		this.data = data;
	}
}
