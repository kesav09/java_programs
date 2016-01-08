package matrix;

public class RotateMatrixBy90Degree {
	
	private static int [][] matrix = new int [][]{{1, 2, 3}, 
		  										  {4, 5, 6},
		  										  {7, 8, 9}
		  										};
	private static int m = 3;
	private static int n = 3;
	
	//o/p = 7 4 1
	//      8 5 2
	//      9 6 3
	//1. transpose the matrix
	// o/ p - 1 4 7
	//        2 5 8
	//        3 6 9
	//2. swap the columns
	//        7 4 1
	//        8 5 2
	//        9 6 3
	public static void main(String [] args){
		rotate(matrix);
	}
	
	private static void rotate(int [] [] matrix){
		
		// Transpose the matrix
	    for ( int i = 0; i < m; i++ ) {
	        for ( int j = i + 1; j < n; j++ ) {
	            int tmp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = tmp;
	        }
	    }
		
		//swap the columns
		for ( int i = 0; i < m; i++ ) {
	        for ( int j = 0; j < n/2; j++ ) {
	            int tmp = matrix[i][j];
	            matrix[i][j] = matrix[i][n-1-j];
	            matrix[i][n-1-j] = tmp;
	        }
	    }
		
		// Print the rotated matrix
	    for ( int i = 0; i < m; i++ ) {
	        for ( int j = 0; j < n; j++ ) {
	            System.out.print(matrix[i][j]+"   ");
	        }
	        System.out.println();
	    }
	}
}
