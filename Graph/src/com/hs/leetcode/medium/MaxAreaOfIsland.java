package com.hs.leetcode.medium;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, DFS(i, j, grid, directions));
				}
			}
		}
		return max;
	}

	private int DFS(int row, int col, int[][] grid, int[][] directions) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
			return 0;
		}

		grid[row][col] = 0;

		int area = 1;
		for (int[] direction : directions) {
			area += DFS(row + direction[0], col + direction[1], grid, directions);
		}
		return area;
	}

	public static void main(String[] args) {
		MaxAreaOfIsland obj = new MaxAreaOfIsland();
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int result = obj.maxAreaOfIsland(grid);
		System.out.println(result);
	}
}