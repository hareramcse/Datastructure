package com.hs.leetcode.medium;

public class NumberOfIceLand {

	public int numIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		boolean[][] visited = new boolean[n][m];
		int count = 0;

		int[] dRow = { -1, 1, 0, 0 };
		int[] dCol = { 0, 0, -1, 1 };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					count++;
					DFS(i, j, dRow, dCol, n, m, visited, grid);
				}
			}
		}
		return count;
	}

	private void DFS(int row, int col, int[] dRow, int[] dCol, int n, int m, boolean[][] visited, char[][] grid) {
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int nRow = row + dRow[i];
			int nCol = col + dCol[i];
			if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
				DFS(nRow, nCol, dRow, dCol, n, m, visited, grid);
			}
		}
	}
}