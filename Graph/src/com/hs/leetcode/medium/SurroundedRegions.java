package com.hs.leetcode.medium;

public class SurroundedRegions {
	public void solve(char[][] board) {
		int n = board.length;
		int m = board[0].length;

		int dRow[] = { -1, 0, +1, 0 };
		int dCol[] = { 0, 1, 0, -1 };

		int visited[][] = new int[n][m];

		// traverse first row and last row
		for (int j = 0; j < m; j++) {
			// check for unvisited Os in the boundary first row
			if (visited[0][j] == 0 && board[0][j] == 'O') {
				dfs(0, j, dRow, dCol, n, m, visited, board);
			}

			// last row
			if (visited[n - 1][j] == 0 && board[n - 1][j] == 'O') {
				dfs(n - 1, j, dRow, dCol, n, m, visited, board);
			}
		}

		for (int i = 0; i < n; i++) {
			// check for unvisited Os in the boundary first column
			if (visited[i][0] == 0 && board[i][0] == 'O') {
				dfs(i, 0, dRow, dCol, n, m, visited, board);
			}

			// last column
			if (visited[i][m - 1] == 0 && board[i][m - 1] == 'O') {
				dfs(i, m - 1, dRow, dCol, n, m, visited, board);
			}
		}

		// if unvisited O then convert to X
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
		return;
	}

	private void dfs(int row, int col, int dRow[], int dCol[], int n, int m, int[][] visited, char[][] mat) {
		visited[row][col] = 1;

		// check for top, right, bottom, left
		for (int i = 0; i < 4; i++) {
			int nrow = row + dRow[i];
			int ncol = col + dCol[i];
			// check for valid coordinates and unvisited Os
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
				dfs(nrow, ncol, dRow, dCol, n, m, visited, mat);
			}
		}
	}
}
