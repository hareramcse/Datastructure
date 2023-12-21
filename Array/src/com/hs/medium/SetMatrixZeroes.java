package com.hs.medium;

import java.util.Arrays;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int col0 = 1, rows = matrix.length, cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0)
				col0 = 0;
			for (int j = 1; j < cols; j++)
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
		}

		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 1; j--)
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			if (col0 == 0)
				matrix[i][0] = 0;
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
