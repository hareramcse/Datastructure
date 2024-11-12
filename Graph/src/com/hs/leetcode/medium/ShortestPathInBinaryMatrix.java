package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
	public int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		// Check if the start or end cell is blocked
		if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
			return -1;
		}

		int[][] distance = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		distance[0][0] = 1; // Start distance is 1

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1 });

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }, { 1, 1 } };

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int row = current[0];
			int col = current[1];
			int dist = current[2];

			if (row == n - 1 && col == m - 1)
				return dist;

			for (int[] direction : directions) {
				int nRow = row + direction[0];
				int nCol = col + direction[1];

				if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 0
						&& dist + 1 < distance[nRow][nCol]) {
					distance[nRow][nCol] = dist + 1;
					queue.add(new int[] { nRow, nCol, dist + 1 });
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };

		int res = obj.shortestPathBinaryMatrix(grid);
		System.out.print(res);
		System.out.println();
	}
}