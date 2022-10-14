package com.hs.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
	public int minimumEffortPath(int[][] heights) {
		Queue<Tuple> pq = new PriorityQueue<>((x, y) -> x.third - y.third);

		int n = heights.length;
		int m = heights[0].length;

		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		dist[0][0] = 0;
		pq.add(new Tuple(0, 0, 0));

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (!pq.isEmpty()) {
			Tuple tuple = pq.peek();
			pq.remove();
			int diff = tuple.first;
			int row = tuple.second;
			int col = tuple.third;

			if (row == n - 1 && col == m - 1)
				return diff;

			for (int i = 0; i < 4; i++) {
				int newr = row + dr[i];
				int newc = col + dc[i];
				if (newr >= 0 && newc >= 0 && newr < n && newc < m) {
					int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);
					if (newEffort < dist[newr][newc]) {
						dist[newr][newc] = newEffort;
						pq.add(new Tuple(newEffort, newr, newc));
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		PathWithMinimumEffort obj = new PathWithMinimumEffort();
		int[][] matrix = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
		int result = obj.minimumEffortPath(matrix);
		System.out.println(result);
	}
}