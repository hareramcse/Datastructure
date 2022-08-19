package com.hs.mst;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgorithmAdjacencyList {
	private int noOfVertices;
	private Queue<Edge>[] adj;

	@SuppressWarnings("unchecked")
	PrimsAlgorithmAdjacencyList(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];

		// initialize all vertex's weight with infinity
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	// method to create an adjancy list
	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);

		edge = new Edge(destination, source, weight);
		adj[destination].add(edge);
	}

	private void primsMST(Queue<Edge>[] adj) {
		Edge[] edge = new Edge[noOfVertices];
		boolean[] visited = new boolean[noOfVertices];
		int[] parent = new int[noOfVertices];

		// initialize all the edge weight to infinity
		for (int i = 0; i < noOfVertices; i++) {
			edge[i] = new Edge();
			edge[i].destination = i;
			edge[i].weight = Integer.MAX_VALUE;
			visited[i] = false;
			parent[i] = -1;
		}

		// Set weight of source vertex to 0 so that it is extracted first
		edge[0].weight = 0;

		// mark the source vertex as visited
		visited[0] = true;

		Queue<Edge> pq = new PriorityQueue<>(noOfVertices);
		for (int i = 0; i < noOfVertices; i++) {
			pq.add(edge[i]);
		}

		while (!pq.isEmpty()) {
			// Extracts a node with min weight value
			Edge minWeightEdge = pq.poll();

			// mark the node as visited
			visited[minWeightEdge.destination] = true;

			// update the weight and parent array
			for (Edge adjEdge : adj[minWeightEdge.destination]) {
				if (visited[adjEdge.destination] == false && adjEdge.weight < edge[adjEdge.destination].weight) {
					pq.remove(edge[adjEdge.destination]);
					edge[adjEdge.destination].weight = adjEdge.weight;
					pq.add(edge[adjEdge.destination]);
					parent[adjEdge.destination] = minWeightEdge.destination;
				}
			}
		}

		System.out.println("Edge \tWeight ");
		for (int i = 1; i < noOfVertices; i++)
			System.out.println(parent[i] + " " + "-" + " " + i + "\t" + edge[i].weight);
	}

	public static void main(String[] args) {
		PrimsAlgorithmAdjacencyList graph = new PrimsAlgorithmAdjacencyList(9);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);
		graph.primsMST(graph.adj);
	}
}