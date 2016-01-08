package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * http://emmanueljohn.me/2015/07/05/shunting-yard-algorithm/
 * To solve this problem, we need to
 * 1. Conversion expression to postfix
 * 2. Then evaluate using stack
 * @author kvenkata
 *
 */
public class StringExpressionUsingStack {
	public int calculate(String s) {
        s = s.trim();
        
        //Using Djikstra's shunting yard algorithm
        //the basic idea is to convert the string from infix notation to postfix notation
        Stack<Operator> ops = new Stack<Operator>();
        Queue<String> out = new LinkedList<String>();
        
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(c == ' ') { i++; continue;}//skip spaces
            boolean isDigit = (c >= '0' && c <= '9');
            if(!isDigit){ // i.e c == '+' || c == '-'|| c == '*'|| c == '/'
                
	            Operator op = new Operator().parse(c);
	        
	            while(ops.peek() != null){
	                if(op.rank <= ops.peek().rank)
	                    out.add(ops.pop().toString());
	                else
	                    break;
	            }
	            ops.push(op);
	            i++;
            }else{
                //read numbers, remember number can be more than one digit.
                String num ="";
                while(i< s.length()){
                    c = s.charAt(i);
                    if((c >= '0' && c <= '9')){
                        num +=c;
                        i+=1;
                    }else
                        break;
                }
                out.add(num);
            }
        }
        
        while(!ops.isEmpty()){
            out.add(ops.pop().toString());
        }

        Stack<Long> comp = new Stack<Long>();
        // Now lets use the postfix algorithm to produce the result of the computation
        while(!out.isEmpty()){
            String v = out.poll();
            char c = v.charAt(0);
            if(c == '+' ){
                long a = comp.pop();
                long b = comp.pop();
                comp.push(b + a);
            }else if( c == '-'){ 
                long a = comp.pop();
                long b = comp.pop();
                comp.push(b - a);
            }else if( c == '*'){
                long a = comp.pop();
                long b = comp.pop();
                comp.push(b * a);
            } else if( c == '/'){
                long a = comp.pop();
                long b = comp.pop();
                comp.push(b / a);
            }else{
                comp.push(Long.parseLong(v));//Long is used here to scale for extremely large inputs e.g "1-25525252"
            }
        }
        
        return comp.pop().intValue();
    }
    //See [Operator precedence](http://en.cppreference.com/w/cpp/language/operator_precedence)
    class Operator{
        int rank;
        char sign;
        public Operator(){}
        public Operator(int rank, char sign){
            this.rank = rank;
            this.sign = sign;
        }
        public Operator parse(char c){
            Operator op =null;
            if(c == '-'){
                op = new Operator(1, '-');
            }else if(c == '+'){
                op = new Operator(1, '+');
            }else if(c =='*'){
                op = new Operator(2, '*');
            }else if(c=='/'){
                op = new Operator(2, '/');
            }
            return op;
        }
        public String toString(){
            return sign+"";
        }
    }
}
