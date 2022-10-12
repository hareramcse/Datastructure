package com.hs.leetcode.easy;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		// get initial color
		int initialColor = image[sr][sc];
		int[][] ans = image;
		// delta row and delta column for neighbours
		int delRow[] = { -1, 0, +1, 0 };
		int delCol[] = { 0, +1, 0, -1 };
		dfs(sr, sc, ans, image, newColor, delRow, delCol, initialColor);
		return ans;
	}

	private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int delRow[], int delCol[],
			int initialColor) {
		// color with new color
		ans[row][col] = newColor;
		int n = image.length;
		int m = image[0].length;
		// there are exactly 4 neighbours
		for (int i = 0; i < 4; i++) {
			int nrow = row + delRow[i];
			int ncol = col + delCol[i];
			// check for valid coordinate
			// then check for same initial color and unvisited pixel
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor
					&& ans[nrow][ncol] != newColor) {
				dfs(nrow, ncol, ans, image, newColor, delRow, delCol, initialColor);
			}
		}
	}

	public static void main(String[] args) {
		// sr = 1, sc = 1, newColor = 2
		FloodFill obj = new FloodFill();
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int[][] ans = obj.floodFill(image, 1, 1, 2);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}
	}
}
