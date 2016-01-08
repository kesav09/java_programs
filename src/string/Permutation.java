//we can set aside the first char and permute the remaining char. in this case
//initial= X and permute(YZ) = YZ and ZY
//Next we can insert X into the available position of this string
//YZ � XYZ, YXZ, YZX
//ZY � XZY, ZXY, ZYX

package string;

/**
 * Instead of this program refer StringPermutations.java
 * @author kvenkata
 *
 */
public class Permutation {
	public static void permute(String word){
		if (word.length() < 1) return;
		if (word.length() == 1) return;

		StringBuilder output = new StringBuilder();
		boolean [] used = new boolean[word.length()];
		permute(word, output, used, 0);
	}

	public static void permute(String word, StringBuilder output, boolean [] used, int position){
		if (position == word.length())
			System.out.print(output+",");
		else{
			for (int i = 0; i < word.length(); i++){
				if (used[i]) continue;
				output.append(word.charAt(i));
				used[i] = true;
				permute(word, output, used, position+1);
				output.deleteCharAt(output.length()-1);
				used[i] = false;
			}
		}

	}

	public static  void main(String[] args) {
		permute("ABC");
	}
}