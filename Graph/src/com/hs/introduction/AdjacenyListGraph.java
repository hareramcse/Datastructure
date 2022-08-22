package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

class AdjacenyListGraph {
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	private AdjacenyListGraph(int noOfVertices) {
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(Queue<Integer>[] adj, int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	// A utility function to print the adjacency list representation of graph
	private void printGraph(Queue<Integer>[] adj) {
		for (Queue<Integer> queue : adj) {
			System.out.println("Adjacency list of vertex " + queue.peek());
			System.out.print("head");
			for (Integer adjNode : queue) {
				System.out.print(" -> " + adjNode);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AdjacenyListGraph graph = new AdjacenyListGraph(5);
		Queue<Integer>[] adj = graph.adj;
		graph.addEdge(adj, 0, 1);
		graph.addEdge(adj, 0, 4);
		graph.addEdge(adj, 1, 2);
		graph.addEdge(adj, 1, 3);
		graph.addEdge(adj, 1, 4);
		graph.addEdge(adj, 2, 3);
		graph.addEdge(adj, 3, 4);
		graph.printGraph(adj);
	}
}