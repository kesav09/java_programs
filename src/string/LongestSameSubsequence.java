
//if there is string "aabbbcc" then o/p will be bbb
//if there is string "abcd" then o/p will be abcd

package string;

public class LongestSameSubsequence {
	private static String str = "aaabbcccdd";

	public static void main(String [] args){
		//getLongestSameSubsequence(str);
		// FIXME this is the optimal solution
		getLongestSubSeq(str);
	}

	public static void getLongestSameSubsequence(String str){
		StringBuilder output = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		int tempLength = 1;
		int outputLength = 1;
		if (str.length() < 1) return;
		if (str.length() == 1) 
			System.out.println(str);
		else if (str.length() > 1){
			output.append(str.charAt(0));
			temp.append(str.charAt(0));

			for (int i = 1; i <= str.length();i++){
				
				if (i == str.length() && tempLength > outputLength){
					output.setLength(0);
					output.append(temp);
					break;
				}else if (i == str.length() && tempLength == 1 && outputLength == 1){
					break;
				}
					
				if (str.charAt(i) == str.charAt(i-1)){
					temp.append(str.charAt(i));
					tempLength++;
				}else {
					if (tempLength > outputLength){
						output.setLength(0);
						output.append(temp);
						outputLength = tempLength;
						tempLength = 1;
						temp.setLength(0);//clear temp string buffer
						temp.append(str.charAt(i));
					}
				}
			}
		}
		if (tempLength == outputLength)
			System.out.println(str.toString());
		else
			System.out.println(output.toString());
	}
	
	public static void getLongestSubSeq(String seq){
		if (seq == null || seq.length() <= 1) System.out.println(seq); 
		
		StringBuilder sb = new StringBuilder();
		sb.append(seq.charAt(0));
		String longest = sb.toString();
		
		for (int i = 1; i < seq.length(); i++){
			if (seq.charAt(i - 1) == seq.charAt(i)){
				sb.append(seq.charAt(i));
				continue;
			} else if (longest.length() < sb.length()){
				longest = sb.toString();
			}
			sb.setLength(0);
			sb.append(seq.charAt(i));
		}
		System.out.println(longest);
	}

}
