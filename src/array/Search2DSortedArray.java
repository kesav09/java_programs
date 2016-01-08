package array;

public class Search2DSortedArray {

	static int [][] sorted = new int [][]{{1, 4, 5}, 
										  {2, 6, 7}, 
										  };
									
	public static void main(String [] args){
		search(sorted, 6);
	}
	
	public static void search(int [][] sorted, int k){
		
		int i = sorted.length - 1;//row count
		int j = 0;//column count
		while(i >= 0 && j <= sorted[0].length - 1){
			if(sorted[i][j] > k)
				i--;
			else if (sorted[i][j] < k)
				j++;
			else {
				System.out.println("found at i:"+i+" and j: "+j);
				break;
			}
		}
	} 
}
