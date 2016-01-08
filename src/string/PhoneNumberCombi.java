package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

 * @author kvenkata
 *
 */
public class PhoneNumberCombi {

    public static Map<String,String> mapping = new HashMap<String,String>();
	static {
		// Map all key pad numbers to expected to char combination
        mapping.put("1","");
		mapping.put("2","abc");
		mapping.put("3","def");
		mapping.put("4","ghi");
		mapping.put("5","jkl");
		mapping.put("6","mno");
		mapping.put("7","pqrs");
		mapping.put("8","tuv");
		mapping.put("9","wxyz");
		mapping.put("0","");
    }
	public static void main(String[] args){
		PhoneNumberCombi obj = new PhoneNumberCombi();
		
		System.out.println(obj.letterCombinations("12230"));
	}
	
	public List<String> letterCombinations(String digit) {
		List<String> input = new ArrayList<String>();
		if (digit == null || digit.isEmpty()) return input;
		return letterCombinations(digit,input);
    }

	private List<String> letterCombinations(String digit,
			List<String> input) {
		if (digit.isEmpty() || digit.equals("0") || digit.equals("1")){
			return input;
		}
		List<String> output = new ArrayList<String>();
		// get first digit from the number
		String initial = digit.substring(0,1);
		// get remaining digits
		String rem = digit.substring(1);
		// get corresponding word for initial digit
		String word = mapping.get(initial);
		// If input is empty which means add the char combination of digit to list
		if (input.size() == 0){
			for (char c:word.toCharArray()){
				output.add(new Character(c).toString());
			}
		} else {
			// If already some char present then combine latest char with already present combination
			for (String str:input){
				for (char c:word.toCharArray()){
					output.add(str + c);
				}
			}
		}
		return letterCombinations(rem,output);
	}
}
