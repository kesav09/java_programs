package number;

import java.util.Set;
import java.util.TreeSet;

public class FactorsOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printFactors(18);
	}
	
	//eg : the square root of 18 rounded up to the nearest integer is 5
	//testing the values 1 through 5 for division into 18 
	//we find the factors of 18 are (1 and 18), (2 and 9), (3 and 6) or the set 1, 2, 3, 6, 9, 18.
	public static void printFactors(int num){
		Set<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(num);
		int i = 2;
		while (i <= (int)Math.sqrt(num)){
			if(num % i == 0){
				set.add(i);
				int res = (int)num / i;
				set.add(res);
			}
			i++;
		}
		System.out.println(set);
	}
}
