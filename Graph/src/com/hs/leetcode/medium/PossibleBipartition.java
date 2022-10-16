package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {

	public boolean possibleBipartition(int N, int[][] dislikes) {
		int[] color = new int[N + 1];
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] v : dislikes) {
			adjList.get(v[0]).add(v[1]);
			adjList.get(v[1]).add(v[0]);
		}

		for (int i = 1; i <= N; i++) {
			if (color[i] == 0) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				color[i] = 1;
				while (!queue.isEmpty()) {
					int top = queue.poll();
					for (int neighbor : adjList.get(top)) {
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