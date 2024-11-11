package com.hs.leetcode.easy;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int[] result = { 0 };
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					DFS(grid, i, j, result, directions);
					break;
				}
			}
		}
		return result[0];
	}

	private void DFS(int[][] grid, int row, int col, int[] result, int[][] directions) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
			result[0]++;
			return;
		}

		if (grid[row][col] == -1)
			return;

		grid[row][col] = -1;

		for (int[] direction : directions) {
			DFS(grid, row + direction[0], col + direction[1], result, directions);
		}
	}

	public static void main(String[] args) {
		IslandPerimeter obj = new IslandPerimeter();
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		int result = obj.islandPerimeter(grid);
		System.out.println(result);
	}
}
