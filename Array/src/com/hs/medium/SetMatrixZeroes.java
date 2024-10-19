package com.hs.medium;

import java.util.Arrays;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		boolean firstRow = false;
		boolean firstCol = false;

		// set markers in first row and first col
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						firstRow = true;
					if (j == 0)
						firstCol = true;

					matrix[0][j] = 0;
					matrix[i][0] = 0;
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
		if (firstRow) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		if (firstCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes obj = new SetMatrixZeroes();
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		obj.setZeroes(matrix);
		for (int[] mat : matrix) {
			System.out.println(Arrays.toString(mat));
		}
	}
}