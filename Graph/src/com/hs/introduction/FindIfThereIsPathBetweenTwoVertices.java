package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class FindIfThereIsPathBetweenTwoVertices {
	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	FindIfThereIsPathBetweenTwoVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// prints BFS traversal from a given source
	private Boolean isReachable(int source, int destination) {
		// Mark all the vertices as not visited(By default set as false)
		boolean visited[] = new boolean[noOfVertices];

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue
			source = queue.poll();

			// Get all adjacent vertices of the dequeued vertex source
			// If a adjacent has not been visited, then mark it visited and enqueue it
			for (int adjNode : adj[source]) {
				// If this adjacent node is the destination node, then return true
				if (adjNode == destination)
					return true;

				// Else, continue to do BFS
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}
		return false;
	}

	// Driver method
	public static void main(String args[]) {
		FindIfThereIsPathBetweenTwoVertices graph = new FindIfThereIsPathBetweenTwoVertices(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		int source = 1;
		int destination = 3;
		if (graph.isReachable(source, destination))
			System.out.println("There is a path from " + source + " to " + destination);
		else
			System.out.println("There is no path from " + source + " to " + destination);

		source = 3;
		destination = 1;
		if (graph.isReachable(source, destination))
			System.out.println("There is a path from " + source + " to " + destination);
		else
			System.out.println("There is no path from " + source + " to " + destination);
	}
}