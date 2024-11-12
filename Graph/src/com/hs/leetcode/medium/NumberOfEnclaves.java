package com.hs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
	public int numEnclaves(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int n = grid.length;
		int m = grid[0].length;
		int[][] visited = new int[n][m];

		// traverse boundary elements
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// first row, last row, first col, last col
				if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
					// if it is a land then store it in queue
					if (grid[i][j] == 1) {
						queue.add(new int[] { i, j });
						visited[i][j] = 1;
					}
				}
			}
		}

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] direction : directions) {
				int nRow = current[0] + direction[0];
				int nCol = current[1] + direction[1];
				// check for valid coordinates and for land cell
				if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0
						&& grid[nRow][nCol] == 1) {
					queue.add(new int[] { nRow, nCol });
					visited[nRow][nCol] = 1;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// check for unvisited land cell
				if (grid[i][j] == 1 && visited[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int grid[][] = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };

		NumberOfEnclaves obj = new NumberOfEnclaves();
		int ans = obj.numEnclaves(grid);
		System.out.println(ans);
	}
}