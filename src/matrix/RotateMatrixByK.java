package matrix;


// rotate matrix by k elements concentrically.
public class RotateMatrixByK {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][] matrix = {{1,2},{3,4}};
		
		/*int[][] matrix ;
		Scanner stdin = new Scanner(System.in);
	    if(stdin.hasNextLine())
	    {
	        String line = stdin.nextLine();
	        int rowCol = Integer.parseInt(line);
	        matrix = new int[rowCol][rowCol];
	        int row = 0;
	        while(stdin.hasNextLine()){
		        line = stdin.nextLine();
	        	String[] tokens = line.split(" ");
	        	for(int i=0;i<tokens.length;i++){
	        		matrix[row][i]= Integer.parseInt(tokens[i]);
	        	}
	        	row++;
	        }
	    } else {
	    	System.out.println("ERROR");
	    	return;
	    }*/
	    
	    if(matrix.length != matrix[0].length){
	    	System.out.println("ERROR");
	    }

		for(int i=0;i<matrix.length/2;i++){
			rotateMatrix(matrix,0);
		}
		
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix.length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}

	public static void rotateMatrix(int[][] matrix, int rowCol) {

		int i = rowCol, j = rowCol;
		int temp = matrix[i][j];
		while (j + 1 < matrix.length) {
			int newTemp = matrix[i][j + 1];
			matrix[i][j + 1] = temp;
			temp = newTemp;
			j++;

		}

		while (i + 1 < matrix.length) {
			int newTemp = matrix[i + 1][j];
			matrix[i + 1][j] = temp;
			temp = newTemp;
			++i;

		}

		while (j - 1 >= 0) {
			int newTemp = matrix[i][j - 1];
			matrix[i][j - 1] = temp;
			temp = newTemp;
			--j;
		}

		while (i - 1 >= 0) {
			int newTemp = matrix[i - 1][j];
			matrix[i-1][j] = temp;
			temp = newTemp;
			--i;
		}
	}
}
