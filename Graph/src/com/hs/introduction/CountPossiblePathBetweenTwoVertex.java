package com.hs.introduction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CountPossiblePathBetweenTwoVertex {

	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	CountPossiblePathBetweenTwoVertex(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	// Function to add an edge into the graph
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// Returns count of paths from 'source' to 'destination'
	private int countPaths(int source, int destination) {

		// Call the recursive method to count all paths
		int pathCount = 0;
		pathCount = countPathsUtil(source, destination, pathCount);
		return pathCount;
	}

	// A recursive method to count all paths from 'source' to 'destination'.
	private int countPathsUtil(int source, int destination, int pathCount) {

		// If current vertex is same as destination, then increment count
		if (source == destination) {
			pathCount++;
		}

		// Recur for all the vertices adjacent to this vertex
		else {
			Iterator<Integer> iterator = adj[source].iterator();
			while (iterator.hasNext()) {
				int node = iterator.next();
				pathCount = countPathsUtil(node, destination, pathCount);
			}
		}
		return pathCount;
	}

	public static void main(String args[]) {
		CountPossiblePathBetweenTwoVertex graph = new CountPossiblePathBetweenTwoVertex(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);

		int source = 0, destination = 3;
		System.out.println(graph.countPaths(source, destination));
	}

}