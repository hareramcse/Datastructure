package com.hs.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int[][] visited = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		int freshOrrange = 0;

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j, 0 });
					visited[i][j] = 2;
				} else if (grid[i][j] == 1) {
					freshOrrange++;
				}
			}
		}

		int[] dRow = { +1, 0, -1, 0 };
		int[] dCol = { 0, +1, 0, -1 };
		int time = 0;

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			time = Math.max(time, cell[2]);

			for (int i = 0; i < 4; ++i) {
				int nRow = cell[0] + dRow[i];
				int nCol = cell[1] + dCol[i];

				if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1
						&& visited[nRow][nCol] == 0) {
					queue.add(new int[] { nRow, nCol, cell[2] + 1 });
					visited[nRow][nCol] = 2;
					freshOrrange--;
				}
			}
		}

		return freshOrrange == 0 ? time : -1;
	}

	public static void main(String args[]) {
		RottingOranges obj = new RottingOranges();
		int arr[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int rotting = obj.orangesRotting(arr);
		System.out.println("Minimum Number of Minutes Required: " + rotting);
	}
}