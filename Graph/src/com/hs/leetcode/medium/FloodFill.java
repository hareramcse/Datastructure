package com.hs.leetcode.medium;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
		if (oldColor == newColor)
			return image;

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		DFS(image, sr, sc, oldColor, newColor, directions);
		return image;
	}

	private void DFS(int[][] grid, int row, int col, int oldColor, int newColor, int[][] directions) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != oldColor)
			return;

		grid[row][col] = newColor;

		for (int[] direction : directions) {
			DFS(grid, row + direction[0], col + direction[1], oldColor, newColor, directions);
		}
	}

	public static void main(String[] args) {
		FloodFill obj = new FloodFill();
		int[][] image = { { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int[][] ans = obj.floodFill(image, 1, 1, 2);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}
	}
}