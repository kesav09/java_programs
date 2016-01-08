package string;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RepeatedSubString {

	public static void main(String [] args){
		System.out.println(getRepeatedSubstrings("ABCABCA", 2));
	}
	
	private static Set<String> getRepeatedSubstrings(String input, int len) {
        if (input == null) throw new IllegalArgumentException();
        if (input.length() < len * 2) return new TreeSet<String>();
        int lastIdx = input.length() - len;
        Set<String> unique = new HashSet<String>();
        Set<String> res = new TreeSet<String>();
        for (int i = 0; i <= lastIdx; i++) {
            String substr = input.substring(i, i + len);
            if (!unique.add(substr)) {
                res.add(substr);
            }
        }
        return res;
    }
}
