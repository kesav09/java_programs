package string;

public class StringCompress {
	public static String compressString(String input){
		int len = input.length();
	    StringBuffer sb = new StringBuffer();
	    int count = 1;
	    
	    for (int i = 0 ; i < len; i++){
	    	count = 1;
	        char c = input.charAt(i);
	        sb.append(c);
	        while (i < len -1 && c == input.charAt(i+1)){
	            count++;
	            i++;
	        }
	        if (count > 1){
	            sb.append(count);
	        }
	    }
	    String output = sb.toString();
	    return input.length() < output.length() ? input : output;
	}
	
	public static void main(String[] args){
		System.out.println(compressString("aaabbbbbaaaacdde"));
	}
}
