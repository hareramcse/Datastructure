package com.hs.medium;

import java.util.Arrays;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		// transpose of the matrix means change row to column and vice-versa
		for (int i = 0; i < rows; i++) {
			for (int j = i + 1; j < cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// reverse every row using 2 pointer
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][cols - 1 - j];
				matrix[i][cols - 1 - j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		RotateImage obj = new RotateImage();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		obj.rotate(matrix);
		for (int[] mat : matrix) {
			System.out.println(Arrays.toString(mat));
		}
	}
}
