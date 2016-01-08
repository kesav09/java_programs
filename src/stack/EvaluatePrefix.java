package stack;

import java.util.Stack;

public class EvaluatePrefix {
	//+*123 = 5
	//* + A B + C D = (A + B) * (C + D) 
	//+ * A B * C D =  A * B + C * D
	// A + B * C + D = + + A * B C D
	// A + B + C + D = + + + A B C D
	public static int evaluatePrefix(String prefixExp) {
		Stack<Character> operatorStack = new Stack<Character>();
		Stack<Integer> operandStack = new Stack<Integer>();
		char c;
		int num1, num2;
		char operator;
		//try {
			for (int i = 0; i < prefixExp.length(); i++) {
				c = prefixExp.charAt(i);
				if (isOperator(c)) {
					operatorStack.push(c);
				} else {
					num1 = c - '0';
					if(i+1<prefixExp.length() && !isOperator(prefixExp.charAt(i+1))){
						num2 = prefixExp.charAt(++i) - '0';
					} else if(i+1<prefixExp.length() && isOperator(prefixExp.charAt(i+1))){
						operatorStack.push(prefixExp.charAt(++i));
						operandStack.push(num1);
						continue;
					} else {
						num2 = operandStack.pop();
					}
					operator = operatorStack.pop();
					operandStack.push(evaluateExpression(num1, num2, operator));
				}
			}
			
			while(!operatorStack.isEmpty()){
				num1 = operandStack.pop();
				num2 = operandStack.pop();
				operator = operatorStack.pop();
				operandStack.push(evaluateExpression(num2, num1, operator));	//notice num2,num1 sequence.
			};
		/*} catch (Exception e) {
			System.out.println("Prefix string is malformed.");

		}*/
		return (!operandStack.isEmpty() ? operandStack.pop() : 0);
	}

	public static int evaluateExpression(int num1,int num2,char operator){
		switch(operator){
			case '+':
				return num1 + num2;
			case '-':
				return num1 - num2;
			case '*':
				return num2 * num1;
			case '/':
				return num1/num2;
			default:
				return 0;
		}
	}

	public static boolean isOperator(char c){
		if(c == '+' || c == '-' || c == '*' || c == '/'){
			return true;
		}
		return false;
	}



	//+*123 = 5
	//* + A B + C D = (A + B) * (C + D) -> *+52+34 = (5+2)*(3+4) = 49
	//+ * A B * C D =  A * B + C * D -> +*52*74 = (5*2)+(7*4) = 38
	//  + + A * B C D = A + B * C + D -> ++5*274 = 5+2*7+4 = 5+14+4 = 23 //special case where two operands are not followed by each other.
	// + + + A B C D = A + B + C + D -> +++5274 = 5+2+7+4 = 18
	public static void main(String[] args){
		System.out.println(EvaluatePrefix.evaluatePrefix("+*123"));//5
		System.out.println(EvaluatePrefix.evaluatePrefix("*+52+34"));//49
		System.out.println(EvaluatePrefix.evaluatePrefix("+*52*74"));//38
		System.out.println(EvaluatePrefix.evaluatePrefix("++5*274"));//23
		System.out.println(EvaluatePrefix.evaluatePrefix("+++5274"));//18
	}

}
