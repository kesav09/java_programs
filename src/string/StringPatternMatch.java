package string;

public class StringPatternMatch {

	static String text = "blake goes to mall";
	static String pattern = "goes";
	
	public static void main(String [] args){
		isPatternMatch(text, pattern);
	}
	
	public static boolean isPatternMatch(String text, String pattern){
		
		if (text.equals("") || pattern.equals("") || text.equals(null) || pattern.equals(null))
			System.err.println("text or pattern are empty");
		
		int patternCounter = 0;
		int textCounter = 0;
		
		int count = 0;
		while(textCounter <= text.length()){
			
			if (patternCounter == pattern.length()){
				int index = textCounter - patternCounter;
				System.out.println("pattern found at index :" + index);
				patternCounter = 0;
				count++;
			}
			
			if (textCounter == text.length())
				break;
			
			if (pattern.charAt(patternCounter) == text.charAt(textCounter)){
				patternCounter++;
			}else{
				patternCounter = 0;
				textCounter = textCounter - patternCounter;
			}
			
			textCounter++;
			
		}
		
		System.out.println("count  = "+count);
		
		if (count == 0)
			return true;
		else
			return false;
	}
}
