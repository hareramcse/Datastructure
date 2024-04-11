package com.hs.hard;

import java.util.Queue;

public class MColoringProblem {
	public boolean graphColoring(Queue<Integer>[] adj, int[] color, int i, int C) {
		int n = adj.length;
		if (solve(i, adj, color, n, C) == true)
			return true;
		return false;
	}

	private boolean isSafe(int node, Queue<Integer>[] adj, int[] color, int n, int col) {
		for (int adjNode : adj[node]) {
			if (color[adjNode] == col)
				return false;
		}
		return true;
	}

	private boolean solve(int node, Queue<Integer>[] adj, int[] color, int n, int m) {
		if (node == n)
			return true;

		for (int i = 1; i <= m; i++) {
			if (isSafe(node, adj, color, n, i)) {
				color[node] = i;
				if (solve(node + 1, adj, color, n, m) == true)
					return true;
				color[node] = 0;
			}
		}
		return false;
	}
}