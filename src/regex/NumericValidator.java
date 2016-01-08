package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericValidator {
	/** isNumeric: Validate a number using Java regex. 
	* This method checks if the input string contains all numeric characters. 
	* @param email String. Number to validate 
	* @return boolean: true if the input is all numeric, false otherwise. 
	*/  
	  
	public static boolean isNumeric(String number){  
	boolean isValid = false;  
	  
	/*Number: A numeric value will have following format: 
	         ^[-+]?: Starts with an optional "+" or "-" sign. 
	     [0-9]*: May have one or more digits. 
	    \\.? : May contain an optional "." (decimal point) character. 
	    [0-9]+$ : ends with numeric digit. 
	*/  
	  
	//Initialize reg ex for numeric data.   
	String expression = "^[-+]?[0-9]*\\.?[0-9]+$";
	Pattern pattern = Pattern.compile(expression);  
	Matcher matcher = pattern.matcher(number);  
	if(matcher.matches()){
	isValid = true;  
	}  
	return isValid;  
	}  
	
	public static void main(String[] args){
		System.out.println(isNumeric("1234"));
		System.out.println(isNumeric(""));
		System.out.println(isNumeric("-12.34"));
	}
}
