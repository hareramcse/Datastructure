package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
	public int minimumEffortPath(int[][] heights) {
		int n = heights.length;
		int m = heights[0].length;

		int[][] distance = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
		pq.add(new int[] { 0, 0, 0 });
		distance[0][0] = 0;

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int row = current[0];
			int col = current[1];
			int diff = current[2];

			if (row == n - 1 && col == m - 1) {
				return diff;
			}

			for (int[] direction : directions) {
				int nRow = row + direction[0];
				int nCol = col + direction[1];

				if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m) {
					int newEffort = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]), diff);
					if (newEffort < distance[nRow][nCol]) {
						distance[nRow][nCol] = newEffort;
						pq.add(new int[] { nRow, nCol, newEffort });
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		PathWithMinimumEffort obj = new PathWithMinimumEffort();
		int[][] matrix = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
		int result = obj.minimumEffortPath(matrix);
		System.out.println(result);
	}
}