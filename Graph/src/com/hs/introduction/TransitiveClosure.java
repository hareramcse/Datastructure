package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class TransitiveClosure {
	private int noOfVertices;
	private Queue<Integer> adj[];
	private int transitiveClosure[][];

	@SuppressWarnings("unchecked")
	TransitiveClosure(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		transitiveClosure = new int[noOfVertices][noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	private void getTransitiveClosure() {
		for (int i = 0; i < noOfVertices; i++)
			DFSUtil(i, i); // Every vertex is reachable from self.

		for (int i = 0; i < noOfVertices; i++) {
			for (int j = 0; j < noOfVertices; j++) {
				System.out.print(transitiveClosure[i][j]);
			}
			System.out.println(" ");
		}
	}

	private void DFSUtil(int source, int destination) {
		transitiveClosure[source][destination] = 1;
		// Find all the vertices reachable through destination
		for (int currentAdjNode : adj[destination]) {
			if (transitiveClosure[source][currentAdjNode] == 0) {
				DFSUtil(source, currentAdjNode);
			}
		}
	}

	public static void main(String[] args) {
		TransitiveClosure graph = new TransitiveClosure(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.getTransitiveClosure();
	}
}