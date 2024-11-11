package com.hs.leetcode.medium;

import java.util.Arrays;

public class SurroundedRegions {
	public void solve(char[][] board) {
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int n = board.length;
		int m = board[0].length;

		// Traverse first and last rows
		for (int j = 0; j < m; j++) {
			if (board[0][j] == 'O') {
				DFS(board, 0, j, directions);
			}
			if (board[n - 1][j] == 'O') {
				DFS(board, n - 1, j, directions);
			}
		}

		// Traverse first and last columns
		for (int i = 0; i < n; i++) {
			if (board[i][0] == 'O') {
				DFS(board, i, 0, directions);
			}
			if (board[i][m - 1] == 'O') {
				DFS(board, i, m - 1, directions);
			}
		}

		// Convert 'O' to 'X' and '#' back to 'O'
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
	}

	private void DFS(char[][] grid, int row, int col, int[][] directions) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 'O')
			return;

		grid[row][col] = '#'; // Temporarily mark 'O' as '#'
		for (int[] direction : directions) {
			DFS(grid, row + direction[0], col + direction[1], directions);
		}
	}

	public static void main(String[] args) {
		SurroundedRegions obj = new SurroundedRegions();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		obj.solve(board);
		for (char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
	}
}