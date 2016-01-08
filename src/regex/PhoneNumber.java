package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
	/** isPhoneNumberValid: Validate phone number using Java reg ex. 
	* This method checks if the input string is a valid phone number. 
	* @param email String. Phone number to validate 
	* @return boolean: true if phone number is valid, false otherwise. 
	*/  
	public static boolean isPhoneNumberValid(String phoneNumber){  
		boolean isValid = false;  
		/* Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn 
		    ^\\(? : May start with an option "(" . 
		    (\\d{3}): Followed by 3 digits. 
		    \\)? : May have an optional ")"  
		    [- ]? : May have an optional "-" after the first 3 digits or after optional ) character.  
		    (\\d{3}) : Followed by 3 digits.  
		     [- ]? : May have another optional "-" after numeric digits. 
		     (\\d{4})$ : ends with four digits. 
		 
		         Examples: Matches following phone numbers: 
		         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890 
		 
		*/  
		//Initialize reg ex for phone number.   
		String expression = "^[(]?\\d{3}[)]?[-]?\\d{3}[-]?\\d{4}$";
		Pattern pattern = Pattern.compile(expression);  
		Matcher matcher = pattern.matcher(phoneNumber);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
		}  
	
	private static boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
        //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        //validating phone number with extension length from 3 to 5
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
        //validating phone number where area code is in braces ()
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
        //return false if nothing matches the input
        else return false;
         
    }
	
		public static void main(String[] args){
			System.out.println(isPhoneNumberValid("408-685-1598"));
			System.out.println(isPhoneNumberValid("(408)-685-1598"));
			System.out.println(isPhoneNumberValid("(408-685-1598"));
			System.out.println(isPhoneNumberValid("408)-685-1598"));
			System.out.println(isPhoneNumberValid("(408)685-1598"));
			System.out.println(isPhoneNumberValid("4086851598"));
			System.out.println("********");
			System.out.println(validatePhoneNumber("408-685-1598"));
			System.out.println(validatePhoneNumber("(408)-685-1598"));
			System.out.println(validatePhoneNumber("(408-685-1598"));
			System.out.println(validatePhoneNumber("408)-685-1598"));
			System.out.println(validatePhoneNumber("(408)685-1598"));
			System.out.println(validatePhoneNumber("4086851598"));
		}
}
