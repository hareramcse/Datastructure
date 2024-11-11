package com.hs.graph.introduction;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsFromSourceToDestinationUsingDFS {

	// A utility function to add an edge in an directed graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	// Prints all paths from 'source' to 'destination'
	public void printAllPaths(int V, int source, int destination, List<List<Integer>> adjList) {
		boolean[] visited = new boolean[V];
		List<Integer> path = new ArrayList<>();
		path.add(source);

		DFS(source, destination, visited, adjList, path);
	}

	private void DFS(Integer source, Integer destination, boolean[] visited, List<List<Integer>> adjList,
			List<Integer> path) {
		if (source == destination) {
			System.out.println(path);
			return;
		}

		visited[source] = true;

		for (Integer adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				path.add(adjNode);
				DFS(adjNode, destination, visited, adjList, path);
				path.remove(adjNode);
			}
		}

		visited[source] = false;
	}

	public static void main(String[] args) {
		PrintAllPathsFromSourceToDestinationUsingDFS graph = new PrintAllPathsFromSourceToDestinationUsingDFS();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 4;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 0, 3);
		graph.addEdge(adjList, 2, 0);
		graph.addEdge(adjList, 2, 1);
		graph.addEdge(adjList, 1, 3);

		int source = 2;
		int destination = 3;

		System.out.println("Following are all different paths from " + source + " to " + destination);
		graph.printAllPaths(V, source, destination, adjList);
	}
}