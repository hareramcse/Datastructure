package com.hs.array.matrix;

public class RotateMatrixBy90Degree {

	// Function to rotate matrix anti clock wise by 90 degrees.
	private void rotateby90(int arr[][]) {
		int n = arr.length;
		int a = 0, b = 0, c = 0, d = 0;

		// iterate over all the boundaries of the matrix
		for (int i = 0; i <= n / 2 - 1; i++) {

			// for each boundary, keep on taking 4 elements
			// (one each along the 4 edges) and swap them in anticlockwise manner
			for (int j = 0; j <= n - 2 * i - 2; j++) {
				a = arr[i + j][i];
				b = arr[n - 1 - i][i + j];
				c = arr[n - 1 - i - j][n - 1 - i];
				d = arr[i][n - 1 - i - j];

				arr[i + j][i] = d;
				arr[n - 1 - i][i + j] = a;
				arr[n - 1 - i - j][n - 1 - i] = b;
				arr[i][n - 1 - i - j] = c;
			}
		}
	}

	// Function for print matrix
	private void printMatrix(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println("");
		}
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		RotateMatrixBy90Degree matrix = new RotateMatrixBy90Degree();
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		matrix.rotateby90(arr);
		matrix.printMatrix(arr);
	}

}
