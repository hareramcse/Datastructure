package com.hs.array.matrix;

public class RotateMatrixElement {

	// A function to rotate a matrix mat[][] of size R x C.
	// Initially, m = R and n = C
	private int[][] rotatematrix(int matrix[][], int m, int n) {
		int row = 0, col = 0;
		int prev, curr;

		/*
		 * row - Starting row index m - ending row index col - starting column index n -
		 * ending column index i - iterator
		 */
		while (row < m && col < n) {

			if (row + 1 == m || col + 1 == n)
				break;

			// Store the first element of next
			// row, this element will replace
			// first element of current row
			prev = matrix[row + 1][col];

			// Move elements of first row from the remaining rows
			for (int i = col; i < n; i++) {
				curr = matrix[row][i];
				matrix[row][i] = prev;
				prev = curr;
			}
			row++;

			// Move elements of last column from the remaining columns
			for (int i = row; i < m; i++) {
				curr = matrix[i][n - 1];
				matrix[i][n - 1] = prev;
				prev = curr;
			}
			n--;

			// Move elements of last row from the remaining rows
			if (row < m) {
				for (int i = n - 1; i >= col; i--) {
					curr = matrix[m - 1][i];
					matrix[m - 1][i] = prev;
					prev = curr;
				}
			}
			m--;

			// Move elements of first column from the remaining rows
			if (col < n) {
				for (int i = m - 1; i >= row; i--) {
					curr = matrix[i][col];
					matrix[i][col] = prev;
					prev = curr;
				}
			}
			col++;
		}

		return matrix;
	}

	private void printMatrix(int matrix[][], int row, int column) {
		// Print rotated matrix
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.print("\n");
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		RotateMatrixElement array = new RotateMatrixElement();
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int row = 4;
		int column = 4;
		int[][] rotatedmatrix = array.rotatematrix(arr, row, column);
		array.printMatrix(rotatedmatrix, row, column);
	}

}