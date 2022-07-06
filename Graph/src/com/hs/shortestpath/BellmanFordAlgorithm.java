package com.hs.shortestpath;

import java.util.LinkedList;
import java.util.Queue;

import com.hs.mst.Edge;

public class BellmanFordAlgorithm {
	private int noOfVertices;
	private Queue<Edge> adj[];
	private int[] distance;

	@SuppressWarnings("unchecked")
	BellmanFordAlgorithm(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		distance = new int[noOfVertices];
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
			distance[i] = Integer.MAX_VALUE;
		}
	}

	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);

		edge = new Edge(destination, source, weight);
		adj[destination].add(edge);
	}

	// The function also detects negative weight cycle
	private void bellmanFord(int source) {
		distance[source] = 0;

		// Step 2: Relax all edges |V| - 1 times. A simple
		// shortest path from src to any other vertex can
		// have at-most |V| - 1 edges
		for (int i = 0; i < noOfVertices; i++) {
			for (int j = 0; j < noOfVertices; j++) {
				for (Edge edge : adj[j]) {
					int src = edge.source;
					int dest = edge.destination;
					int weight = edge.weight;
					if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest])
						distance[dest] = distance[src] + weight;
				}
			}
		}

		// Step 3: check for negative-weight cycles. The above
		// step guarantees shortest distances if graph doesn't
		// contain negative weight cycle. If we get a shorter
		// path, then there is a cycle.
		for (int j = 0; j < noOfVertices; j++) {
			for (Edge edge : adj[j]) {
				int src = edge.source;
				int dest = edge.destination;
				int weight = edge.weight;
				if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
					System.out.println("Graph contains negative weight cycle");
					return;
				}
			}
		}
		printArr(distance, noOfVertices);
	}

	// A utility function used to print the solution
	private void printArr(int dist[], int noOfVertices) {
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < noOfVertices; ++i)
			System.out.println(i + "\t\t" + dist[i]);
	}

	// Driver method to test above function
	public static void main(String[] args) {
		BellmanFordAlgorithm graph = new BellmanFordAlgorithm(8);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 4);
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, -2);
		graph.addEdge(3, 0, 3);
		graph.addEdge(3, 2, 2);
		graph.addEdge(4, 3, 1);
		graph.addEdge(4, 6, -2);
		graph.addEdge(5, 1, 3);
		graph.addEdge(5, 4, -3);
		graph.addEdge(6, 5, 2);
		graph.addEdge(6, 7, 2);
		graph.addEdge(7, 4, -2);
		graph.bellmanFord(0);
	}
}