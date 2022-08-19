package com.hs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PossibleBipartition {
	@SuppressWarnings("unchecked")
	public boolean possibleBipartition(int N, int[][] dislikes) {
		int[] color = new int[N + 1];
		Queue<Integer> adj[] = new LinkedList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new LinkedList<>();
		}

		for (int[] v : dislikes) {
			adj[v[0]].add(v[1]);
			adj[v[1]].add(v[0]);
		}

		for (int i = 1; i <= N; i++) {
			if (color[i] == 0) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				color[i] = 1;
				while (queue.size() != 0) {
					int top = queue.poll();
					for (int neighbor : adj[top]) {
						if (color[neighbor] == color[top])
							return false;
						if (color[neighbor] == 0) {
							color[neighbor] = -color[top];
							queue.add(neighbor);
						}
					}
				}
			}
		}
		return true;
	}
}