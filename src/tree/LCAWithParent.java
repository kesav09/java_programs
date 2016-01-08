package tree;

public class LCAWithParent {
/**
		100
	50		 150
25   75  125	175

root, 25, 75
*/

	static class Tree {
		Tree parent;
		int data;
		Tree(int data){
			this.data = data;
		}
	}

	public static int getHeightToRoot(Tree tree) {
		if (tree == null) {
			return 0;
		}
		return (1 + getHeightToRoot(tree.parent));
	}

	public static Tree LCA(Tree tree1, Tree tree2) {
		int h1 = getHeightToRoot(tree1);
		int h2 = getHeightToRoot(tree2);
		int higher = h2;
		int lower = h1;

		Tree higherNode = tree2;
		Tree lowerNode = tree1;

		if (h2 < h1) {
			higherNode = tree1;
			lowerNode = tree2;

			higher = h1;
			lower = h2;
		}

		int diff = higher - lower;
		for (int i=0;i < diff;i++) {
			higherNode = higherNode.parent;
		}

		while (higherNode != null && lowerNode != null) {
			if (higherNode == lowerNode) {
				return lowerNode;
			} else {
				higherNode = higherNode.parent;
				lowerNode = lowerNode.parent;
			}
		}

		return null;
	}

/**
		100
	50		 150
25   75  125	175

root, 25, 75
*/
	public static void main(String[] args){
		Tree leftLeaf1 = new Tree(25);
		Tree rightLeaf1 = new Tree(75);
		Tree parent1 = new Tree(50);
		leftLeaf1.parent = rightLeaf1.parent = parent1;
		Tree grandParent = parent1.parent = new Tree(100);

		System.out.println((LCA(leftLeaf1,rightLeaf1)).data);
		System.out.println((LCA(leftLeaf1,grandParent)).data);
	}
}
