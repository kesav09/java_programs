package stack;



/**
 * pop mid element in a stack in O(1).
 * Similar problem http://stackoverflow.com/questions/685060/design-a-stack-such-that-getminimum-should-be-o1
 */
public class StackDLL{
	static Node head = null;
	static Node tail = null;
	static Node mid = null;
	static int count = 0;
	
	public static void push(int data){
	 	Node node = new Node(data);
		if(head == null){
			head = node;
			tail = node;
			mid = node;
		} else {
			tail.right = node;
			node.left = tail;
			tail = node;
			count++;
			
			if(count % 2 == 0){
				mid = mid.right;
			}
		}
		
		
	}
	
	public static int pop(){
		Node temp = tail;
		tail = tail.left;
		
		if(head!=null && count % 2 == 0 ){
			mid = mid.left;
		}
		count--;
		return temp.data;
	}
	
	public static int popMid(){
		if(mid == null){
			return -1;
		}else {
			Node temp = mid;
			mid = mid.left;
			return temp.data;
		}
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
	
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args){
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		push(6);
		push(7);
		push(8);
		
		System.out.println(pop());
		
		System.out.println(popMid());
	}
}


