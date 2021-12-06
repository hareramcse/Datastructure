package com.hs.array.matrix;

public class FindUniqueElement {

	private static int R = 4, C = 4;

	// function that calculate
	// unique element
	private void unique(int mat[][], int n, int m) {
		int maximum = 0, flag = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)

				// Find maximum element
				// in a matrix
				if (maximum < mat[i][j])
					maximum = mat[i][j];

		// Take 1-D array of
		// (maximum + 1) size
		int b[] = new int[maximum + 1];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				b[mat[i][j]]++;

		// print unique element
		for (int i = 1; i <= maximum; i++)
			if (b[i] == 1)
				System.out.print(i + " ");
		flag = 1;

		if (flag == 0) {
			System.out.println("No unique element in the matrix");
		}
	}

	// Driver Code
	public static void main(String args[]) {
		FindUniqueElement matrix = new FindUniqueElement();
		int mat[][] = { { 1, 2, 3, 20 }, { 5, 6, 20, 25 }, { 1, 3, 5, 6 }, { 6, 7, 8, 15 } };

		// function that calculate
		// unique element
		matrix.unique(mat, R, C);
	}

}
