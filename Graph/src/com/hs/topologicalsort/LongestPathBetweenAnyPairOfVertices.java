package com.hs.topologicalsort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LongestPathBetweenAnyPairOfVertices {

	// maximum length of cable among the connected cities
	private int max_len = Integer.MIN_VALUE;
	private int noOfVertices;
	private Queue<Pair> adj[];

	@SuppressWarnings("unchecked")
	LongestPathBetweenAnyPairOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<Pair>();
		}
	}

	// Function to add an edge into the graph
	private void addEdge(int source, Pair destination) {
		adj[source].add(destination);
	}

	// n is number of cities or nodes in graph cable_lines
	// is total cable_lines among the cities or edges in graph
	private int longestCable(int noOfVertices) {
		// call DFS for each city to find maximum length of cable
		for (int i = 1; i <= noOfVertices; i++) {
			// initialize visited array with 0
			boolean[] visited = new boolean[noOfVertices + 1];

			// Call DFS for src vertex i
			DFS(i, 0, visited);
		}

		return max_len;
	}

	private void DFS(int src, int prev_len, boolean[] visited) {

		// Mark the src node visited
		visited[src] = true;

		// curr_len is for length of cable from src city to its adjacent city
		int curr_len = 0;

		// Adjacent is pair type which stores destination city and cable length

		Iterator<Pair> it = adj[src].iterator();
		while (it.hasNext()) {
			Pair adjacent = it.next();
			// If node or city is not visited
			if (!visited[adjacent.vertex]) {
				// Total length of cable from src city to its adjacent
				curr_len = prev_len + adjacent.weight;

				// Call DFS for adjacent city
				DFS(adjacent.vertex, curr_len, visited);
			}

			// If total cable length till now greater than previous length then update it
			if (max_len < curr_len) {
				max_len = curr_len;
			}

			// make curr_len = 0 for next adjacent
			curr_len = 0;
		}

	}

	public static void main(String[] args) {
		// n is number of cities
		LongestPathBetweenAnyPairOfVertices graph = new LongestPathBetweenAnyPairOfVertices(7);

		// create undirected graph first edge
		graph.addEdge(1, new Pair(2, 3));
		graph.addEdge(2, new Pair(1, 3));

		// second edge
		graph.addEdge(2, new Pair(3, 4));
		graph.addEdge(3, new Pair(2, 4));

		// third edge
		graph.addEdge(2, new Pair(6, 2));
		graph.addEdge(6, new Pair(2, 2));

		// fourth edge
		graph.addEdge(4, new Pair(6, 6));
		graph.addEdge(6, new Pair(4, 6));

		// fifth edge
		graph.addEdge(5, new Pair(6, 5));
		graph.addEdge(6, new Pair(5, 5));

		System.out.print("Maximum length of cable = " + graph.longestCable(6));
	}

}