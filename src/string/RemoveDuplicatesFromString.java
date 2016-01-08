package string;

import java.util.Arrays;

// Remove duplicate string without using additional memory
public class RemoveDuplicatesFromString {
	public static void main(String[] args){
		String str = "aaadeeafccd";
		char[] charArry = str.toCharArray();
		System.out.println(removeDupes(charArry));
	}
	
	public static char[] removeDupes(char[] arr){
        if (arr == null || arr.length < 2)
            return arr;
        int len = arr.length;
        int tail = 1;
        for(int x = 1; x < len; x++){
            int y;
            for(y = 0; y < tail; y++){
                if (arr[x] == arr[y]) break;
            }
            if (y == tail){
                arr[tail] = arr[x];
                tail++;
            }
        }
        return Arrays.copyOfRange(arr, 0, tail);
    }
}
