package com.hs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];

		// -1 means not colored yet
		for (int i = 0; i < n; i++)
			color[i] = -1;

		for (int i = 0; i < n; i++) {
			if (color[i] == -1) {
				if (BFS(i, n, graph, color) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean BFS(int start, int n, int[][] graph, int[] color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		color[start] = 0;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			// here matrix[u] is given as adjacency list only, its given in the question
			// so no need to convert it into adjList
			for (int adjNode : graph[node]) {
				// if adjacent node is yet not colored, color it with opposite color of the node
				if (color[adjNode] == -1) {
					color[adjNode] = 1 - color[node];
					queue.add(adjNode);
				}
				// if the adjacent node having the same color
				else if (color[adjNode] == color[node]) {
					return false;
				}
			}
		}
		return true;
	}
}