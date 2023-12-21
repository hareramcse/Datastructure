package com.hs.easy;

public class Convert1DArrayInto2DArray {
	public int[][] construct2DArray(int[] original, int m, int n) {
		int len = original.length;
		int[][] ans = new int[m][n];

		for (int i = 0; i < len; i++) {
			int row = i / n;
			int col = i % n;
			ans[row][col] = original[i];
		}
		return ans;
	}
}
