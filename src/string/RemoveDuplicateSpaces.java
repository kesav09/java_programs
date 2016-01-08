package string;

import java.util.Arrays;
import java.util.StringTokenizer;

public class RemoveDuplicateSpaces {
	public static void main(String a[]){
		String str = "String    With Multiple      Spaces";
		int count = 0;
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuffer sb = new StringBuffer();
		while(st.hasMoreElements()){
			String nextToken = st.nextToken();
			System.out.println(nextToken);
			count++;
			sb.append(nextToken).append(" ");
		}
		System.out.println(sb.toString());
		System.out.println(count);
		//FIXME use this approach as it is very optimal
		String temp = str.replaceAll("\\s+","");
		// FIXME this is another approach but lot of code
		String[] strArry = str.split("\\s+");
		for (String s:strArry){
			System.out.println(s);
		}
		
		// FIXME this is another approach without additional space and O(n) complexity
		count = 0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < str.length();i++){
			if (str.charAt(i) != ' '){
				chars[count] = chars[i];
				count++;
			}
		}
		System.out.println(Arrays.copyOfRange(chars,0,count));
	}
}