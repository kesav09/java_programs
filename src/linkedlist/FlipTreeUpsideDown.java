package linkedlist;

import java.util.Queue;

/* Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes. 

Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.
 * 
 * for example, turn these:
*
*        1                 1
*       / \                 / \
*      2   3            2   3
*     / \
*    4   5
*   / \
*  6   7
*
* into these:
*
*        1               1
*       /               /
*      2---3         2---3
*     /
*    4---5
*   /
*  6---7
*
* where 6 is the new root node for the left tree, and 2 for the right tree.
* oriented correctly:
*
*     6                   2
*    / \                   / \
*   7   4              3   1
*        / \
*       5   2
*            / \
*          3   1
*/
public class FlipTreeUpsideDown {
	public static LinkedList flip(LinkedList linkedList){
		if(linkedList == null || linkedList.left == null){
			return linkedList;
		}
		
		LinkedList root = flip(linkedList.left);
		linkedList.left.left = linkedList.right;
		linkedList.left.right = linkedList;
		linkedList.left = null;
		linkedList.right = null;
		return root;
	}
	
	static class LinkedList{
		LinkedList left;
		LinkedList right;
		int data;
		public LinkedList(int data){
			this.data = data;
		}
	}

	public static void main(String[] args){
		LinkedList root = new LinkedList(1);
		root.left = new LinkedList(2);
		root.right = new LinkedList(3);

		root.left.left = new LinkedList(4);
		root.left.right = new LinkedList(5);
		
		root.left.left.left = new LinkedList(6);
		root.left.left.right = new LinkedList(7);
		

		displayByLevel(root);
		System.out.println();
		root = flip(root);
		displayByLevel(root);
	}
	
	public static void displayByLevel(LinkedList root){
		Queue<LinkedList> queue = new java.util.LinkedList<LinkedList>();
		queue.add(root);
		int level = 1;
		int currentElements = 0;
		while(!queue.isEmpty()){
			LinkedList linkedList = queue.poll();
			System.out.print(linkedList.data + " ");
			level--;
			
			if(linkedList.left!=null){
				queue.add(linkedList.left);
				currentElements++;
			}
			
			if(linkedList.right!=null){
				queue.add(linkedList.right);
				currentElements++;
			}
			
			if(level == 0){
				System.out.println();
				level = currentElements;
				currentElements=0;
			}
		}
	}
}
