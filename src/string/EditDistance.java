package string;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
   Insert
   Remove
   Replace
   All of the above operations are of equal cost.
 */
public class EditDistance {
	public static void main(String[] args) {
		String str1 = "cat";
		String str2 = "bus";
		System.out.println(getMinimumDistance(str1,str2));
	}
	
	public static int getMinimumDistance(String str1,String str2){
		if (str1.length() == 0){
			return str2.length();
		}
		
		if (str2.length() == 0){
			return str1.length();
		}
		
		int[][] dpArray = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length();i++){
			dpArray[0][i] = i;
		}
		
		for (int i = 0; i <= str2.length();i++){
			dpArray[i][0] = i;
		}
		
		for (int i = 1; i <= str1.length();i++){
			for (int j = 1;j <= str2.length(); j++){
				if (str1.charAt(i - 1) == str2.charAt(j - 1)){
					dpArray[i][j] = dpArray[i-1][j-1];
				} else {
					dpArray[i][j] = 1 + Math.min(Math.min(dpArray[i-1][j],dpArray[i][j-1]),dpArray[i-1][j-1]);
				} 
			}
		}
		return dpArray[str1.length()][str2.length()];
	}
}
