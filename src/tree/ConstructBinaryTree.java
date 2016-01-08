package tree;

import java.util.LinkedList;
import java.util.Queue;

class constructBinaryTree{
	static class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static void main(String[] args){
		int[] num = {90,34,45,56,67,78,123,34,45,5,12,34};
		Node root = new Node(num[0]);
 		construct(num,root,0);
 		printTreeLevel(root);
	}
	
	/*
		num,new Node[num[0]],0
	*/
	
	public static void construct(int[] num, Node root,int i){
		if(i>num.length/2){
			return;
		}
		if(num.length > (2*i+1)){
			root.left = new Node(num[2*i + 1]);
			construct(num,root.left,2*i + 1);
		}
		if(num.length > (2*i+2)){
			root.right = new Node(num[2*i + 2]);
			construct(num,root.right,2*i + 2);
		}
	}
	
	public static void printTreeLevel(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		Node temp;
		queue.add(root);
		while(queue.peek()!=null){
			temp = queue.poll();
			System.out.print(temp.data + " ");
			queue.add(temp.left);
			queue.add(temp.right);
		}
	}
}
