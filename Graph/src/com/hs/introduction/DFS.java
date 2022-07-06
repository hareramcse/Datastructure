package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class DFS {
	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	DFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	// Function to add an edge into the graph
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// The function to do DFS traversal.
	private void dfsTraversl(int source) {
		// Mark all the vertices as not visited(set as false by default in java)
		boolean visited[] = new boolean[noOfVertices];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(source, visited);
	}

	// A function used by DFS
	private void DFSUtil(int source, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[source] = true;
		System.out.print(source + " ");

		// Recur for all the vertices adjacent to this vertex
		for (int adjNode : adj[source]) {
			if (!visited[adjNode])
				DFSUtil(adjNode, visited);
		}
	}

	// Driver Code
	public static void main(String args[]) {
		DFS graph = new DFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		System.out.println("Following is Depth First Traversal starting from vertex 2");
		graph.dfsTraversl(2);
	}
}