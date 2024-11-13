package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {
	public int countComponents(int n, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		boolean[] visited = new boolean[n];

		int connectedComponents = 0;

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				DFS(i, adjList, visited);
				connectedComponents++;
			}
		}

		return connectedComponents;
	}

	private void DFS(int source, List<List<Integer>> adjList, boolean[] visited) {
		visited[source] = true;

		for (int adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				DFS(adjNode, adjList, visited);
			}
		}
	}

	public static void main(String[] args) {
		NumberOfConnectedComponents obj = new NumberOfConnectedComponents();
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		int result = obj.countComponents(n, edges);
		System.out.println(result);
	}
}