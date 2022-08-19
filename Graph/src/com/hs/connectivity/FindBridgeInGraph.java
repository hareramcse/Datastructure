package com.hs.connectivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FindBridgeInGraph {

	private int NIL = -1;
	private int noOfVertices;
	private Queue<Integer> adj[];
	private int time;

	@SuppressWarnings("unchecked")
	FindBridgeInGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
		time = 0;
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	// A recursive function that finds and prints bridges using DFS traversal
	// u --> The vertex to be visited next
	// visited[] --> keeps track of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	private void bridgeUtil(int source, boolean visited[], int disc[], int low[], int parent[]) {

		// Mark the current node as visited
		visited[source] = true;

		// Initialize discovery time and low value
		disc[source] = low[source] = ++time;

		// Go through all vertices adjacent to this
		Iterator<Integer> i = adj[source].iterator();
		while (i.hasNext()) {
			int currentAdj = i.next(); // v is current adjacent of u

			// If v is not visited yet, then make it a child
			// of u in DFS tree and recur for it.
			// If v is not visited yet, then recur for it
			if (!visited[currentAdj]) {
				parent[currentAdj] = source;
				bridgeUtil(currentAdj, visited, disc, low, parent);

				// Check if the subtree rooted with v has a
				// connection to one of the ancestors of u
				low[source] = Math.min(low[source], low[currentAdj]);

				// If the lowest vertex reachable from subtree
				// under v is below u in DFS tree, then u-v is
				// a bridge
				if (low[currentAdj] > disc[source])
					System.out.println(source + " " + currentAdj);
			}

			// Update low value of u for parent function calls.
			else if (currentAdj != parent[source])
				low[source] = Math.min(low[source], disc[currentAdj]);
		}
	}

	// DFS based function to find all bridges. It uses recursive function bridgeUtil()
	private void bridge() {
		// Mark all the vertices as not visited
		boolean visited[] = new boolean[noOfVertices];
		int disc[] = new int[noOfVertices];
		int low[] = new int[noOfVertices];
		int parent[] = new int[noOfVertices];

		// Initialize parent and visited, and ap(articulation point)
		// arrays
		for (int i = 0; i < noOfVertices; i++) {
			parent[i] = NIL;
			visited[i] = false;
		}

		// Call the recursive helper function to find Bridges
		// in DFS tree rooted with vertex 'i'
		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				bridgeUtil(i, visited, disc, low, parent);
	}

	public static void main(String args[]) {
		// Create graphs given in above diagrams
		System.out.println("Bridges in first graph ");
		FindBridgeInGraph g1 = new FindBridgeInGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.bridge();
		System.out.println();

		System.out.println("Bridges in Second graph");
		FindBridgeInGraph g2 = new FindBridgeInGraph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		g2.bridge();
		System.out.println();

		System.out.println("Bridges in Third graph ");
		FindBridgeInGraph g3 = new FindBridgeInGraph(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		g3.addEdge(4, 5);
		g3.bridge();
	}
}