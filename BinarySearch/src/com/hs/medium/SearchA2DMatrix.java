package com.hs.medium;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;

		int n = matrix.length;
		int m = matrix[0].length;

		int low = 0;
		int high = n * m - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == matrix[mid / m][mid % m]) {
				return true;
			} else if (target > matrix[mid / m][mid % m]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		SearchA2DMatrix obj = new SearchA2DMatrix();
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		boolean result = obj.searchMatrix(matrix, 11);
		System.out.println(result);
	}
}
