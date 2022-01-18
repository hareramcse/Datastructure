package com.hs.connectivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPathFromSourceToDestination {

	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	PrintAllPathFromSourceToDestination(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// Prints all paths from 'source' to 'destination'
	public void printAllPaths(int source, int destination) {
		boolean[] isVisited = new boolean[noOfVertices];
		List<Integer> pathList = new ArrayList<>();

		// add source to path[]
		pathList.add(source);

		// Call recursive utility
		printAllPathsUtil(source, destination, isVisited, pathList);
	}

	// A recursive function to print all paths from 'u' to 'd'.
	// isVisited[] keeps track of vertices in current path.
	// localPathList<> stores actual vertices in the current path
	private void printAllPathsUtil(Integer source, Integer destination, boolean[] isVisited,
			List<Integer> localPathList) {

		if (source.equals(destination)) {
			System.out.println(localPathList);
			// if match found then no need to traverse more till depth
			return;
		}

		// Mark the current node
		isVisited[source] = true;

		// Recur for all the vertices adjacent to current vertex
		for (Integer currentAdj : adj[source]) {
			if (!isVisited[currentAdj]) {
				// store current node in path[]
				localPathList.add(currentAdj);
				printAllPathsUtil(currentAdj, destination, isVisited, localPathList);

				// remove current node in path[]
				localPathList.remove(currentAdj);
			}
		}

		// Mark the current node
		isVisited[source] = false;
	}

	// Driver program
	public static void main(String[] args) {
		// Create a sample graph
		PrintAllPathFromSourceToDestination graph = new PrintAllPathFromSourceToDestination(4);
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