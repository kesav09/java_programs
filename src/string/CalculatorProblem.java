package string;

import java.util.Stack;

/**
 * Given string return expression value
 * http://zwzbill8.blogspot.com/2015/06/leetcode-basic-calculator.html
 * @author kvenkata
 *
 */
public class CalculatorProblem {
		public static void main(String[] args){
			CalculatorProblem obj = new CalculatorProblem();
			System.out.println(obj.calculate("-1+(0+3)-5"));
		}
	    private boolean isDigit(char ch) {
	        return ch >= '0' && ch <= '9';
	    }
	    
	    private void pushOrAddOrMinus(
	        String str, 
	        Stack<String> stack
	    ) {
	        if (stack.empty() || stack.peek().equals("(")) {
	            stack.push(str);
	            return;
	        }
	        int val = Integer.valueOf(str);
	        if (stack.peek().equals("+")) {
	            stack.pop();
	            int val_o = Integer.valueOf(stack.pop());
	            stack.push(String.valueOf(val_o + val));
	        } else if (stack.peek().equals("-")) {
	            stack.pop();
	            int val_o = Integer.valueOf(stack.pop());
	            stack.push(String.valueOf(val_o - val));
	        }
	    }
	    
	    public int calculate(String s) {
	        if (s.length() == 0 || s == null) {
	            return 0;
	        }
	        Stack<String> stack = new Stack<String>();
	        String sign = "";
	        int i = 0;
	        if(s.startsWith("-")){
				i = 1;
				sign = "-";
	        }
	        
	        while (i < s.length()) {
	            if (s.charAt(i) == '+') {
	                stack.push("+");
	                i++;
	            } else if (s.charAt(i) == '-') {
	                stack.push("-");
	                i++;
	            } else if (s.charAt(i) == '(') {
	                stack.push("(");
	                i++;
	            } else if (s.charAt(i) == ')') {
	                String str = stack.pop();
	                stack.pop();
	                i++;
	                pushOrAddOrMinus(str, stack);
	            } else if (s.charAt(i) == ' ') {
	                i++;  
	            } else {
	                int j = i + 1;
	                while (j < s.length() && isDigit(s.charAt(j))) {
	                    j++;
	                }
	                String str = s.substring(i, j);
	                // This is to handle the sign
	                if (stack.isEmpty()){
	                	str = sign + str;
	                }
	                i = j;
	                pushOrAddOrMinus(str, stack);
	            }
	        }
	        return Integer.valueOf(stack.pop());
	    }
}
