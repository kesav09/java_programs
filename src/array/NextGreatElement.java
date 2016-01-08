package array;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/next-greater-element/
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * @author kvenkata
 *
 */
public class NextGreatElement {
	public static void main(String[] args){
		int arr[]= {11, 13, 21, 3};
		Stack<Integer> s = new Stack<Integer>();
		/* push the first element to stack */
		s.push(arr[0]);
		int ele,next;
		// iterate for rest of the elements
		for (int i = 1; i < arr.length; i++){
			next = arr[i];
			if (s.isEmpty() == false){
				// if stack is not empty, then pop an element from stack
				ele = s.pop();
				 /* If the popped element is smaller than next, then
                a) print the pair
                b) keep popping while elements are smaller and
                stack is not empty */
				while (ele < next){
					System.out.println(String.format(" Element %d - next highest %d",ele,next));
					if (s.isEmpty()) break;
					ele = s.pop();
				}
				/* If element is greater than next, then push
	               the element back */
				if (ele > next){
					s.push(ele);
				}
			}
			 /* push next to stack so that we can find
	           next greater for it */
			s.push(next);
		}
		  /* After iterating over the loop, the remaining
	       elements in stack do not have the next greater
	       element, so print -1 for them */
		while (s.isEmpty() == false){
			System.out.println(String.format(" Element %d - next highest %d",s.pop(),-1));
		}
	}
}
