package com.hs.leetcode.medium;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int count = 0;
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					DFS(grid, i, j, directions);
				}
			}
		}
		return count;
	}

	private void DFS(char[][] grid, int row, int col, int[][] directions) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1')
			return;

		grid[row][col] = '0';
		for (int[] direction : directions) {
			DFS(grid, row + direction[0], col + direction[1], directions);
		}
	}

	public static void main(String[] args) {
		NumberOfIslands obj = new NumberOfIslands();
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		int result = obj.numIslands(grid);
		System.out.println(result);
	}
}