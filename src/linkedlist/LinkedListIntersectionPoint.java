package linkedlist;

public class LinkedListIntersectionPoint{

	static class List {
		int value;
		List next;
		List(int value){
			this.value = value;
			next = null;
		}
	}
	
	public static void main(String [] args){
		List list1 = new List(1);
		list1.next = new List(2);
		list1.next.next = new List(3);
		list1.next.next.next = new List(4);
		list1.next.next.next.next = new List(5);
		list1.next.next.next.next.next = new List(6);
		display(list1);
		System.out.println();

		List list2 = new List(7);
		list2.next = new List(5);
		list2.next.next = new List(6);
		display(list2);
		System.out.println(getIntersectionPoint(list1,list2).value);
	}

	private static List getIntersectionPoint(List list1, List list2){
		if(list1 == null || list2 == null){
			return null;
		}
		List curr = null;
		int d1 = getCountOfNodes(list1);
		int d2 = getCountOfNodes(list2);
		if (d1 > d2){
			curr = traverse(list1, d1-d2);
		}else if (d1 < d2){
			curr = traverse(list2, d2-d1);
		}else{
			return list1;
		}
		while(curr != null ){
			curr = curr.next;
			if (curr.value == list2.value){
				return curr;
			}
		}
		return null;
	}

	private static List traverse(List list, int diff){
		List curr = list;
		while(diff > 0){
			curr = curr.next;
			diff--;
		}
		return curr;
	}

	private static int getCountOfNodes(List list1){
		List curr = list1;
		int count = 0;
		while(curr != null){
			count++;
		}
		return count;
	} 

	private static void display(List list){
		while(list != null){
			System.out.print(list.value+",");
		}
	}
}

