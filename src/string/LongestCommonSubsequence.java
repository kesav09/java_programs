
//A subsequence of a string S, is a set of characters that appear in leftto-right order, 
//but not necessarily consecutively

package string;

// FIXME this is the best solution available
// This problem is actually used in Git code compate
//http://stackoverflow.com/questions/2929557/java-longest-common-subsequence
public class LongestCommonSubsequence {

	private static String str1 = "thisisatest";
	private static String str2 = "testing123testing";
	public static void main(String [] args){
		System.out.println(getLongestCommonSubstring(str1, str2));
	}
	
	public static String getLongestCommonSubstring(String a, String b){
		String x;
        String y;

        int alen = a.length();
        int blen = b.length();
        if (alen == 0 || blen == 0) {
            return "";
        } else if (a.charAt(alen - 1) == b.charAt(blen - 1)) {
            return getLongestCommonSubstring(a.substring(0, alen - 1), b.substring(0, blen - 1)) + a.charAt(alen-1);
        } else {
            x = getLongestCommonSubstring(a, b.substring(0, blen - 1));
            y = getLongestCommonSubstring(a.substring(0, alen - 1), b);
            return (x.length() > y.length()) ? x : y;
        }
	}
}
