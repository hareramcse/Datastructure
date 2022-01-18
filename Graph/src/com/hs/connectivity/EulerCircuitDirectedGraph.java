package com.hs.connectivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class EulerCircuitDirectedGraph {
	private int noOfVertices;
	private Queue<Integer> adj[];
	private int in[]; // maintaining in degree

	@SuppressWarnings("unchecked")
	EulerCircuitDirectedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		in = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		in[destination]++;
	}

	// A recursive function to print DFS starting from v
	private void DFSUtil(int source, boolean visited[]) {
		// Mark the current node as visited
		visited[source] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[source].iterator();
		while (it.hasNext()) {
			int currentAdj = it.next();
			if (!visited[currentAdj])
				DFSUtil(currentAdj, visited);
		}
	}

	// Function that returns reverse (or transpose) of this graph
	private EulerCircuitDirectedGraph getTranspose() {
		EulerCircuitDirectedGraph graph = new EulerCircuitDirectedGraph(noOfVertices);
		for (int i = 0; i < noOfVertices; i++) {
			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> it = adj[i].iterator();
			while (it.hasNext()) {
				graph.adj[it.next()].add(i);
				(graph.in[i])++;
			}
		}
		return graph;
	}

	// The main function that returns true if graph is strongly connected
	private Boolean isSC() {
		// Step 1: Mark all the vertices as not visited (For first DFS)
		boolean visited[] = new boolean[noOfVertices];

		// Step 2: Do DFS traversal starting from the first vertex.
		DFSUtil(0, visited);

		// If DFS traversal doesn't visit all vertices, then return false.
		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				return false;

		// Step 3: Create a reversed graph
		EulerCircuitDirectedGraph graph = getTranspose();

		// Step 4: Mark all the vertices as not visited (For second DFS)
		for (int i = 0; i < noOfVertices; i++)
			visited[i] = false;

		// Step 5: Do DFS for reversed graph starting from first vertex.
		// Starting Vertex must be same starting point of first DFS
		graph.DFSUtil(0, visited);

		// If all vertices are not visited in second DFS, then
		// return false
		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				return false;

		return true;
	}

	/*
	 * This function returns true if the directed graph has a eulerian cycle,
	 * otherwise returns false
	 */
	private Boolean isEulerianCycle() {
		// Check if all non-zero degree vertices are connected
		if (isSC() == false)
			return false;

		// Check if in degree and out degree of every vertex is same
		for (int i = 0; i < noOfVertices; i++)
			if (adj[i].size() != in[i])
				return false;

		return true;
	}

	public static void main(String[] args) throws java.lang.Exception {
		EulerCircuitDirectedGraph g = new EulerCircuitDirectedGraph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 0);

		if (g.isEulerianCycle())
			System.out.println("Given directed graph is eulerian ");
		else
			System.out.println("Given directed graph is NOT eulerian ");
	}

}