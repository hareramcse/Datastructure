package com.hs.medium;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean result = dfs(0, i, j, board, word);
					if (result)
						return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(int start, int row, int col, char[][] board, String word) {
		if (start == word.length())
			return true;

		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
				|| board[row][col] != word.charAt(start))
			return false;

		board[row][col] = '*';

		// Define the possible directions to move in the maze
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int[] direction : directions) {
			boolean ans = dfs(start + 1, row + direction[0], col + direction[1], board, word);
			if (ans == true) {
				return ans; // If the word is found, return true
			}
		}
		
		// Backtrack: Restore the original character in the maze
		board[row][col] = word.charAt(start);
		return false;
	}
}