package tic_tac_toe;

public class TicTacToeGeneralized {
	public boolean isWinner(char[][] matrix, char c, int row, int col) {
		matrix[row][col] = c;
		if (isRowComplete(matrix, row, c) && isColumnComplete(matrix, col, c) 
				&& isOnDiagonal(matrix, row, col) && isDiagonalComplete(matrix, row, col, c)) {
			return true;
		}
		return false;
	}

	public boolean isRowComplete(char[][] matrix, int row, char c) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[row][i] != c) {
				return false;
			}
		}
		return true;
	}

	public boolean isColumnComplete(char[][] matrix, int col, char c) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][col] != c) {
				return false;
			}
		}
		return true;
	}

	public boolean isOnDiagonal(char[][] matrix, int row, int col) {
		if (row == col || (matrix.length - row) == col) {
			return true;
		}

		return false;
	}

	public boolean isDiagonalComplete(char[][] matrix, int row, int col, char c) {
		int i = 0;
		for (; i < matrix.length; i++) {
			if (matrix[i][i] != c) {
				break;
			}
		}
		if (i == matrix.length) {
			return true;
		}

		for (i = 0; i < matrix.length; i++) {
			if (matrix[i][matrix.length - i] != 0) {
				return false;
			}
		}
		return true;
	}

}
