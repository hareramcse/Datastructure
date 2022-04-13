package com.hs.backtracking;

import java.util.Arrays;

public class NQueenProblem {
	private void solve(char[][] mat, int r) {
		// if `N` queens are placed successfully, print the solution
		if (r == mat.length) {
			printSolution(mat);
			return;
		}

		// place queen at every square in the current row `r`
		// and recur for each valid movement
		for (int i = 0; i < mat.length; i++) {
			// if no two queens threaten each other
			if (isSafe(mat, r, i)) {
				// place queen on the current square
				mat[r][i] = 'Q';

				// recur for the next row
				solve(mat, r + 1);

				// backtrack and remove the queen from the current square
				mat[r][i] = '–';
			}
		}
	}

	// Function to check if two queens threaten each other or not
	private boolean isSafe(char[][] mat, int r, int c) {
		// return false if two queens share the same column
		for (int i = 0; i < r; i++) {
			if (mat[i][c] == 'Q') {
				return false;
			}
		}

		// return false if two queens share the same `` diagonal
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (mat[i][j] == 'Q') {
				return false;
			}
		}

		// return false if two queens share the same `/` diagonal
		for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++) {
			if (mat[i][j] == 'Q') {
				return false;
			}
		}

		return true;
	}

	private void printSolution(char[][] mat) {
		for (char[] chars : mat) {
			System.out.println(Arrays.toString(chars).replaceAll(",", ""));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		NQueenProblem nqueen = new NQueenProblem();
		// `N × N` chessboard
		int N = 4;

		// `mat[][]` keeps track of the position of queens
		char[][] mat = new char[N][N];

		// initialize `mat[][]` by `-`
		for (int i = 0; i < N; i++) {
			Arrays.fill(mat[i], '–');
		}

		nqueen.solve(mat, 0);
	}
}