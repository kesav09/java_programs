package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of child->parent relationships, build a binary tree out of it. All the element Ids inside the tree are
 * unique.
 * 
 * Example:
 * 
 * Given the following relationships:
 * 
 * Child Parent IsLeft 
15 20 true 
19 80 true 
17 20 false 
16 80 false 
80 50 false 
50 null false 
20 50 true 


You should return the following tree: 
	 50 
	/  \ 
   20 	80 
  / \   / \ 
15 17 19   16 
 * 
 * 
 */

public class ChildParentRelationShip {
	/**
	 * Represents a pair relation between one parent node and one child node inside a binary tree If the _parent is
	 * null, it represents the ROOT node
	 */
	class Relation {
		public Integer _parent;
		public Integer _child;
		public boolean _isLeft;
		
		Relation(Integer _child,Integer _parent, boolean _isLeft){
			this._child = _child;
			this._parent = _parent;
			this._isLeft = _isLeft;
		}
	}

	/**
	 * Represents a single Node inside a binary tree
	 */
	class Node {
		public Integer _id;
		public Node _left;
		public Node _right;
		
		Node(Integer _id){
			this._id = _id;
			this._left = null;
			this._right = null;
		}
	}

	/**
	 * Implement a method to build a tree from a list of parent-child relationships And return the root Node of the tree
	 * @throws Exception 
	 */
	public Node buildTree(List<Relation> data) {

		Node root = null;
		List<Relation> list = getChildrenByParent(data, null);

		for (Relation relation : list) {
			root = new Node(relation._child);
		}
		build(data, root);
		return root;
	}

	private void build(List<Relation> data, Node parent) {
		List<Relation> list = getChildrenByParent(data, parent._id);
		if (list.isEmpty()) {
			return;
		}
		for (Relation relation : list) {
			Node newNode = new Node(relation._child);
			if (relation._isLeft) {
				parent._left = newNode;
			} else {
				parent._right = newNode;
			}
			build(data, newNode);
		}
	}

	private List<Relation> getChildrenByParent(List<Relation> data, Integer parent) {
		List<Relation> list = new ArrayList<Relation>();
		for (Relation relation : data) {
			if (relation._parent == parent) {
				list.add(relation);
			}
		}
		return list;
	}
	
	
	public static void main(String[] args){
		ChildParentRelationShip childParentRelationShip = new ChildParentRelationShip();
		List<Relation> data = childParentRelationShip.buildRelations();
		Node root = childParentRelationShip.buildTree(data);
		
		childParentRelationShip.traverseTree(root);
	}
	
	public void traverseTree(Node root){
		if(root == null){
			return;
		}

		System.out.print(root._id + " ");
		traverseTree(root._left);
		traverseTree(root._right);
	}

	private List<Relation> buildRelations() {
		List<Relation> data = new ArrayList<Relation>();
		data.add(new Relation(15,20,true));
		data.add(new Relation(19,80,true));
		data.add(new Relation(17,20,false));
		data.add(new Relation(16,80,false));
		data.add(new Relation(80,50,false));
		data.add(new Relation(50,null,false));
		data.add(new Relation(20,50,true));
		
		return data;
	}

}