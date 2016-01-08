package linkedlist;

public class LinkedListReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new List(1);
		list.next = new List(2);
		list.next.next = new List(3);
		list.next.next.next = new List(4);
//		list.next.next.next.next = new List(5);
		System.out.println(list.toString());
		System.out.println();
//		System.out.println(reverse(list).toString());
		System.out.println(findMiddleElement(list));
		
	}
	
	public static int findMiddleElement(List list){
		if (list == null || list.next == null){
			
		}
		List slow = list;
		List fast = list;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.value;
	}
	
	
	//recursive
	public static List reverse(List list){
		if(list == null || list.next == null){
			return list;
		}
		List remaining = reverse(list.next);
		List curr = remaining;// 5 4 3 2 
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = list;
		list.next= null;
		return remaining;
	}
	
	
}

class List{
	int value;
	List next;
	List(int value){
		this.value = value;
		next = null;
	}
	
	public String toString(){
		List curr = this;
		String output = "";
		while(curr != null){
			output += curr.value+"-->";
			curr = curr.next;
		}
		return output+="null";
	}
}
