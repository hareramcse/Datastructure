package com.hs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		// figure out the grid size
		int n = grid.length;
		int m = grid[0].length;
		// n x m
		Queue<Pair> queue = new LinkedList<>();
		// n x m
		int[][] visited = new int[n][m];
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// if cell contains rotten orange
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j, 0));
					// mark as visited (rotten) in visited array
					visited[i][j] = 2;
				}
				// if not rotten
				else {
					visited[i][j] = 0;
				}

				// count fresh oranges
				if (grid[i][j] == 1)
					count++;
			}
		}

		int tm = 0;
		// delta row and delta column
		int drow[] = { -1, 0, +1, 0 };
		int dcol[] = { 0, 1, 0, -1 };
		int cnt = 0;

		// until the queue becomes empty
		while (!queue.isEmpty()) {
			int row = queue.peek().row;
			int col = queue.peek().col;
			int time = queue.peek().time;
			tm = Math.max(tm, time);
			queue.remove();
			// exactly 4 neighbours
			for (int i = 0; i < 4; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];
				// check for valid coordinates and then for unvisited fresh orange
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0
						&& grid[nrow][ncol] == 1) {
					// push in queue with timer increased
					queue.add(new Pair(nrow, ncol, time + 1));
					// mark as rotten
					visited[nrow][ncol] = 2;
					cnt++;
				}
			}
		}

		// if all oranges are not rotten
		if (cnt != count)
			return -1;
		return tm;
	}
}