package com.hs.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		Set<String> seen = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char currentVal = board[i][j];

				if (currentVal == '.')
					continue;

				// Check for row, column, and sub-box uniqueness
				if (!seen.add(currentVal + " in row " + i) || !seen.add(currentVal + " in column " + j)
						|| !seen.add(currentVal + " in box " + (i / 3) + "-" + (j / 3))) {
					return false; // Duplicate found
				}
			}
		}
		return true; // If no duplicates, the board is valid
	}

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		if (isValidSudoku(board)) {
			System.out.println("The Sudoku board is valid.");
		} else {
			System.out.println("The Sudoku board is NOT valid.");
		}
	}
}
