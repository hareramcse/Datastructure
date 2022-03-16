package com.hs.topologicalsort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LongestPathBetweenAnyPairOfVertices {
	// maximum length of cable among the connected cities
	private int maxLen = Integer.MIN_VALUE;
	private int noOfVertices;
	private Queue<Edge> adj[];

	@SuppressWarnings("unchecked")
	LongestPathBetweenAnyPairOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	// Function to add an edge into the graph
	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);

		edge = new Edge(destination, source, weight);
		adj[destination].add(edge);
	}

	// n is number of cities or nodes in graph cable_lines
	// is total cable_lines among the cities or edges in graph
	private int longestCable(int noOfVertices) {
		// call DFS for each city to find maximum length of cable
		for (int i = 0; i <= noOfVertices; i++) {
			// initialize visited array with 0
			boolean[] visited = new boolean[noOfVertices + 1];

			// Call DFS for src vertex i
			DFS(i, 0, visited);
		}

		return maxLen;
	}

	private void DFS(int source, int prevLen, boolean[] visited) {

		// Mark the src node visited
		visited[source] = true;

		// curr_len is for length of cable from src city to its adjacent city
		int currLen = 0;

		// Adjacent is pair type which stores destination city and cable length
		Iterator<Edge> it = adj[source].iterator();
		while (it.hasNext()) {
			Edge adjacent = it.next();
			// If node or city is not visited
			if (!visited[adjacent.destination]) {
				// Total length of cable from src city to its adjacent
				currLen = prevLen + adjacent.weight;

				// Call DFS for adjacent city
				DFS(adjacent.destination, currLen, visited);
			}

			// If total cable length till now greater than previous length then update it
			if (maxLen < currLen) {
				maxLen = currLen;
			}

			// make curr_len = 0 for next adjacent
			currLen = 0;
		}

	}

	public static void main(String[] args) {
		int n = 6;
		LongestPathBetweenAnyPairOfVertices graph = new LongestPathBetweenAnyPairOfVertices(n+1);

		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 4);
		graph.addEdge(2, 6, 2);
		graph.addEdge(4, 6, 6);
		graph.addEdge(5, 6, 5);

		System.out.print("Maximum length of cable = " + graph.longestCable(n));
	}

}