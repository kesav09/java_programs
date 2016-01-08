package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecursiveBacktracking {
	/*
	 * Write a Algorithm/java Snippet to find the combinations makes up the
	 * given summation. My Set containts numbers from 1,2...9, and you are given
	 * the desired sum to be find. 1) No Numbers are repeated 2) Numbers are in
	 * sorted format
	 * 
	 * eg : { 4,5,6,7} Sum = 11 o/p : (4,7),(5,6)
	 * 
	 * Sum=16 (4,5,7)
	 * 
	 * eg 2: { 1,2,3,6,7,8 } Sum : 10 o/p : (3,7) , (2,8), (1,2,7)
	 */

	
	public void printCombinations2(List<Integer> list, int expectedSum) {

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int j = i;
			while (true) {
				while (j < list.size()) {
					stack.push(list.get(j));
					int sum = calculateSum(stack);

					if (sum > expectedSum) {
						stack.pop();
						break;
					}

					if (sum == expectedSum) {
						System.out.print("{ ");
						for (int k : stack) {
							System.out.print(k + " ");
						}
						System.out.println("} ");
						stack.removeAllElements();
						break;
					}
					j++;
				}
				if (!stack.isEmpty()) {
					j = list.indexOf(stack.lastElement());
					stack.pop();
					if (stack.size() == 0) {
						break;
					}
					j++;
				} else {
					break;
				}
			}
		}
	}
	

	private int calculateSum(Stack<Integer> stack) {
		int sum = 0;
		for(Integer i : stack){
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(10);
		
		
		RecursiveBacktracking test = new RecursiveBacktracking();
		System.out.println("combinations for 10: ");
		test.printCombinations2(list,10);
		System.out.println("\n combinations for 11: ");
		test.printCombinations2(list,11);
		System.out.println("\n combinations for 16: ");
		test.printCombinations2(list,16);
	}

}
