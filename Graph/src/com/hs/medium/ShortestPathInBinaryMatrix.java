package com.hs.medium;

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

		// Initialize distances array with maximum values
		int distance[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		distance[0][0] = 1; // Start distance is 1

		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(1, 0, 0)); // Add start tuple to the queue with distance 1

		int dRow[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int dCol[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

		while (!queue.isEmpty()) {
			Tuple tupple = queue.poll();
			int dist = tupple.first;
			int row = tupple.second;
			int col = tupple.third;

			// Iterate through 8 possible directions
			for (int i = 0; i < 8; i++) {
				int nRow = row + dRow[i];
				int nCol = col + dCol[i];

				// Check bounds and if cell is open and if new distance is smaller
				if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 0
						&& dist + 1 < distance[nRow][nCol]) {

					distance[nRow][nCol] = dist + 1; // Update distance
					queue.add(new Tuple(dist + 1, nRow, nCol)); // Add to queue
				}
			}
		}

		// Check if end cell is reachable
		if (distance[n - 1][m - 1] == Integer.MAX_VALUE) {
			return -1;
		}
		return distance[n - 1][m - 1]; // Return shortest path to end cell
	}

	public static void main(String[] args) {
		ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };

		int res = obj.shortestPathBinaryMatrix(grid);
		System.out.print(res);
		System.out.println();
	}
}