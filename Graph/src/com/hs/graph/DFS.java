package com.hs.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	int noOfVertices;
	LinkedList<Integer> adj[];
	boolean visited[];

	DFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		visited = new boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public static void addEdge(DFS graph, int source, int destination) {
		graph.adj[source].addFirst(destination);
		graph.adj[destination].addFirst(source);
	}

	public void printDFS(int source) {
		DFSUtil(source, visited);

		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i = 0; i < noOfVertices; ++i) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
			}
		}
	}

	public void DFSUtil(int source, boolean visited[]) {
		visited[source] = true;
		System.out.print(source);
		System.out.print(" ");
		Iterator<Integer> iterator = adj[source].listIterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			if (!visited[value]) {
				DFSUtil(value, visited);
			}
		}
	}

	public static void main(String[] args) {
		int noOfVertices = 5;
		DFS graph = new DFS(noOfVertices);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);

		graph.printDFS(0);
	}
}
