package com.hs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
	public boolean isBipartite(int[][] matrix) {
		int V = matrix.length;
		int color[] = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = -1;

		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (check(i, V, matrix, color) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean check(int start, int V, int[][] matrix, int color[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		color[start] = 0;
		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();

			// here matrix[u] is given as adjancy list only, its given in the question
			// so no need to convert it into adjList
			for (int it : matrix[node]) {
				// if the adjacent node is yet not colored you will give the opposite color of
				// the node
				if (color[it] == -1) {
					color[it] = 1 - color[node];
					queue.add(it);
				}
				// is the adjacent guy having the same color someone did color it on some other
				// path
				else if (color[it] == color[node]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsGraphBipartite obj = new IsGraphBipartite();
		int[][] matrix = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		boolean result = obj.isBipartite(matrix);
		System.out.println(result);
	}
}