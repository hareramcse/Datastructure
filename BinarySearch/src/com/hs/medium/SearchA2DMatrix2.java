package com.hs.medium;

public class SearchA2DMatrix2 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (target == matrix[i][j])
				return true;
			else if (target < matrix[i][j])
				j--;
			else
				i++;
		}
		return false;
	}

	public static void main(String[] args) {
		SearchA2DMatrix2 obj = new SearchA2DMatrix2();
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 5;
		boolean result = obj.searchMatrix(matrix, target);
		System.out.println(result);
	}
}
