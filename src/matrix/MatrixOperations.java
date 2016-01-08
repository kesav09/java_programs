package matrix;

class MatrixOperations{
	public int[][] multiply(int[][] a, int[][] b){
		int rowA = a.length;
		int colB = b[0].length;
		int colA = a[0].length;

		int[][] c = new int[rowA][colB];
		//2x3 * 3x3
		for(int i=0;i<rowA;i++){
			for(int j=0;j<colB;j++){
				for(int k=0;k<colA;k++){
					c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
				}
			}
		}
		return c;
	}
}
