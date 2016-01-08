package number;
/**
 * check given number is polyndrome or not
 * @author kvenkata
 *
 */
public class Palindrome {
	public static void main(String[] argv){
		int num = 1000000009;
		int tmp = num;
		System.out.println(num);
		int rev = 0;
		while (tmp > 0 && tmp > rev){
			rev = rev * 10 + tmp % 10;
			tmp = tmp / 10;
			System.out.println("num :-"+tmp+" rev :-"+rev);
		}
		//System.out.println(isPalindrome(num));
		if (tmp == rev){
			System.out.println("input is polindrome");
		}else {
			System.out.println("input is not polindrone");
		}
	}
	

	public static boolean isPalindrome(int x) {
	  if (x < 0) return false;
	  int div = 1;
	  while (x / div >= 10) {
	    div *= 10;
	  }        
	  while (x != 0) {
	    int l = x / div;
	    int r = x % 10;
	    if (l != r) return false;
	    x = (x % div) / 10;
	    div /= 100;
	  }
	  return true;
	}

}
