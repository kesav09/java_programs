package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class TreeBuildParentChildRelationship{

	public static void main(String [] args){
		TreeBuildParentChildRelationship tr = new TreeBuildParentChildRelationship();

		List<Relation> list = new ArrayList<Relation>();
		list.add(new TreeBuildParentChildRelationship().new Relation(15, 20, true));
		list.add(new TreeBuildParentChildRelationship().new Relation(19, 80, true));
		list.add(new TreeBuildParentChildRelationship().new Relation(17, 20, false));
		list.add(new TreeBuildParentChildRelationship().new Relation(16, 80, false));
		list.add(new TreeBuildParentChildRelationship().new Relation(80, 50, false));
		list.add(new TreeBuildParentChildRelationship().new Relation(50, null, false));
		list.add(new TreeBuildParentChildRelationship().new Relation(20, 50, true));
		System.out.println("size"+list.size());
		Node root = tr.buildTree(list);
		printOrder(root);
	}

	public class Relation {
		public Integer _parent;
		public Integer _child;
		public boolean _isLeft;	

		public Relation(Integer child, Integer parent, boolean isLeft){
			_parent = parent;
			_child = child;
			_isLeft = isLeft;
		}
	}
	
	public static void print(Node root){
		if (root == null){
			return;
		}else{
			System.out.print(root._id+",");
			print(root._left);
			print(root._right);
		}
	}

	public class Node{
		public Integer _id;
		public Node _left;
		public Node _right;

		Node(Integer id, Node left, Node right){
			_id = id;
			_left = left;
			_right = right;
		}
	}

	public static void printOrder(Node root){
		if (root == null){
			return;
		}else{
			int currLevel = 1;
			int nextLevel = 0;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()){
				Node curr = queue.poll();
				if (curr != null){
					System.out.print(curr._id+"    ");
					currLevel--;
				}
				if (curr._left != null){
					queue.add(curr._left);
					nextLevel++;
				}
				if (curr._right != null){
					queue.add(curr._right);
					nextLevel++;
				}

				if (currLevel == 0){
					currLevel = nextLevel;
					nextLevel = 0;
					System.out.println();
				}
			}
		}
	}

	//1. search node whose parent is 50 is the root of the tree
	//2. put root into the queue
	//3. search for all the child nodes whose parent is 50 and put into queue
	//4. keep inserting to the left if left is true otherwise to the right 
	//5. print the tree
	public Node buildTree(List<Relation> data){
		if (data == null){
			return null;
		}

		Node root = null;
		for(Relation r : data){
			if (r._parent == null){
				root = new Node(r._child, null, null);
				break;
			}
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		remove(data, root._id);
		System.out.println("new size"+data.size());
		Node current = null;
		Node parent = null;
		Node child = null;
		while (!queue.isEmpty()){
			current = queue.poll();
			parent = current;
			System.out.println("queue current : "+parent._id);
			for (Relation r : data){
				if (r._parent == current._id){
					child = new Node(r._child, null, null);
					queue.add(child);
					if (r._isLeft){
						parent._left = child;
						System.out.println("current left child"+" "+parent._left._id);
					}else {
						parent._right = child;
						System.out.println("current right child"+" "+parent._right._id);
					}
				}
			}
		}
		return root;

	}
	
	public static void remove(List<Relation> list, int value){
		Iterator<Relation> it = list.iterator();
		while(it.hasNext()){
			if (it.next()._child == value){
				it.remove();
			}
		}
	}

}