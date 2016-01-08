package tree;

public class ClosestValueBST {

	static class Tree{
		Tree left;
		Tree right;
		int value;
		public Tree(int value){
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree tree = new Tree(100);
		tree.left = new Tree(50);   tree.right = new Tree(200);
		tree.left.left = new Tree(10); tree.left.right = new Tree(40);
		tree.right.left =  new Tree(150); tree.right.right = new Tree(300);
		System.out.println("closest value to 1000 is "+getClosest(tree, 1000));
		
	}
	
	
	public static int getClosest(Tree tree, int value){
		int minDiff = minDiff(tree, value);
		return minDiff + value;
	}
	
	public static int minDiff(Tree tree, int value){
		if (tree == null){
			return Integer.MAX_VALUE;
		}
		if (tree.value < value){
			return smallDiff(tree.value - value, minDiff(tree.right, value));
		}else{
			return smallDiff(tree.value - value, minDiff(tree.left, value));
		}
	}
	
	public static int smallDiff(int a, int b){
		if (Math.abs(a) < Math.abs(b))
			return a;
		return b;
	}
}
