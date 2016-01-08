package string;

public class ReverseVariants {
	
	public static void main(String[] args) {
		String str = "yahoo search";
		System.out.println(printStringInReverse(str));
		System.out.println(reverseByRecursion(str));
	}

	public static String printStringInReverse(String str) {
		if (str == null) {
			return null;
		}

		StringBuilder reverseStr = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; --i) {
			reverseStr.append(str.charAt(i));
		}
		return reverseStr.toString();
	}
	
	public static String reverseBySwapping(String str) {
		int mid = str.length() / 2;
		StringBuilder reverseStr = new StringBuilder();
		for (int i = 0, j = str.length() - 1; i < mid && j > mid; i++,j--) {
			reverseStr.insert(i, str.charAt(j));
			reverseStr.insert(j, str.charAt(i));
		}
		return reverseStr.toString();
	}
	
	/**
	abc - c + ab
	ab - b + a
	
	yahoo - o + yaho
	yaho  - o + yah
	yah	  - h + ya
	ya    - a + y
	 */	
	public static String reverseByRecursion(String str){
		if(str == null) {
			return str;
		} else if(str.length() == 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverseByRecursion(str.substring(0,str.length()-1));
	}
}
