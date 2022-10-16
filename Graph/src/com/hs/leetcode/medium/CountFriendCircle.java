package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CountFriendCircle {

	private void addEdge(List<List<Integer>> adjList, int source, int detination) {
		adjList.get(source).add(detination);
	}

	private int countTrees(int V, List<List<Integer>> adjList) {
		boolean visited[] = new boolean[V];
		int ans = 0;

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				DFS(i, visited, adjList);
				ans++;
			}
		}
		return ans;
	}

	private void DFS(int source, boolean[] visited, List<List<Integer>> adjList) {
		visited[source] = true;
		for (Integer adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				DFS(adjNode, visited, adjList);
			}
		}
	}

	public static void main(String args[]) {
		CountFriendCircle graph = new CountFriendCircle();
		int V = 5;
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 3, 4);
		int result = graph.countTrees(V, adjList);
		System.out.println(result);
	}
}