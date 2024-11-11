package com.hs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	// Function to find distance of nearest 0 in the grid for each cell.
	public int[][] nearest(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		// visited and distance matrix
		int visited[][] = new int[n][m];
		int distance[][] = new int[n][m];

		// <coordinates, steps>
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// start BFS if cell contains 1
				if (grid[i][j] == 0) {
					queue.add(new int[] { i, j, 0 });
					visited[i][j] = 1;
				}
			}
		}

		int[] dRow = { +1, 0, -1, 0 };
		int[] dCol = { 0, +1, 0, -1 };

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			distance[cell[0]][cell[1]] = cell[2];

			for (int i = 0; i < 4; i++) {
				int nRow = cell[0] + dRow[i];
				int nCol = cell[1] + dCol[i];
				
				// check for valid unvisited cell
				if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0) {
					visited[nRow][nCol] = 1;
					queue.add(new int[] { nRow, nCol, cell[2] + 1 });
				}
			}
		}

		// return distance matrix
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