package sorting;

import java.util.Arrays;
import java.util.Comparator;
// Program to sort strings based on string length
public class SortStringsBasedOnLength {
	public static void main(String[] args){
		String[] input = {"a","bb","d","eee","bb"};
		// Sort array based on string length
		Arrays.sort(input, new Comparator<String>(){
			public int compare(String str1, String str2){
			return str1.length() - str2.length();
		}});
		// print array
		for (String str:input){
			System.out.println(str);
		}
	}
}
