package stack;

import java.util.*;
/*
 * For every enqueue operation, we add to the top of the stack1. For every dequeue, 
 * we empty the content's of stack1 into stack2, and remove the element at top of the stack.
 * Time complexity is O(n) for dequeue, as we have to copy the stack1 to stack2. 
 * time complexity of enqueue is the same as a regular stack
 */
public class QueueUsingStack {
	
	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

	public static void main(String [] args){
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		enqueue(5);
		enqueue(6);
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
	}
	
	public static void enqueue(int k){
		s1.push(k);
	}
	
	public static int dequeue(){
		
		if(s1.empty() && s2.isEmpty())
			return -1;
		
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		return s2.pop();	
	}
}