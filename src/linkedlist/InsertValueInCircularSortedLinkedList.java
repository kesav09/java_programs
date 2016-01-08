package linkedlist;

//insert a value in sorted circular linked list
// multiple cases 
//1. null list
//2. one element in list
//3. 2 element in list
//4. smallest element
//5. largest element
//6. middle element in list
public class InsertValueInCircularSortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularList list = null;
		list = insert(list, 1);
		list.next = new CircularList(3);
		list.next.next = new CircularList(5);
		list.next.next.next = list;
		list.printList();
		System.out.println();
		list = insert(list, 2);
		list.printList();
	}
	
	public static CircularList insert(CircularList list, int value){
		if (list == null){
			return new CircularList(value);
		}else if (list.next == null){
			list.next = new CircularList(value);
			list.next.next = list;//points back to head reference so form a cycle
		}else if (value < list.value){//smallest element 
			CircularList curr = list;
			while(curr.next != list){
				curr = curr.next;
			}
			curr.next = new CircularList(value);
			curr.next.next = list;
			return curr.next;
		}else{//middle element
			CircularList curr = list;
			while(curr.next != list && curr.next.value <= value){
				curr = curr.next;
			}
			CircularList currentNext = curr.next;
			curr.next = new CircularList(value);
			curr.next.next = currentNext;
			return list;
		}
		return list;
	}

}

class CircularList{
	int value;
	CircularList next;
	
	public CircularList(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		next = this;//self reference
	}
	
	public void printList(){
		if (this == null) return;
		CircularList current = this;
		do {
			System.out.print(current.value+",");
			current = current.next;
		}while(current != this);
	}
}
