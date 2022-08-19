package com.hs.leetcode.easy;

public class IslandPerimeter {
	int count = 0;

	public int islandPerimeter(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					islandPerimeterUtil(grid, i, j);
					break;
				}
			}
		}
		return count;
	}

	private void islandPerimeterUtil(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
			count++;
			return;
		}

		if (grid[i][j] == -1)
			return;

		grid[i][j] = -1;
		islandPerimeterUtil(grid, i - 1, j);
		islandPerimeterUtil(grid, i + 1, j);
		islandPerimeterUtil(grid, i, j - 1);
		islandPerimeterUtil(grid, i, j + 1);
	}
}
