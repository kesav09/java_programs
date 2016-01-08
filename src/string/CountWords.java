package string;

import java.util.StringTokenizer;

public class CountWords {

	private static String word = "my  name is    abhinav";
	public static void main(String [] args){
		System.out.println(countWordsInString(word));
		System.out.println(countWordsInStringUsingSplit(word));
	}
	
	public static int countWordsInString(String word){
		int count = 0;
		StringTokenizer st = new StringTokenizer(word, " ");
		StringBuffer sb = new StringBuffer();
		while(st.hasMoreElements()){
			String nextToken = st.nextToken();
			count++;
			sb.append(nextToken).append(" ");
		}
		System.out.println(sb.toString().trim());
		return count;
	}
	
	public static int countWordsInStringUsingSplit(String word){
		if(word == null) {
			return -1;
		}
		return word.split("\\s+").length;
	}
}
