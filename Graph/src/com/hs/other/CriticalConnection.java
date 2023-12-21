package com.hs.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnection {
	private int timer = 1;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (List<Integer> it : connections) {
			int u = it.get(0);
			int v = it.get(1);
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		int[] visited = new int[n];
		int[] tin = new int[n];
		int[] low = new int[n];

		List<List<Integer>> bridges = new ArrayList<>();
		dfs(0, -1, visited, adjList, tin, low, bridges);
		return bridges;
	}

	private void dfs(int node, int parent, int[] visited, List<List<Integer>> adjList, int tin[], int low[],
			List<List<Integer>> bridges) {
		visited[node] = 1;
		tin[node] = low[node] = timer;
		timer++;
		for (Integer it : adjList.get(node)) {
			if (it == parent)
				continue;

			if (visited[it] == 0) {
				dfs(it, node, visited, adjList, tin, low, bridges);
				low[node] = Math.min(low[node], low[it]);
				// node --- it
				if (low[it] > tin[node]) {
					bridges.add(Arrays.asList(it, node));
				}
			} else {
				low[node] = Math.min(low[node], low[it]);
			}
		}
	}
}