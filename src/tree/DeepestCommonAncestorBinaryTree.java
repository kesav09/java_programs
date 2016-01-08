package tree;


public class DeepestCommonAncestorBinaryTree{
	Node root = null;
	
	class Node {
		final Node parent;
		final Node left;
		final Node right;
		int data;

		public Node(Node parent, Node left, Node right, int data){
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.data = data;
		}

		boolean isRoot(){
			return parent == null;
		}
	}

	//1. traverse the tree starting from root
	//2. If any of the given keys (n1 and n2) matches with root, then root is LCA
	//3. If root doesn’t match with any of the keys, we recur for left and right subtree. 
	//4. The node which has one key present in its left subtree and the 
	//   other key present in right subtree is the LCA
	//5. If both keys lie in left subtree, then left subtree has LCA
	//   otherwise LCA lies in right subtree.
	public Node commonAncestor(Node nodeOne, Node nodeTwo){
		
		if (nodeOne == null || nodeTwo == null){
			return null;
		}
		if (nodeOne.isRoot()){
			return nodeOne;
		}
		if (nodeTwo.isRoot()){
			return nodeTwo;
		}
		boolean v1 = false;
		boolean v2 = false;
		
		//left subtree
		Node LCA = findCommonAncestor(root, nodeOne.data, nodeTwo.data, v1, v2);
		if ((v1 == true && v2 == true) || (v1 == true && find(LCA, nodeTwo.data)) || (v2 == true && find(LCA, nodeOne.data))){
			return LCA;
		}
		return null;
	}

	public Node findCommonAncestor(Node root, int nodeOne, int nodeTwo, boolean v1, boolean v2){
		if (root.data == nodeOne){
			v1 = true;
			return root;
		}
		if (root.data == nodeTwo){
			v2 = true;
			return root;
		}
		//search in left subtree
		Node leftLCA = findCommonAncestor(root.left, nodeOne, nodeTwo, v1, v2);

		//search in right subtree
		Node rightLCA = findCommonAncestor(root.right, nodeOne, nodeTwo, v1, v2);

		if (leftLCA != null && rightLCA != null){
			return root;
		}else if (leftLCA != null){
			return leftLCA;
		}else{
			return rightLCA;
		}
	}
	
	public boolean find(Node root, int key){
		if (root == null){
			return false;
		}
		if (root.data == key || find(root.left, key) == true || find(root.right, key) == true){
			return true;
		}
		return false;
	}

	public static void main(String [] args){

	}
}