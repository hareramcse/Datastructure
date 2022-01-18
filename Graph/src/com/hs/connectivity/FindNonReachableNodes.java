package com.hs.connectivity;

import java.util.LinkedList;
import java.util.Queue;

public class FindNonReachableNodes {

	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	FindNonReachableNodes(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	private void DFSUtil(int source, boolean[] visited) {

		// Mark the current node as visited and print it
		visited[source] = true;

		// Recur for all the vertices adjacent to this vertex
		for (int i : (LinkedList<Integer>) adj[source]) {
			if (!visited[i])
				DFSUtil(i, visited);
		}
	}

	// Returns count of not reachable nodes from vertex v.
	private int countNotReach(int source) {

		// Mark all the vertices as not visited
		boolean[] visited = new boolean[noOfVertices];

		// Call the recursive helper function
		// to print DFS traversal
		DFSUtil(source, visited);

		// Return count of not visited nodes
		int count = 0;
		for (int i = 0; i < noOfVertices; i++) {
			if (visited[i] == false)
				count++;
		}
		return count;
	}

	// Driver Code
	public static void main(String[] args) {

		// Create a graph given in the above diagram
		FindNonReachableNodes g = new FindNonReachableNodes(8);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(6, 7);

		System.out.print(g.countNotReach(2));
	}

}