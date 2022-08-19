package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class FindIfThereIsPathBetweenTwoVertices {
	private int noOfVertices;
	private Queue<Integer>[] adj;

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
	private Boolean isReachable(Queue<Integer>[] adj, int source, int destination) {
		boolean visited[] = new boolean[noOfVertices];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
			source = queue.poll();

			for (int adjNode : adj[source]) {
				if (adjNode == destination)
					return true;

				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}
		return false;
	}

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
		if (graph.isReachable(graph.adj, source, destination))
			System.out.println("There is a path from " + source + " to " + destination);
		else
			System.out.println("There is no path from " + source + " to " + destination);
	}
}