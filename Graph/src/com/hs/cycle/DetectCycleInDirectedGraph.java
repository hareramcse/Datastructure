package com.hs.cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {
	private List<List<Integer>> adjList;

	private DetectCycleInDirectedGraph(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	public boolean isCyclic(List<List<Integer>> adjList, int noOfVertices) {
		boolean visited[] = new boolean[noOfVertices];
		boolean recStack[] = new boolean[noOfVertices];

		// Call the recursive helper function to detect cycle in different DFS trees
		for (int i = 0; i < noOfVertices; i++)
			if (!visited[i])
				if (isCyclicUtil(adjList, i, visited, recStack))
					return true;

		return false;
	}

	private boolean isCyclicUtil(List<List<Integer>> adjList, int source, boolean visited[], boolean recStack[]) {
		// Mark the current node as visited and part of recursion stack
		visited[source] = true;
		recStack[source] = true;

		// Recur for all the vertices adjacent to this vertex
		for (int adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				if (isCyclicUtil(adjList, adjNode, visited, recStack)) {
					return true;
				}
			}

			if (recStack[adjNode])
				return true;
		}

		// backtrack
		recStack[source] = false;
		return false;
	}

	public static void main(String[] args) {
		int noOfVertices = 4;
		DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(4);
		List<List<Integer>> adjList = graph.adjList;
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 1, 2);
		graph.addEdge(adjList, 2, 0);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 3);
		System.out.println(graph.isCyclic(adjList, noOfVertices));
	}
}