package com.hs.introduction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	BFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// Function to add an edge into the graph
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// prints BFS traversal from a given source s
	private void bfsTraversal(int source) {
		// Mark all the vertices as not visited(By default set as false)
		boolean visited[] = new boolean[noOfVertices];

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			source = queue.poll();
			System.out.print(source + " ");

			// Get all adjacent vertices of the dequeued vertex source
			// If a adjacent has not been visited, then mark it visited and enqueue it
			Iterator<Integer> iterator = adj[source].iterator();
			while (iterator.hasNext()) {
				int vertex = iterator.next();
				if (!visited[vertex]) {
					visited[vertex] = true;
					queue.add(vertex);
				}
			}
		}
	}

	public static void main(String args[]) {
		BFS graph = new BFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		System.out.println("Following is Breadth First Traversal starting from vertex 2");
		graph.bfsTraversal(2);
	}
}