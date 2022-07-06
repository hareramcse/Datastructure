package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodesOfBinaryTreeAtGivenLevel {
	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	CountNodesOfBinaryTreeAtGivenLevel(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// graph is non directed graph so we need to add src to dest and vice-versa
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	private int BFS(int source, int givenLevel) {
		boolean[] visited = new boolean[noOfVertices];

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		int[] level = new int[noOfVertices];
		level[source] = 0;
		while (!queue.isEmpty()) {

			// Dequeue a vertex from queue
			source = queue.poll();

			// Get all adjacent vertices of the dequeued vertex source.
			// If a adjacent has not been visited, then mark it visited and enqueue it
			for (Integer adjNode : adj[source]) {
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
					level[adjNode] = level[source] + 1;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < noOfVertices; i++)
			if (level[i] == givenLevel)
				count++;

		return count;
	}

	public static void main(String[] args) {
		CountNodesOfBinaryTreeAtGivenLevel graph = new CountNodesOfBinaryTreeAtGivenLevel(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(2, 6);
		int level = 2;
		System.out.print(graph.BFS(0, level));
	}
}