package string;

public class ParseDouble{
	public static void main(String[] args){
	
		System.out.println(getValue( ".1222"));
		System.out.println(getValue( "12.00"));
		System.out.println(getValue( "12.0"));
		System.out.println(getValue( "+12.0"));
		System.out.println(getValue( "+12"));
		System.out.println(getValue( "+12."));
		System.out.println(getValue( "12.1212"));
		System.out.println(getValue( "-12.1212"));
		System.out.println(getValue( "-12.1212"));
		System.out.println(getValue( "-12.1212,sas"));
	}
	
	public static double getValue(String str){
		if(str == null || str.isEmpty()){
			return 0;
		}

		char c;
		boolean isNegative = false;
		
		str = str.trim();
		int i=0;
		if(str.charAt(0) == '-'){
			isNegative = true;
			i++;
		} else if(str.charAt(0) == '+'){
			i++;
		}
		
		double sum = 0.0,decimalSum = 0.0;
		boolean isDecimal = false;
		double divisor = 1; 
		for(;i<str.length();i++){
			c = str.charAt(i);
			
			if(c == '.' && !isDecimal){
				isDecimal = true;
			}else if(Character.isDigit(c) && !isDecimal){
				sum = (sum * 10) + (str.charAt(i) - '0');
			}  else if(Character.isDigit(c) && isDecimal){
				decimalSum = (decimalSum * 10) + (str.charAt(i) - '0');
				divisor = divisor * 10;
			} else {
				throw new NumberFormatException("String is malformed. String: " + str);
			}
		}
		decimalSum = (decimalSum / divisor);
		sum = sum + decimalSum;
		if(isNegative){
			sum = 0.0 - sum;
		}
		return sum;
	}
}
