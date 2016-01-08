package stack;

import java.util.Stack;

public class EvaluatePostFix {
	//AB+CD-*
	//
	public int evaluatePostFix(String str) throws Exception{
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<str.length();i++){
			if(isDigit(str.charAt(i))){
				stack.push(str.charAt(i) - '0');
			} else if(isOperand(str.charAt(i)) && !stack.isEmpty()){
				int n1 =  stack.pop();
				int n2 =  stack.pop();
				int val = evaluate(str.charAt(i),n1,n2);
				stack.push(val);
			} else{
				throw new Exception("Malformed PostFix expression.");
			}
		}
		
		return stack.pop();
	}

	public boolean isDigit(char c){
		if('0' <= c || c >= '9'){
			return true;
		}
		return false;
	}

	public boolean isOperand(char c){
		if(c == '+' || c == '-' || c == '*' || c == '/'){
			return true;
		}
		return false;
	}

	public int evaluate(char c, int n1, int n2){
		switch(c){
			case '+':
				return n2+n1;
			
			case '-':
				return n2-n1;
				
			case '*':
				return n2*n1;
				
			case '/':
				return n2/n1;
			
			default:
				return 0;
		}
	}

	public static void main(String[] args){
		EvaluatePostFix evaluatePostFix = new EvaluatePostFix();
		try {
			System.out.println(evaluatePostFix.evaluatePostFix("69+97-*"));//30
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

