package testng;

public class Reverse {
	/* yahoo - oohay
	 * o + yaho
	 * oo + yah
	 * ooh + ya
	 * oohy + a
	 * oohya
	*/
	public static String reverse(String rev){
		if(rev.length() == 0){
			return "";
		}
		return rev.charAt(rev.length() - 1) + reverse(rev.substring(0,rev.length() - 1));
	}
	
	public static void main(String[] args){
		System.out.println(reverse("yahoo"));
		
	}
}
