package com.hs.medium;

import java.util.Arrays;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean firstRowZero = false;
		boolean firstColZero = false;

		// Check if the first row has any zeros
		for (int j = 0; j < cols; j++) {
			if (matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
		}

		// Check if the first column has any zeros
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}

		// Mark zeros in the first row and column
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// replace inner matrix
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}

		// Last remaining checks
		if (firstRowZero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		if (firstColZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes obj = new SetMatrixZeroes();
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		obj.setZeroes(matrix);
		for (int[] mat : matrix) {
			System.out.println(Arrays.toString(mat));
		}
	}
}