package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	BFSTraversal(int noOfVertices) {
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// Function to add an edge into the graph
	private void addEdge(Queue<Integer>[] adj, int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	// prints BFS traversal from a given source s
	private List<Integer> bfsTraversal(Queue<Integer>[] adj, int noOfVertices, int source) {
		List<Integer> ans = new ArrayList<>();
		boolean visited[] = new boolean[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i]) {
				BFS(i, visited, ans);
			}
		}
		return ans;
	}

	private void BFS(int source, boolean[] visited, List<Integer> ans) {
		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			source = queue.poll();
			ans.add(source);

			// Get all adjacent vertices of the dequeued vertex source
			// If a adjacent has not been visited, then mark it visited and enqueue it
			for (int adjNode : adj[source]) {
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}
	}

	public static void main(String args[]) {
		int noOfvertices = 4;
		BFSTraversal graph = new BFSTraversal(noOfvertices);
		Queue<Integer>[] adj = graph.adj;
		graph.addEdge(adj, 0, 1);
		graph.addEdge(adj, 0, 2);
		graph.addEdge(adj, 1, 2);
		graph.addEdge(adj, 2, 0);
		graph.addEdge(adj, 2, 3);
		graph.addEdge(adj, 3, 3);
		List<Integer> result = graph.bfsTraversal(adj, noOfvertices, 2);
		System.out.println(result);
	}
}