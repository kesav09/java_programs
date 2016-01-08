package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SsnValidator {
	/** isSSNValid: Validate Social Security number (SSN) using Java reg ex. 
	* This method checks if the input string is a valid SSN. 
	* @param email String. Social Security number to validate 
	* @return boolean: true if social security number is valid, false otherwise. 
	*/  
	 public static boolean isSSNValid(String ssn){  
	boolean isValid = false;  
	 /*SSN format xxx-xx-xxxx, xxxxxxxxx, xxx-xxxxxx; xxxxx-xxxx: 
	         ^\\d{3}: Starts with three numeric digits. 
	    [- ]?: Followed by an optional "-" 
	    \\d{2}: Two numeric digits after the optional "-" 
	    [- ]?: May contain an optional second "-" character. 
	    \\d{4}: ends with four numeric digits. 
	 
	        Examples: 879-89-8989; 869878789 etc. 
	*/  
	  
	//Initialize reg ex for SSN.   
	String expression = "^\\d{3}[-]?\\d{2}[-]?\\d{4}$";
	Pattern pattern = Pattern.compile(expression);  
	Matcher matcher = pattern.matcher(ssn);
	
	if(matcher.matches()){  
		isValid = true;
		System.out.println(matcher.group());
	}  
	return isValid;  
	}
	 
	public static void main(String[] args){
		System.out.println(isSSNValid("123-11-1111"));
		System.out.println(isSSNValid("123111111"));
		System.out.println(isSSNValid("123-111111"));
		System.out.println(isSSNValid("12311-1111"));
	}
}
