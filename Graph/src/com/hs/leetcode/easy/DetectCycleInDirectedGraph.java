package com.hs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {

	// A utility function to add an edge in an directed graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	public boolean isCyclic(int V, List<List<Integer>> adjList) {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				boolean isCyclic = DFS(i, visited, recStack, adjList);
				if (isCyclic) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean DFS(int source, boolean[] visited, boolean[] recStack, List<List<Integer>> adjList) {
		visited[source] = true;
		recStack[source] = true;

		for (int adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				boolean isCyclic = DFS(adjNode, visited, recStack, adjList);
				if (isCyclic) {
					return true;
				}
			} else if (recStack[adjNode])
				return true;
		}

		// backtrack
		recStack[source] = false;
		return false;
	}

	public static void main(String[] args) {
		DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 4;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 1, 2);
		graph.addEdge(adjList, 2, 0);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 3);

		boolean isCyclic = graph.isCyclic(V, adjList);
		System.out.println(isCyclic);
	}
}