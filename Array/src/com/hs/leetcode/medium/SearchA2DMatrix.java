package com.hs.leetcode.medium;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;

		int row = matrix.length;
		int col = matrix[0].length;

		int low = 0;
		int high = (row * col) - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (matrix[mid / row][mid % row] == target) {
				return true;
			}
			if (matrix[mid / row][mid % row] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SearchA2DMatrix obj = new SearchA2DMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		boolean result = obj.searchMatrix(matrix, 5);
		System.out.println(result);
		result = obj.searchMatrix(matrix, 15);
		System.out.println(result);
	}
}
