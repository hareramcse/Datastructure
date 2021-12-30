package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsFromSourceToDestinationUsingDFS {

	// No. of vertices in graph
	private int noOfVertices;

	// adjacency list
	private ArrayList<Integer>[] adjList;

	// Constructor
	public PrintAllPathsFromSourceToDestinationUsingDFS(int noOfVertices) {

		// initialise vertex count
		this.noOfVertices = noOfVertices;

		// initialise adjacency list
		initAdjList();
	}

	// utility method to initialise
	// adjacency list
	@SuppressWarnings("unchecked")
	private void initAdjList() {
		adjList = new ArrayList[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	// add edge from u to v
	private void addEdge(int source, int destination) {
		// Add v to u's list.
		adjList[source].add(destination);
	}

	// Prints all paths from
	// 's' to 'd'
	public void printAllPaths(int source, int destination) {
		boolean[] isVisited = new boolean[noOfVertices];
		ArrayList<Integer> pathList = new ArrayList<>();

		// add source to path[]
		pathList.add(source);

		// Call recursive utility
		printAllPathsUtil(source, destination, isVisited, pathList);
	}

	// A recursive function to print
	// all paths from 'u' to 'd'.
	// isVisited[] keeps track of
	// vertices in current path.
	// localPathList<> stores actual
	// vertices in the current path
	private void printAllPathsUtil(Integer source, Integer destination, boolean[] isVisited,
			List<Integer> localPathList) {

		if (source.equals(destination)) {
			System.out.println(localPathList);
			// if match found then no need to traverse more till depth
			return;
		}

		// Mark the current node
		isVisited[source] = true;

		// Recur for all the vertices
		// adjacent to current vertex
		for (Integer i : adjList[source]) {
			if (!isVisited[i]) {
				// store current node
				// in path[]
				localPathList.add(i);
				printAllPathsUtil(i, destination, isVisited, localPathList);

				// remove current node
				// in path[]
				localPathList.remove(i);
			}
		}

		// Mark the current node
		isVisited[source] = false;
	}

	// Driver program
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