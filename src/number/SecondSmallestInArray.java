package number;

/**
 * http://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
 * @author kvenkata
 *
 */
public class SecondSmallestInArray {
	public static void main(String[] args){
		//int[] array = {1,4,5,20,3,13,25};
		int[] array = {1,1,1,1};
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		for (int num : array){
			if (num < second){
				if (num <= first){
					second = first;
					first = num;
				} else {
					second = num;
				}
			}
		}
		if (first != second){
			System.out.println("first :- "+first+" second :- "+second);
		} else {
			System.out.println(" There is no second smallest");
		}
		
	}
}
