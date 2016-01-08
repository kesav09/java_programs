package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeImplementation {

	static Tree root;

	public static void main(String [] args) {

		//     15
		//  10     20
		// 5  12 18   25
		//2              30
		//1

		Tree tree = new Tree(50);
		insertIterative(tree, 70);
//		insertIterative(tree, 90);
//		insertIterative(tree, 5);
//		insertIterative(tree, 25);
//		insertIterative(tree, 70);
//		insertIterative(tree, 1);
//		System.out.println(isPairPresent(tree, 30));
		System.out.println(isCompleteBinaryTree(tree));
		//				insertIterative(tree, 20);
		//						inorder(tree);
		//		System.out.println(depth(tree));
		//		System.out.println(findPredecessor(tree, 15));
		//		System.out.println(findLCAIterative(tree, 1, 2));
		//		System.out.println(getHeight(tree, 25));
		//		System.out.println(countNodes(tree));
		//		BFSLevelPrint(tree);
		//				printLevelOrder(tree);
		//				System.out.println(findMaxNonBinaryTree(tree));
		//		printLevelOrderBottom(tree);
		//				preorder(tree);
		//		print(tree);
		//		printReverse(tree);
		//				printAtDesiredLevel(tree, 2);
		//		printAtDesiredLevel(tree, 0, 2);
		//		System.out.println(Integer.MIN_VALUE);
		//		System.out.println(Integer.MAX_VALUE);
		//		System.out.println(ifBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
		//		System.out.println(searchIterative(tree, 30));
		//				System.out.println(findLCA(tree.left.left, tree.right).value);


		//		SearchString string = new SearchString("cat");
		//		string.left = new SearchString("bat");
		//		string.right = new SearchString("rat");
		//		string.left.left = new SearchString("mat");
		//		string.left.left.right = new SearchString("sat");
		//		string.right.left = new SearchString("pat");
		//		string.right.right = new SearchString("nat");
		//
		//		SearchStringImplementation st = new SearchStringImplementation();
		//		//		st.inorder(string);
		//		System.out.println(st.search(string, "sat"));
	}

	//recursive
	public static void insert(Tree tree, int value){
		if (tree == null){
			tree = new Tree(value);
		}else{
			if (tree.value > value){
				if (tree.left == null) 
					tree = new Tree(value);
				else 
					insert(tree.left, value);

			}else if (tree.value < value){
				if (tree.right == null) 
					tree = new Tree(value);
				else 
					insert(tree.right, value);
			}
		}
	}

	//iterative
	public static void insertIterative(Tree tree, int value){
		if (tree == null) tree = new Tree(value);
		else {
			Tree curr = tree;
			Tree parent;
			while (true){
				parent  = curr;
				if(curr.value >= value){
					curr = curr.left;

					if(curr == null) {
						parent.left = new Tree(value);
						break;
					}
				}else{
					curr = curr.right;
					if(curr == null){
						parent.right = new Tree(value);
						break;
					}
				}
			}
		}
	}

	public static void inorder(Tree tree){
		if(tree == null) return;
		else{
			inorder(tree.left);
			System.out.print(tree.value+",");
			inorder(tree.right);
		}
	}

	public static void preorder(Tree tree){
		if(tree == null) return;
		else{
			System.out.print(tree.value+",");
			preorder(tree.left);
			preorder(tree.right);
		}
	}

	public static void postorder(Tree tree){
		if(tree == null) return;
		else{
			postorder(tree.left);
			postorder(tree.right);
			System.out.print(tree.value+",");
		}
	}

	public static boolean isSameTree(Tree tree1, Tree tree2){
		if(tree1 == null && tree2 == null) return true;
		else if(tree1 == null || tree2 == null) return false;
		else{
			if (tree1.value == tree2.value) {
				return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
			}else 
				return false;
		}
	}

	public static boolean isSubTree(Tree tree1, Tree tree2){
		if(tree1 == null && tree2 == null) return true;
		else if(tree1 == null || tree2 == null) return false;
		else{
			if(tree1.value == tree2.value) {
				if(isSubTree(tree1.left, tree2.left) && isSubTree(tree1.right, tree2.right))
					return true;
			}
			return isSubTree(tree1.left, tree2) || isSubTree(tree1.right, tree2);
		}
	}

	public static int countNodes(Tree tree){
		if (tree == null){
			return 0;
		}else{
			return 1 + countNodes(tree.left) + countNodes(tree.right);
		}
	}

	public static int min(Tree tree){
		if (tree == null){
			return 0;
		}else {
			Tree curr = tree;
			while (curr.left != null)
				curr = curr.left;
			return curr.value;
		}

	}

	public static int max(Tree tree){
		if (tree == null){
			return 0;
		}else {
			Tree curr = tree;
			while (curr.right != null)
				curr = curr.right;
			return curr.value;
		}

	}

	//max element in left subtree
	public static int findPredecessor(Tree tree, int value){
		if (tree == null){
			return -1;
		}else {
			Tree curr = tree;

			if (curr.left == null && curr.right == null) return 0;

			if (curr.left != null){
				curr = curr.left;
				while(curr.right!=null){
					curr = curr.right;
				}
			}
			return curr.value;
		}
	}

	//min element in right subtree
	public static int findSuccessor(Tree tree, int value){
		if (tree == null){
			return -1;
		}else {
			Tree curr = tree;

			if (curr.left == null && curr.right == null) return 0;

			if (curr.right != null){
				curr = curr.right;
				while(curr.left!=null){
					curr = curr.left;
				}
			}
			return curr.value;
		}
	}

	//top down iterative approach for bst
	public static int findLCAIterative(Tree tree, int value1, int value2){
		Tree curr;
		if (tree == null) return -1;
		else{
			curr = tree;
			while(curr != null){
				if(curr.value > value1 && curr.value > value2){
					curr = curr.left;
				}else if (curr.value < value1 && curr.value < value2){
					curr = curr.right;
				}else
					break;
			}
		}
		return curr.value;
	}

	//non BST
	//bottom up approach 
	//O(h)
	//1. get the distance (height) of both nodes from the root
	//2. then, we advance the deeper node dh steps above, and when both the nodes would be at the same depth
	//3. Then, we advance both nodes one level at a time
	public static Tree findLCA(Tree node1, Tree node2){
		if (node1 == null || node2 == null) return null;
		int heightValue1 = getHeight(node1, node1.value);
		int heightValue2 = getHeight(node2, node2.value);
		if(heightValue1 > heightValue2){
			swap(node1, node2);
			swap(node1.value, node2.value);
		}
		int diffHeight = heightValue2 - heightValue1;
		for (int i = 0; i < diffHeight; i++){
			node2 = node2.parent;
		}
		while(node1.value != node2.value){
			if (node1.value == node2.value) return node1;
			node1 = node1.parent;
			node2 = node2.parent;
		}
		return null;
	}

	//swapping nodes
	public static void swap(Tree a, Tree b){
		Tree temp = a;
		a = b;
		b = temp;
	}

	//swapping values
	public static void swap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}

	//longest path from the root node down to the farthest leaf node
	public static int depth(Tree tree){
		if (tree == null){
			return 0;
		}else{
			int lnodes = 1 + depth(tree.left);
			int rnodes = 1 + depth(tree.right);
			return lnodes > rnodes ? lnodes:rnodes;
		}
	}

	public static int getHeight(Tree tree, int value){
		if (tree == null) return 0;
		if (tree.value == value) return 0;
		Tree curr = tree;
		int count = 0;
		while(curr.value != value){
			if(curr.value > value){
				curr = curr.left;

				if (curr == null) return -1;
				else count++;

			}else if (curr.value < value){
				curr = curr.right;

				if(curr == null) return -1;
				else count++;
			}
		}
		return count;
	}

	//recursive
	public boolean search(Tree tree, int data) { 
		if (tree==null) { 
			return(false); 
		}

		if (data==tree.value) { 
			return(true); 
		} 
		else if (data<tree.value) { 
			return(search(tree.left, data)); 
		} 
		else { 
			return(search(tree.right, data)); 
		} 
	}

	//iterative
	public static boolean searchIterative(Tree tree, int data) { 
		if (tree==null) { 
			return(false); 
		}else {
			if (tree.value == data) return true;
			Tree curr = tree;
			while (curr.value != data){
				if (curr.value > data){
					curr = curr.left;

					if (curr == null) break;
					else if (curr.value == data) return true;

				}else if (curr.value < data){
					curr = curr.right;

					if (curr == null) break;
					else if (curr.value == data) return true;
				}
			}
			return false;
		}
	}

	//using two queue
	public static void BFSLevelOrderPrint(Tree tmpRoot) {

		Queue<Tree> currentLevel = new LinkedList<Tree>();
		Queue<Tree> nextLevel = new LinkedList<Tree>();

		currentLevel.add(tmpRoot);

		while (!currentLevel.isEmpty()) {
			Iterator<Tree> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				Tree currentNode = iter.next();
				if (currentNode.left != null) {
					nextLevel.add(currentNode.left);
				}
				if (currentNode.right != null) {
					nextLevel.add(currentNode.right);
				}
				System.out.print(currentNode.value + " ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<Tree>();

		}

	}

	//	//using one queue and recursion
	//	public static void BFSLevelPrint(Tree tree)
	//	{
	//		Queue<Tree> q = new LinkedList<Tree>();
	//		q.offer(tree);
	//		BFSPrint(q);
	//	}
	//
	//	private static void BFSPrint(Queue<Tree> q)
	//	{
	//		if(q.isEmpty())
	//			return;
	//		int qLen = q.size(),i=0;
	//		
	//		while(i<qLen) 
	//		{
	//			Tree current = q.remove();
	//			System.out.print(current.value+" ");
	//			if(current.left!=null)
	//				q.offer(current.left);
	//			if(current.right!=null)
	//				q.offer(current.right);
	//			i++;
	//		}
	//		System.out.println();
	//		BFSPrint(q);
	//
	//	}

	//using only one queue
	//When we pop a node off the queue, we decrement nodes in currentLevel by one.
	//When we push its child nodes to the queue, we increment nodes in nextLevel by two
	//When nodes in currentLevel reaches 0, we know that the current level has ended, therefore we print an endline here
	public static void printLevelOrder(Tree tree){
		if (tree == null) return;
		Queue<Tree> queue = new LinkedList<Tree>();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.add(tree);
		while (!queue.isEmpty()){

			Tree currNode = queue.poll();
			System.out.print(currNode.value+" ");
			currentLevel--;
			if (currNode.left != null){
				queue.add(currNode.left);
				nextLevel++;
			}
			if(currNode.right != null){
				queue.add(currNode.right);
				nextLevel++;
			}
			if (currentLevel == 0){
				System.out.println();
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
	}


	//finding max element in non-binary tree
	//	public static int findMaxNonBinaryTree(Tree tree){
	//		if (tree == null) return 0;
	//		Queue<Tree> queue = new LinkedList<Tree>();
	//		int currentLevel = 1;
	//		int nextLevel = 0;
	//		queue.add(tree);
	//		int max = tree.value;
	//		while (!queue.isEmpty()){
	//
	//			Tree currNode = queue.poll();
	//			if (currNode.value > max)
	//				max = currNode.value;
	//			currentLevel--;
	//			if (currNode.left != null){
	//				queue.add(currNode.left);
	//				nextLevel++;
	//			}
	//			if(currNode.right != null){
	//				queue.add(currNode.right);
	//				nextLevel++;
	//			}
	//			if (currentLevel == 0){
	//				currentLevel = nextLevel;
	//				nextLevel = 0;
	//			}
	//		}
	//		return max;
	//	}

	public static int findMaxNonBinaryTree(Tree tree){
		if (tree == null) return 0;
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(tree);
		int max = 0;
		while (!queue.isEmpty()){
			Tree currNode = queue.poll();
			if (currNode == null) break;
			else {
				if (currNode.value > max)
					max = currNode.value;
				if (currNode.left != null)
					queue.add(currNode.left);
				if(currNode.right != null)
					queue.add(currNode.right);
			}
		}
		return max;
	}

	//using queue & stack
	public static void reverseLevelOrderTraversal(Tree tree){
		if (tree == null) return;
		Queue<Tree> queue = new LinkedList<Tree>();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.add(tree);
		Stack<Integer> levelCount = new Stack<Integer>();
		levelCount.push(1);
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!queue.isEmpty()){

			Tree currNode = queue.poll();
			result.add(currNode.value);
			currentLevel--;
			if (currNode.left != null){
				queue.add(currNode.left);
				nextLevel++;
			}
			if(currNode.right != null){
				queue.add(currNode.right);
				nextLevel++;
			}
			if (currentLevel == 0){
				if (nextLevel == 0) break;
				if (nextLevel != 0) levelCount.push(nextLevel);
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}

		int toIndex = result.size();
		int fromIndex = 0;
		while(!levelCount.isEmpty()){	
			fromIndex = toIndex - levelCount.pop();
			System.out.print(result.subList(fromIndex, toIndex)+" ");
			System.out.println();
			toIndex = fromIndex;
		}
	}

	public static void printZigZag(Tree tree){
		if (tree == null) return;
		Queue<Tree> queue = new LinkedList<Tree>();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.add(tree);
		Stack<Integer> levelCount = new Stack<Integer>();
		levelCount.push(1);
		while (!queue.isEmpty()){
			Tree currNode = queue.poll();



			currentLevel--;

			if (currNode.left != null){
				queue.add(currNode.left);
				nextLevel++;
			}
			if(currNode.right != null){
				queue.add(currNode.right);
				nextLevel++;
			}
			if (currentLevel == 0){
				if (nextLevel == 0) break;
				if (nextLevel != 0) levelCount.push(nextLevel);
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
	}

	//print the tree in array form by putting in queue
	public static void print(Tree tree){
		if (tree == null) return;
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(tree);
		while (!queue.isEmpty()){
			Tree currNode = queue.poll();
			System.out.print(currNode.value+" ");
			if (currNode.left != null){
				queue.add(currNode.left);
			}
			if(currNode.right != null){
				queue.add(currNode.right);
			}
		}
	}

	//print tree in reverse order in array form by putting in stack
	public static void printReverse(Tree tree){
		if (tree == null) return;
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(tree);
		Stack<Tree> stack = new Stack<Tree>();
		while (!queue.isEmpty()){
			Tree currNode = queue.poll();
			stack.push(currNode);
			//			System.out.print(currNode.value+" ");
			if (currNode.left != null){
				queue.add(currNode.left);
			}
			if(currNode.right != null){
				queue.add(currNode.right);
			}
		}

		while(!stack.isEmpty()){
			System.out.print(stack.pop().value+" ");
		}
	}

	//using recursion
	public static void printAtDesiredLevel(Tree tree, int currLevel, int desiredLevel){

		if (tree == null || currLevel > desiredLevel) return;
		if (currLevel == desiredLevel)
			System.out.print(tree.value+",");
		else{
			printAtDesiredLevel(tree.left, currLevel+1, desiredLevel);
			printAtDesiredLevel(tree.right, currLevel+1, desiredLevel);
		}
	}

	//using queue
	public static void printAtDesiredLevel(Tree tree, int desiredLevel){

		if (desiredLevel < 0) return;

		java.util.Queue<Tree> queue = new java.util.LinkedList<Tree>();
		java.util.Queue<Integer> levels = new java.util.LinkedList<Integer>();

		queue.add(tree);
		levels.add(0);

		while (!queue.isEmpty()) {
			Tree temp = queue.poll();//same as dequeue

			int currLevel = levels.poll();

			if (temp == null) return;
			else if(currLevel == desiredLevel){
				System.out.print(temp.value+",");
			}else{
				queue.add(temp.left); 
				levels.add(currLevel+1);

				queue.add(temp.right); 
				levels.add(currLevel+1);
			}
		}
	}

	public static boolean ifBST(Tree tree, int small, int large){
		if (tree == null) return true;

		if (tree.value > small && tree.value < large){
			return ifBST(tree.left, small, tree.value) && ifBST(tree.right, tree.value, large);
		}else
			return false;
	}

	//subtract the node value from the sum when recurring down
	//and check to see if the sum is 0 when you run out of tree
	//return true when sum = 0
	public static boolean hasPathSum(Tree tree, int sum){
		if(tree == null) 
			return (sum == 0);
		else{
			int subsum = sum - tree.value;
			return(hasPathSum(tree.left, subsum) || hasPathSum(tree.right, subsum));
		}
	}

	public static boolean isSymmetric(Tree tree){
		return false;
	}

	//Find a pair with given sum in a Balanced BST
	public static boolean isPairPresent(Tree tree, int sum){
		java.util.List<Integer> list = new ArrayList<Integer>();
		if (tree == null) return false;
		else {
			int val1 = 0;
			int val2 = 0;
			boolean done1 = false;
			boolean done2 = false;

			java.util.Stack<Tree> stack1 = new Stack<Tree>();
			java.util.Stack<Tree> stack2 = new Stack<Tree>();

			Tree curr1 = tree;
			Tree curr2 = tree;
			
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
	
	//1. do a level order traversal starting from root. In the traversal, once a node is found which is NOT a Full Node, 
		//all the following nodes must be leaf nodes
		//2. If a node has empty left child, then the right child must be empty
		public static boolean isCompleteBinaryTree(Tree tree){
			if (tree == null) return true;
			java.util.Queue<Tree> queue = new LinkedList<Tree>();
			boolean flag = false;
			
			queue.add(tree);
			while(!queue.isEmpty()){
				Tree temp = queue.poll();
				
				if (temp.left != null){
					queue.add(temp.left);
				}
				else
					flag = true;
				
				if (temp.right != null){
					if(flag == true) return false;
					queue.add(temp.right);
				}
				else
					flag = true;
			}
			return true;
			
		}
}

class Tree{
	int value;
	Tree left;
	Tree right;
	Tree parent;
	Tree(int value){
		this.value = value;
	}
}


//search a string using bfs
class SearchStringImplementation{

	public void inorder(SearchString tree){
		if(tree == null) return;
		else{
			inorder(tree.left);
			System.out.print(tree.word+",");
			inorder(tree.right);
		}
	}

	public boolean search(SearchString tree, String word){
		if (tree == null) return false;
		Queue<SearchString> queue = new LinkedList<SearchString>();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.add(tree);
		while (!queue.isEmpty()){

			SearchString currNode = queue.poll();
			if(currNode.word.equals(word)) 
				return true;
			currentLevel--;
			if (currNode.left != null){
				queue.add(currNode.left);
				nextLevel++;
			}
			if(currNode.right != null){
				queue.add(currNode.right);
				nextLevel++;
			}
			if (currentLevel == 0){
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
		return false;
	}
}


class SearchString{
	String word;
	SearchString left;
	SearchString right;
	SearchString(String word){
		this.word = word;
	}
}