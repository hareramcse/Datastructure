package com.hs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	public int[][] nearest(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int visited[][] = new int[n][m];
		int distance[][] = new int[n][m];

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0) {
					queue.add(new int[] { i, j, 0 });
					visited[i][j] = 1;
				}
			}
		}

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int row = current[0];
			int col = current[1];
			distance[row][col] = current[2];

			for (int[] direction : directions) {
				int nRow = row + direction[0];
				int nCol = col + direction[1];

				if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0) {
					visited[nRow][nCol] = 1;
					queue.add(new int[] { nRow, nCol, distance[row][col] + 1 });
				}
			}
		}

		return distance;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

		ZeroOneMatrix obj = new ZeroOneMatrix();
		int[][] ans = obj.nearest(grid);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}