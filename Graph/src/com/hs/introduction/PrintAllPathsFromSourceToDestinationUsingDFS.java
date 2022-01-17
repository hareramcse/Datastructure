package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPathsFromSourceToDestinationUsingDFS {

	private int noOfVertices;
	private Queue<Integer>[] adjList;

	public PrintAllPathsFromSourceToDestinationUsingDFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adjList = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adjList[i] = new LinkedList<>();
		}
	}

	// add edge from source to destination
	private void addEdge(int source, int destination) {
		adjList[source].add(destination);
	}

	// Prints all paths from 'source' to 'destination'
	public void printAllPaths(int source, int destination) {
		boolean[] visited = new boolean[noOfVertices];
		List<Integer> pathList = new ArrayList<>();

		// add source to path[]
		pathList.add(source);

		// Call recursive utility
		printAllPathsUtil(source, destination, visited, pathList);
	}

	// A recursive function to print all paths from 'source' to 'destination'.
	// isVisited[] keeps track of vertices in current path.
	// localPathList<> stores actual vertices in the current path
	private void printAllPathsUtil(Integer source, Integer destination, boolean[] visited,
			List<Integer> localPathList) {

		if (source.equals(destination)) {
			System.out.println(localPathList);
			// if match found then no need to traverse more till depth
			return;
		}

		// Mark the current node
		visited[source] = true;

		// Recur for all the vertices adjacent to current vertex
		for (Integer i : adjList[source]) {
			if (!visited[i]) {
				// store current node in path[]
				localPathList.add(i);
				printAllPathsUtil(i, destination, visited, localPathList);

				// remove current node in path[]
				localPathList.remove(i);
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