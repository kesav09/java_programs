package linkedlist;

//Q : Given a linked list, find a key value and how many times it occurs. Include the possibility of a loop

public class LinkedList {

	static Node head;
	static Node tail;
	
	public static void main(String [] args){
		insertFirst(1);
		insertFirst(2);
		insertFirst(3);
		insertFirst(4);
		insertFirst(5);
		display();

	}
	
	public static void insertFirst(int value){
		Node newNode = new Node(value);
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		
		else{
			newNode.next = head;
			head = newNode;
		}
	}
	
	public static void insertTail(int value){
		Node newNode = new Node(value);
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		
		else{
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	//if the list is sorted
	public static void insertMiddle(int value){
		Node newNode = new Node(value);
		
		if (head == null) return;
		else {
			Node curr = head;
			Node prev = head;
			while(curr.value < value){
				prev = curr;
				curr = curr.next;
				if(curr == null) return;
			}
			newNode.next = curr;
			prev.next = newNode;
			prev = newNode;
		}
	}
	
	public static Node getMiddleOfLinkedList(){
		if (head == null) return null;
		else{
			Node slow = head;
			Node fast = head;
			while (fast != null && fast.next != null){
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}	
	}
	
	public static Node getNthNodeFromLastOfLinkedList(int n){
		if(head == null) return null;
		else{
			Node slow = head;
			Node fast = head;
			
			if (n != 0) {
				while (n > 0){
					fast = fast.next;
					n--;
				}
			}else 
				return null;
			
			while (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}
	
	public static boolean deleteNode(int value){
		if (head == null) return false;
		else{
			if (head.value == value){
				Node curr = head;
				head = curr.next;
			}else if(tail.value == value){
				Node prev = head;
				while (prev.next != null){
					prev = prev.next;
				}
				prev.next = null;
			}else{
				Node prev = head;
				Node curr = head;
				while (curr.value != value){
					prev = curr;
					curr = curr.next;
					if (curr == null) return false;
				}
				prev.next = curr.next;
			}
		}
		return true;
	}
	
	//recursive solution
	public static Node reverse(Node head){
		if (head == null) return null;
		else{
			if (head.next == null) return head;
			else{
				Node remaining  = reverse(head.next);
				Node curr = remaining;
				while (curr.next != null)
					curr = curr.next;
				curr.next = head;
				head.next = null;
				return remaining;
			}
		}
	}
	
	//iterative solution
	public static void reverse(){
		if (head == null) return;
		else{
			if (head.next == null) return;
			else{
				Node curr = head;
				head = null;
				while (curr != null){
					Node save = curr;
					curr = curr.next;
					save.next = head;
					head = save;
				}
			}
		}
	}
	
	//find and remove duplicates in unsorted linkedlist
	public static void removeDuplicates(Node head){
		if (head == null) return;
		else if (head.next == null) return;
		else{
			java.util.HashSet<Integer> set = new java.util.HashSet<Integer>();
			Node prev = head;
			Node curr = head;
			while (curr != null){
				if (!set.contains(curr.value)) set.add(curr.value);
				else {
					prev.next = curr.next;
				}
				prev = curr;
				curr = curr.next;
			}
		}
	} 
	
	public static boolean detectCycle(){
		
		if (head == null) return false;
		if (head.next == null) return false;
		Node slow = head;
		Node fast = head;
		while(true){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == null || fast == null)
				return false;
			if (slow == fast)
				break;
		}
		
		//remove cycle
		fast = head;
		while(fast.next != slow.next){
			fast = fast.next;
			slow = slow.next;
		}
		Node start = fast.next;
		fast = start;
		
		while(fast.next != slow){
			fast = fast.next;
		}
		fast.next = null;
		return true;
	}
	
	public static void display(){
		if (head == null) return;
		else{
			Node curr = head;
			String output = "";
			while (curr != null){
				output+=curr.value+"-->";
				curr = curr.next;
			}
			System.out.println(output+"null");
		}
	}
	
	
}

class Node{
	int value;
	Node next;
	Node(int value){
		this.value = value;
	}
}
