package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadders {
	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		int[] flattenedBoard = flattenBoard(board, n);

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 1, 0 }); // Starting from cell 1 with 0 moves
		boolean[] visited = new boolean[n * n + 1];
		visited[1] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int position = current[0];
			int moves = current[1];

			// Explore moves from 1 to 6
			for (int dice = 1; dice <= 6; dice++) {
				int nextPosition = position + dice;

				// If next position exceeds the board limit, skip
				if (nextPosition > n * n) {
					continue;
				}

				// Move to the destination if it's a ladder or a snake
				if (flattenedBoard[nextPosition] != -1) {
					nextPosition = flattenedBoard[nextPosition];
				}

				// Check if we reached the last cell
				if (nextPosition == n * n) {
					return moves + 1;
				}

				if (!visited[nextPosition]) {
					visited[nextPosition] = true;
					queue.offer(new int[] { nextPosition, moves + 1 });
				}
			}
		}

		return -1;
	}

	private int[] flattenBoard(int[][] board, int n) {
		int[] flattenedBoard = new int[n * n + 1];
		Arrays.fill(flattenedBoard, -1);
		int idx = 1;
		boolean leftToRight = true;

		for (int i = n - 1; i >= 0; i--) {
			if (leftToRight) {
				for (int j = 0; j < n; j++) {
					flattenedBoard[idx++] = board[i][j];
				}
			} else {
				for (int j = n - 1; j >= 0; j--) {
					flattenedBoard[idx++] = board[i][j];
				}
			}
			leftToRight = !leftToRight;
		}

		return flattenedBoard;
	}

	public static void main(String[] args) {
		SnakeAndLadders obj = new SnakeAndLadders();
		int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		int result = obj.snakesAndLadders(board);
		System.out.println(result);
	}
}
