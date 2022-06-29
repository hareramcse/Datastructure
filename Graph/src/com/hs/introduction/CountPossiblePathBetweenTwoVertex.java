package com.hs.introduction;

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
		int count = 0;
		return countPathsUtil(source, destination, count);
	}

	// A recursive method to count all paths from 'source' to 'destination'.
	private int countPathsUtil(int source, int destination, int count) {

		// If current node is same as destination, then increment count
		if (source == destination) {
			count++;
		} else {
			for (int currentAdjNode : adj[source]) {
				count = countPathsUtil(currentAdjNode, destination, count);
			}
		}
		return count;
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