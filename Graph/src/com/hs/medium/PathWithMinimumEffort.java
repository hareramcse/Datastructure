package com.hs.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
	public int minimumEffortPath(int[][] heights) {
		Queue<Tuple> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

		int n = heights.length;
		int m = heights[0].length;

		int[][] distance = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		distance[0][0] = 0;
		pq.add(new Tuple(0, 0, 0));

		int[] dRow = { -1, 0, 1, 0 };
		int[] dCol = { 0, 1, 0, -1 };

		while (!pq.isEmpty()) {
			Tuple tuple = pq.poll();
			int diff = tuple.first;
			int row = tuple.second;
			int col = tuple.third;

			for (int i = 0; i < 4; i++) {
				int nRow = row + dRow[i];
				int nCol = col + dCol[i];

				if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m) {
					int newEffort = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]), diff);
					if (newEffort < distance[nRow][nCol]) {
						distance[nRow][nCol] = newEffort;
						pq.add(new Tuple(newEffort, nRow, nCol));
					}
				}
			}
		}

		// Check if end cell is reachable
		if (distance[n - 1][m - 1] == Integer.MAX_VALUE) {
			return 0;
		}
		return distance[n - 1][m - 1];
	}

	public static void main(String[] args) {
		PathWithMinimumEffort obj = new PathWithMinimumEffort();
		int[][] matrix = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
		int result = obj.minimumEffortPath(matrix);
		System.out.println(result);
	}
}