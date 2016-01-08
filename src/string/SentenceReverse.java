package string;

public class SentenceReverse {

	static String word = "gyan";
	static String sentence = "my name is gyan";
	
	public static void main(String [] args){
//		System.out.println(reverse(word));
//		System.out.println(reverse());
		System.out.println(reverseASentence(sentence));

	}
	
	//eg : my name is gyan -> gyan is name my
	/*public static String reverseASentence(String sentence){
		
		char[] chars = reverse(sentence).toCharArray();
		
		int wordstart = 0;
		for (int i = 0; i < chars.length; i++){
			if (chars[i] == ' '){
				reverse(chars, wordstart, i - 1);
				wordstart = i + 1;
			}else if (i == chars.length - 1){
				reverse(chars, wordstart, i);
			}
		}
		return new String(chars);
	}*/
	
	/**
	 * More optimized
	 * @param sentence
	 * @return
	 */
	public static String reverseASentence(String sentence){
		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--){
			sb.append(words[i]);
			if (i != 0){
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
	public static String reverse(String word){
		if (word.length() < 1 || word.equals(" ") || word.equals(null)) return null;
		if (word.length() == 1) return word;
		
		char [] chars = word.toCharArray();
		
		int i = 0;
		int j = chars.length - 1;
		
		while (j  > i){
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
		return new String(chars);
	}
	
	//from to index
	public static String reverse(char[] sentence, int from, int to){
	
		int i = from;
		int j = to;
		
		while (j  > i){
			char temp = sentence[i];
			sentence[i] = sentence[j];
			sentence[j] = temp;
			i++;
			j--;
		}
		return new String(sentence);
	}
	
	//java implementation
	public static String reverse(){
		return new StringBuilder(word).reverse().toString();
	}
}