package stack;

import java.util.Stack;

public class InfixToPostFix {
	/**
	 * A+B-C -> AB+C- 
	 * A+B*C -> ABC*+
	 * A*B+C -> AB*C+
	 * A*(B+C) -> ABC+*
	 */
	public static String infixToPostFix(String infix){
	Stack<Character> stack = new Stack<Character>();
	StringBuilder sb = new StringBuilder();
	for(int i=0;i<infix.length();i++){
		char c = infix.charAt(i);
		
				switch(c){
					case '+':
					case '-':
						pushOperator(c,1,stack,sb);
						break;
					case '*':
					case '/':
						pushOperator(c,2,stack,sb);
						break;
						
					case '(':
						stack.push(c);
						break;
					
					case ')':
						while(!stack.isEmpty()){
							char popElem = stack.pop();
							if(popElem == '('){
								break;
							}
							sb.append(popElem);
						}
						break;
					
					default:
						sb.append(c);
				}
		}
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	// A+B*C - ABC*+
	// A*B+C - AB*C+
	public static void pushOperator(char c, int pr1, Stack<Character> stack, StringBuilder sb) {
		if (stack.isEmpty()) {
			stack.push(c);
			return;
		}
		char popElem = stack.pop();
		int pr2 = 0;
		if (popElem == '+' || popElem == '-') {
			pr2 = 1;
		} else if (popElem == '*' || popElem == '/') {
			pr2 = 2;
		}
		// *>+
		if (pr1 > pr2) {
			stack.push(popElem);
			stack.push(c);
		} else {
			stack.push(c);
			sb.append(popElem);
		}
	}

	/**
	 * A+B-C -> AB+C- 
	 * A+B*C -> ABC*+
	 * A*B+C -> AB*C+
	 * A*(B+C) -> ABC+*
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(infixToPostFix("A+B-C"));
		System.out.println(infixToPostFix("A+B*C"));
		System.out.println(infixToPostFix("A*B+C"));
		System.out.println(infixToPostFix("A*(B+C)"));
	}
}
