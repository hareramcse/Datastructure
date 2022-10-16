package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
	public int[][] updateMatrix(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;

		// visited and distance matrix
		int visited[][] = new int[n][m];
		int dist[][] = new int[n][m];

		// <coordinates, steps>
		Queue<Tuple> queue = new LinkedList<>();
		// traverse the matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// start BFS if cell contains 1
				if (mat[i][j] == 1) {
					queue.add(new Tuple(i, j, 0));
					visited[i][j] = 1;
				} else {
					// mark unvisted
					visited[i][j] = 0;
				}
			}
		}

		int delrow[] = { -1, 0, +1, 0 };
		int delcol[] = { 0, +1, 0, -1 };

		// n x m x 4
		// traverse till queue becomes empty
		while (!queue.isEmpty()) {
			int row = queue.peek().first;
			int col = queue.peek().second;
			int steps = queue.peek().third;
			queue.remove();
			dist[row][col] = steps;
			// for all 4 neighbours
			for (int i = 0; i < 4; i++) {
				int nrow = row + delrow[i];
				int ncol = col + delcol[i];
				// check for valid unvisited cell
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0) {
					visited[nrow][ncol] = 1;
					queue.add(new Tuple(nrow, ncol, steps + 1));
				}
			}
		}

		// return distance matrix
		return dist;
	}

	public static void main(String[] args) {
		DistanceOfNearestCellHaving1 graph = new DistanceOfNearestCellHaving1();
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };
		int[][] result = graph.updateMatrix(matrix);
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
