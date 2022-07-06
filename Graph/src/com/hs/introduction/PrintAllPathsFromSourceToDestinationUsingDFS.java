package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPathsFromSourceToDestinationUsingDFS {
	private int noOfVertices;
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public PrintAllPathsFromSourceToDestinationUsingDFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// add edge from source to destination
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// Prints all paths from 'source' to 'destination'
	public void printAllPaths(int source, int destination) {
		boolean[] visited = new boolean[noOfVertices];
		List<Integer> path = new ArrayList<>();

		// add source to path[]
		path.add(source);

		// Call recursive utility
		printAllPathsUtil(source, destination, visited, path);
	}

	// A recursive function to print all paths from 'source' to 'destination'.
	private void printAllPathsUtil(Integer source, Integer destination, boolean[] visited, List<Integer> path) {
		if (source == destination) {
			System.out.println(path);
			// if match found then no need to traverse more till depth
			return;
		}

		// Mark the current node
		visited[source] = true;

		// Recur for all the vertices adjacent to current vertex
		for (Integer adjNode : adj[source]) {
			if (!visited[adjNode]) {
				// store current node in path[]
				path.add(adjNode);
				printAllPathsUtil(adjNode, destination, visited, path);

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
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);

		// arbitrary source
		int source = 2;

		// arbitrary destination
		int destination = 3;

		System.out.println("Following are all different paths from " + source + " to " + destination);
		graph.printAllPaths(source, destination);
	}
}