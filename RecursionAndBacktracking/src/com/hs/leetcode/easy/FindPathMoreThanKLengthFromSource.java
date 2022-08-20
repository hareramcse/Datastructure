package com.hs.leetcode.easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FindPathMoreThanKLengthFromSource {
	private int noOfVertices;
	private Queue<Edge> adj[];

	@SuppressWarnings("unchecked")
	FindPathMoreThanKLengthFromSource(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// Utility function to an edge (u, v) of weight w
	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);
		
		edge = new Edge(destination, source, weight);
		adj[destination].add(edge);
	}

	// Returns true if graph has path more than k length
	private boolean findPathMoreThanKLength(int source, int k) {

		// Create a path array with nothing included in path
		boolean path[] = new boolean[noOfVertices];

		// Add source vertex to path
		path[source] = true;

		return pathMoreThanKLengthUtil(source, k, path);
	}

	// Prints shortest paths from src to all other vertices
	private boolean pathMoreThanKLengthUtil(int source, int k, boolean[] path) {

		// If k is 0 or negative, return true;
		if (k <= 0)
			return true;

		// Get all adjacent vertices of source vertex src and
		// recursively explore all paths from src.
		Iterator<Edge> it = adj[source].iterator();
		while (it.hasNext()) {
			Edge vertex = it.next();

			// Get adjacent vertex and weight of edge
			int v = vertex.destination;
			int w = vertex.weight;

			// If vertex v is already there in path, then
			// there is a cycle (we ignore this edge)
			if (path[v] == true)
				continue;

			// If weight of vertex is more than k, return true
			if (w >= k)
				return true;

			// Else add this vertex to path
			path[v] = true;

			// If this adjacent can provide a path longer than k, return true.
			if (pathMoreThanKLengthUtil(v, k - w, path))
				return true;

			// Backtrack
			path[v] = false;

		}
		// If no adjacent could produce longer path, return false
		return false;
	}

	public static void main(String[] args) {
		FindPathMoreThanKLengthFromSource graph = new FindPathMoreThanKLengthFromSource(9);

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);

		int src = 0;

		int k = 60;
		if (graph.findPathMoreThanKLength(src, k))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}