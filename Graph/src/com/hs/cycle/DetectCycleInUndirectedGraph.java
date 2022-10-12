package com.hs.cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraph {
	private List<List<Integer>> adjList;

	private DetectCycleInUndirectedGraph(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
		adjList.get(destination).add(source);
	}

	public Boolean isCyclic(List<List<Integer>> adjList, int noOfVertices) {
		boolean visited[] = new boolean[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			if (!visited[i])
				// parent of source vertex is -1
				if (isCyclicUtil(adjList, i, visited, -1))
					return true;

		return false;
	}

	private Boolean isCyclicUtil(List<List<Integer>> adjList, int source, boolean visited[], int parent) {
		visited[source] = true;
		for (int adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				if (isCyclicUtil(adjList, adjNode, visited, source)) {
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
		int noOfVertices = 5;
		DetectCycleInUndirectedGraph graph = new DetectCycleInUndirectedGraph(5);
		List<List<Integer>> adjList = graph.adjList;
		graph.addEdge(adjList, 1, 0);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 2, 1);
		graph.addEdge(adjList, 0, 3);
		graph.addEdge(adjList, 3, 4);
		Boolean result = graph.isCyclic(adjList, noOfVertices);
		System.out.println(result);
	}
}