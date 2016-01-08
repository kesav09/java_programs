package string;

public class Pallindrome {

	static String word = "radar";
	
	public static void main(String [] args){
		System.out.println(isPallindrome(word));
	}
	
	public static boolean isPallindrome(String word){
		
		int i = 0; 
		int j = word.length() - 1;
		
		while (i < j){
			if (word.charAt(i) == word.charAt(j)){
				i++;
				j--;
			}else{
				return false;
			}
		}
		return true;
	}
}
