package string;

// FIXME better solution is here http://www.journaldev.com/530/java-program-to-find-out-longest-palindrome-in-a-string
public class LongestPalindrome {
	public static void main(String[] args) {
		//String str = "nittinaade";
		//System.out.println(isPalindrome(str, 0, str.length()));
		longestPalindrome("nittinaade");
		longestPalindrome("nitinaade");
		longestPalindromeNaive("nittinaadenin");
		longestPalindromeNaive("nitinaade");
		longestPalindrome("nitinnnnaabhihbaanin");//odd length: 17
		longestPalindrome("nitin"); // odd length: 5
		longestPalindrome("5123443218"); // odd length: 10
	}

	public static void longestPalindrome(String str) {
		int longestStart = 0, longestEnd = 0;
		int left = 0, right = 0;
		for (int mid = 0;mid < str.length();mid++) {
			left = mid;
			right = mid;
			while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
				if ((longestEnd - longestStart) <= (right - left)) {
					longestStart = left;
					longestEnd = right;
				}
				left--;
				right++;
			}

			left = mid;
			right = mid + 1;
			while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
				if ((longestEnd - longestStart) <= (right - left)) {
					longestStart = left;
					longestEnd = right;
				}
				left--;
				right++;
			}
		}

		
		for (int i = longestStart; i <= longestEnd; i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}
	
	
	public static void longestPalindromeNaive(String string){
		int right = 0;
		int left = 0;
		for(int i=0;i<string.length();i++){
			for(int j=i+1;j<string.length();j++){
				if(isPalindrome(string,i,j)){
					if(j-i > right-left){
						right = j;
						left = i;
					}
				}
			}
		}
		
		System.out.println("longest palindrome: " + string.substring(left,right+1));
	}

	public static boolean isPalindrome(String string, int start, int end) {
		for (int i = start; i <= (start+end)/2; i++) {
			if (string.charAt(i) != string.charAt((start+end) - i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void venkatSol(String str){
		if (str == null)
		System.out.println("");
		if (str.length() == 1){
			System.out.println(str);
		}
		String longestPal = str.substring(0,1);
		int startIndex = 0, lastIndex = 0;
		for (int i = 1; i < str.length(); i++){
			
		}
	}
}