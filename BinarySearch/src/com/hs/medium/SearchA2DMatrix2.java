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
}
