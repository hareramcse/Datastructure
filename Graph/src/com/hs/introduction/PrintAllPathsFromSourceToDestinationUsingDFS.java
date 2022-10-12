package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsFromSourceToDestinationUsingDFS {
	private List<List<Integer>> adjList;

	private PrintAllPathsFromSourceToDestinationUsingDFS(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	// Prints all paths from 'source' to 'destination'
	public void printAllPaths(List<List<Integer>> adjList, int source, int destination) {
		boolean[] visited = new boolean[adjList.size()];
		List<Integer> path = new ArrayList<>();

		// add source to path[]
		path.add(source);

		// Call recursive utility
		printAllPathsUtil(source, destination, visited, path, adjList);
	}

	// A recursive function to print all paths from 'source' to 'destination'.
	private void printAllPathsUtil(Integer source, Integer destination, boolean[] visited, List<Integer> path,
			List<List<Integer>> adjList) {
		if (source == destination) {
			System.out.println(path);
			// if match found then no need to traverse more till depth
			return;
		}

		// Mark the current node
		visited[source] = true;

		// Recur for all the vertices adjacent to current vertex
		for (Integer adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				// store current node in path[]
				path.add(adjNode);
				printAllPathsUtil(adjNode, destination, visited, path, adjList);

				// remove current node in path[]
				path.remove(adjNode);
			}
		}

		// Mark the current node
		visited[source] = false;
	}

	public static void main(String[] args) {
		// Create a sample graph
		PrintAllPathsFromSourceToDestinationUsingDFS graph = new PrintAllPathsFromSourceToDestinationUsingDFS(4);
		List<List<Integer>> adjList = graph.adjList;
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 0, 3);
		graph.addEdge(adjList, 2, 0);
		graph.addEdge(adjList, 2, 1);
		graph.addEdge(adjList, 1, 3);

		// arbitrary source
		int source = 2;

		// arbitrary destination
		int destination = 3;

		System.out.println("Following are all different paths from " + source + " to " + destination);
		graph.printAllPaths(adjList, source, destination);
	}
}