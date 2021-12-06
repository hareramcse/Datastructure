package com.hs.array.matrix;

public class RotateMatrixBy180Degree {
	/**
	 * Reverse Row at specified index in the matrix
	 * 
	 * @param data  matrix
	 * @param index row index
	 */
	private void reverseRow(int[][] data, int index) {
		int cols = data[index].length;
		for (int i = 0; i < cols / 2; i++) {
			int temp = data[index][i];
			data[index][i] = data[index][cols - i - 1];
			data[index][cols - i - 1] = temp;
		}
	}

	/**
	 * Print Matrix data
	 * 
	 * @param data matrix
	 */
	private void printMatrix(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * Rotate Matrix by 180 degrees
	 * 
	 * @param data matrix
	 */
	private void rotateMatrix180(int[][] data) {
		int rows = data.length;
		int cols = data[0].length;

		if (rows % 2 != 0) {
			// If N is odd reverse the middle row in the matrix
			reverseRow(data, data.length / 2);
		}

		// Swap the value of matrix [i][j] with [rows - i - 1][cols - j - 1] for half
		// the rows size.
		for (int i = 0; i <= (rows / 2) - 1; i++) {
			for (int j = 0; j < cols; j++) {
				int temp = data[i][j];
				data[i][j] = data[rows - i - 1][cols - j - 1];
				data[rows - i - 1][cols - j - 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		RotateMatrixBy180Degree matrix = new RotateMatrixBy180Degree();
		int[][] data = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		// Rotate Matrix
		matrix.rotateMatrix180(data);

		// Print Matrix
		matrix.printMatrix(data);
	}
}
