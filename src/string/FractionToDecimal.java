package string;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
https://leetcode.com/problems/fraction-to-recurring-decimal/
 * @author kvenkata
 *
 */
public class FractionToDecimal {
	public static void main(String[] args){
		System.out.println(fractionToDecimal(1,-3));
	}
	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }
        StringBuilder output = new StringBuilder();
        
        if ((numerator < 0) && (denominator < 0)){
        	output.append("");
        } else if ((numerator < 0) || (denominator < 0)){
        	output.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        output.append(num / den);
        num %= den;
        if (num == 0) {
            return output.toString();
        }

        // fractional part
        output.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, output.length());
        while (num != 0) {
            num *= 10;
            output.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                output.insert(index, "(");
                output.append(")");
                break;
            }
            else {
                map.put(num, output.length());
            }
        }
        return output.toString();
    }
}
