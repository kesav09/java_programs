package string;

import java.util.Random;

//https://jznest.wordpress.com/2014/03/25/zigzag-conversion/
// FIXME refer to ZigZagConversion.java solution from leetcode package
public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        // corner cases
        if(s == null) return null;
        if(s.equals("")) return s;
        if(nRows == 0) return null;
        if(nRows == 1) return s;
        
        StringBuilder[] builders = new StringBuilder[nRows];
        for(int i = 0; i < nRows; i++){
            builders[i] = new StringBuilder();
        }
        
        int nBetween = nRows - 2;
        int len = s.length();
        
        int count1 = 0;
        boolean inBody = true; // e.g., when processing P A Y 
        int count2 = 0;
        boolean inBetween = false; // e.g., when processing the single P in between
        
        for(int i = 0; i < len; i++){
            // pushing character to its corresponding builder
            if(inBody == true && count1 < nRows){
                builders[count1].append(s.charAt(i));
                count1++;
            }else if(inBetween == true && count2 < nBetween){
                builders[nRows - 2 - count2].append(s.charAt(i));
                count2++;
            }
            // state change between inBody and inBetween
            if(inBody == true && count1 == nRows){
                inBody = false;
                inBetween = true;
                count1 = 0;
            }else if(inBetween == true && count2 == nBetween){
                inBody = true;
                inBetween = false;
                count2 = 0;
            }
        }
        
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < nRows; i++){
            b.append(builders[i].toString());
        }
        return b.toString();
    }
    
    public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING",4));
		System.out.println(convertUsingRandom("PAYPALISHIRING"));
	}
    
    public static String convertUsingRandom(String s){
    	// corner cases
        if(s == null) return null;
        if(s.equals("")) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++){
        	Random r = new Random();
        	int at = r.nextInt(len-1);
        	sb.append(s.charAt(at));
        }
        
        return sb.toString();
    }
}
