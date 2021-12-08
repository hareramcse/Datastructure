package com.hs.cycle;

import java.util.LinkedList;

public class DetectCycleInDirectedGraphUsingColors {

	// A DFS based approach to find if there is a cycle
	// in a directed graph. This approach strictly follows
	// the algorithm given in CLRS book.
	static int WHITE = 0, GRAY = 1, BLACK = 2;

	// Graph class represents a directed graph using
	// adjacency list representation
	static class Graph {
		int V;
		LinkedList<Integer>[] adjList;

		// Constructor
		Graph(int ver) {
			V = ver;
			adjList = new LinkedList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new LinkedList<>();
		}
	}

	// Utility function to add an edge
	static void addEdge(Graph g, int u, int v) {
		g.adjList[u].add(v); // Add v to u's list.
	}

	// Recursive function to find if there is back edge
	// in DFS subtree tree rooted with 'u'
	static boolean DFSUtil(Graph g, int u, int[] color) {
		// GRAY : This vertex is being processed (DFS
		// for this vertex has started, but not
		// ended (or this vertex is in function
		// call stack)
		color[u] = GRAY;

		// Iterate through all adjacent vertices
		for (Integer in : g.adjList[u]) {
			// If there is
			if (color[in] == GRAY)
				return true;

			// If v is not processed and there is a back
			// edge in subtree rooted with v
			if (color[in] == WHITE && DFSUtil(g, in, color) == true)
				return true;
		}

		// Mark this vertex as processed
		color[u] = BLACK;
		return false;
	}

	// Returns true if there is a cycle in graph
	static boolean isCyclic(Graph g) {
		// Initialize color of all vertices as WHITE
		int[] color = new int[g.V];
		for (int i = 0; i < g.V; i++) {
			color[i] = WHITE;
		}

		// Do a DFS traversal beginning with all
		// vertices
		for (int i = 0; i < g.V; i++) {
			if (color[i] == WHITE) {
				if (DFSUtil(g, i, color) == true)
					return true;
			}
		}
		return false;

	}

	// Driver code to test above
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Graph g = new Graph(4);
		addEdge(g, 0, 1);
		addEdge(g, 0, 2);
		addEdge(g, 1, 2);
		addEdge(g, 2, 0);
		addEdge(g, 2, 3);
		addEdge(g, 3, 3);
		if (isCyclic(g))
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}

}