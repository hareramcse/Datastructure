package com.hs.cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraph {

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
		adjList.get(destination).add(source);
	}

	public Boolean isCyclic(int V, List<List<Integer>> adjList) {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				boolean isCyclic = DFS(i, visited, -1, adjList);
				if (isCyclic) {
					return true;
				}
			}
		}
		return false;
	}

	private Boolean DFS(int source, boolean visited[], int parent, List<List<Integer>> adjList) {
		visited[source] = true;
		for (int adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				boolean isCyclic = DFS(adjNode, visited, source, adjList);
				if (isCyclic) {
					return true;
				}
			}

			// adjacent is visited and not parent of current vertex, then there is a cycle.
			else if (adjNode != parent) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		DetectCycleInUndirectedGraph graph = new DetectCycleInUndirectedGraph();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 5;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 1, 0);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 2, 1);
		graph.addEdge(adjList, 0, 3);
		graph.addEdge(adjList, 3, 4);
		Boolean result = graph.isCyclic(V, adjList);
		System.out.println(result);
	}
}