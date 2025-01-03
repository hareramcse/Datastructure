package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		// Check if the number of edges is correct for a tree
		if (edges.length != n - 1)
			return false;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		// Start DFS from node 0 and check for cycles
		if (!DFS(0, -1, adjList, visited)) {
			return false;
		}

		// Ensure all nodes are visited (i.e., graph is connected)
		for (boolean isVisited : visited) {
			if (!isVisited) {
				return false;
			}
		}
		return true;
	}

	private boolean DFS(int node, int parent, List<List<Integer>> adjList, boolean[] visited) {
		if (visited[node])// Cycle detected
			return false;

		visited[node] = true;

		for (int neighbor : adjList.get(node)) {
			if (neighbor == parent) // Ignore the edge back to the parent
				continue;

			if (!DFS(neighbor, node, adjList, visited)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		GraphValidTree obj = new GraphValidTree();
		int n = 5;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		boolean result = obj.validTree(n, edges);
		System.out.println(result);
	}
}
