package com.hs.imp;

// 695. Max Area of Island
public class MaxAreaOfIsland {
	public int maxArea(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, dfs(grid, i, j));
				}
			}
		}
		return max;
	}

	private int dfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
			return 0;
		}

		grid[i][j] = 0;
		int count = 1;
		count += dfs(grid, i + 1, j);
		count += dfs(grid, i - 1, j);
		count += dfs(grid, i, j + 1);
		count += dfs(grid, i, j - 1);
		return count;
	}

	public static void main(String[] args) {

	}
}