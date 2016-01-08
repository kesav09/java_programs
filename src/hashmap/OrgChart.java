package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class OrgChart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.addNode("Harry");
		tree.addNode("Jane", "Harry");
		tree.addNode("Bill", "Harry");
		tree.addNode("Joe", "Jane");
		tree.addNode("Diane", "Jane");
		tree.addNode("George", "Diane");
		tree.addNode("Mary", "Diane");
		tree.addNode("Jill", "George");
		tree.addNode("Carol", "Jill");
		tree.addNode("Grace", "Bill");
		tree.addNode("Mark", "Jane");
		//tree.display("Jane",1);
		//tree.display("dfb");
		tree.display("George");
	}
}

class Node {
	private String identifier;
	private ArrayList<String> children;

	public Node(String identifier) {
		this.identifier = identifier;
		children = new ArrayList<>();
	}

	public void addChild(String identifier) {
		children.add(identifier);
	}

	public String getIdentifier() {
		return identifier;
	}

	public ArrayList<String> getChildren() {
		return children;
	}
}

class Tree {
	private static final int ROOT = 0;
	HashMap<String, Node> nodes;

	public Tree() {
		nodes = new HashMap<>();
	}

	public Node addNode(String identifier) {
		return this.addNode(identifier, null);
	}

	public Node addNode(String identifier, String parent) {
		Node node = new Node(identifier);
		nodes.put(identifier, node);
		if (parent != null) {
			nodes.get(parent).addChild(identifier);
		}
		return node;
	}

	public void display(String identifier) {
		this.display(identifier, ROOT);
	}

	private void display(String identifier, int depth) {
		if (!nodes.containsKey(identifier)){
			return;
		}
		if (depth == ROOT) {
			System.out.println(identifier);
		} else {
			String tabs = String.format("%0" + depth + "d", 0).replace("0","    "); // 4 spaces
			//String tabs = String.format("%0"+depth+"d", 0); // 4 spaces
			System.out.println(tabs+identifier);
		}
		depth++;
		ArrayList<String> children = nodes.get(identifier).getChildren();
		for (String child : children) {

			// Recursive call
			this.display(child, depth);
		}
	}
}
