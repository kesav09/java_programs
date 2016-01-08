package string;

/**
 * given array replace multiple of 3 with Fuzz and replace multiple of 5 with Buzz and then print array
 * @author kvenkata
 *
 */
public class FuzzBuzzProblem {
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 15; i++){
			if (i % 3 ==0 && i % 5 == 0){
				sb.append("FuzzBuzz\n");
			}
			else if (i % 3 == 0){
				sb.append("Fuzz\n");
			} else if (i % 5 == 0){
				sb.append("Buzz\n");
			} else {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
