package misc;



import java.util.List;
import java.util.Stack;

public class IterativeBacktracking {
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
	 * eg 2: { 1,2,3,6,7,8 } Sum : 10 o/p : (3,7) , (2,8) (1,2,7)
	 */

	public static void iterativeBacktracking(int[] input, int expectedSum) {
		int index = 0;
		int startIndex = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (startIndex < input.length) {
			int currentInt = input[index];

			int sum = calculateSum(stack) + currentInt;

			if (sum == expectedSum) {
				stack.push(currentInt);
				printStack(stack);
				index++;
			} else if (sum < expectedSum) {
				stack.push(currentInt);
				index++;
			} else if (sum > expectedSum) {
				if(stack.size() > 1){
					stack.pop();
				} else {
					index++;
				}
			}

			if (index == input.length) {
				startIndex++;
				index = startIndex;
				stack.removeAllElements();
				continue;
			}
		}
	}

	public static int calculateSum(List<Integer> stack) {
		int sum = 0;
		for (int i = 0; i < stack.size(); i++) {
			sum += stack.get(i);
		}
		return sum;
	}

	public static void printStack(Stack<Integer> stack) {
		System.out.print("\n { ");
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + " ");
		}
		System.out.print("}");

	}
	
//	public static void recursiveBacktracking(int[] input, int expectedSum, int currentSum, int index){
//		int currentInt = input[index];
//		currentSum += currentInt;
//		if(currentSum == expectedSum){
//			print()
//			return;
//		}
//		recursiveBacktracking(index);
//	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 6, 7, 8, 10};

		iterativeBacktracking(input, 10);
		//recursiveBacktracking();
	}
}
