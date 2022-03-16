package com.hs.cycle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	DetectCycleInUndirectedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
	}

	// Function to add an edge into the graph
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	// Returns true if the graph contains a cycle, else false.
	private Boolean isCyclic() {

		// Mark all the vertices as not visited and not part of recursion stack
		boolean visited[] = new boolean[noOfVertices];

		// Call the recursive helper function to detect cycle in different DFS trees
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i]) {
				// parent of source vertex is -1
				if (isCyclicUtil(i, visited, -1)) {
					return true;
				}
			}
		}

		return false;
	}

	// function that uses visited[] and parent to detect cycle in subgraph reachable
	// from vertex v.
	private Boolean isCyclicUtil(int source, boolean visited[], int parent) {
		// Mark the current node as visited
		visited[source] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[source].iterator();
		while (it.hasNext()) {
			Integer currentAdjNode = it.next();

			// If an adjacent is not visited, then recur for that adjacent
			if (!visited[currentAdjNode]) {
				if (isCyclicUtil(currentAdjNode, visited, source)) {
					return true;
				}
			}

			// If an adjacent is visited and not parent of current vertex, then there is a cycle.
			else if (currentAdjNode != parent) {
				return true;
			}
		}
		return false;
	}

	// Driver method to test above methods
	public static void main(String args[]) {

		DetectCycleInUndirectedGraph g1 = new DetectCycleInUndirectedGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		DetectCycleInUndirectedGraph g2 = new DetectCycleInUndirectedGraph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}
}
