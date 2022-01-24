package com.hs.mst;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgorithAdjacencyList {

	private int noOfVertices;
	private Queue<Edge> adj[];

	@SuppressWarnings("unchecked")
	PrimsAlgorithAdjacencyList(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	// method to add an edge between two vertices
	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);

		edge = new Edge(destination, source, weight);
		adj[destination].add(edge);
	}

	// method used to find the mst
	private void primsMST() {

		// Stores the parents of a vertex
		int[] parent = new int[noOfVertices];
		// Whether a vertex is included in mst or not
		boolean[] mst = new boolean[noOfVertices];

		Edge[] result = new Edge[noOfVertices];

		for (int i = 0; i < noOfVertices; i++)
			result[i] = new Edge();

		for (int i = 0; i < noOfVertices; i++) {
			result[i].weight = Integer.MAX_VALUE;
			result[i].destination = i;
			parent[i] = -1;
		}

		// Include the source vertex in mstset
		mst[0] = true;

		// Set weight value to 0 so that it is extracted first out of PriorityQueue
		result[0].weight = 0;

		Queue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < noOfVertices; i++)
			pq.add(result[i]);

		// Loops until the queue is not empty
		while (!pq.isEmpty()) {

			// Extracts a node with min weight value
			Edge minWeightEdge = pq.poll();

			// Include that node into mstset
			mst[minWeightEdge.destination] = true;

			// For all adjacent vertex of the extracted vertex
			for (Edge currentAdjEdge : adj[minWeightEdge.destination]) {

				if (mst[currentAdjEdge.destination] == false) {
					// If the key value of the adjacent vertex is more than the extracted key
					// update the key value of adjacent vertex
					// to update first remove and add the updated vertex
					if (currentAdjEdge.weight < result[currentAdjEdge.destination].weight) {
						pq.remove(result[currentAdjEdge.destination]);
						result[currentAdjEdge.destination].weight = currentAdjEdge.weight;
						pq.add(result[currentAdjEdge.destination]);
						parent[currentAdjEdge.destination] = minWeightEdge.destination;
					}
				}
			}
		}

		for (int i = 1; i < noOfVertices; i++)
			System.out.println(parent[i] + " " + "-" + " " + i);
	}

	public static void main(String[] args) {
		PrimsAlgorithAdjacencyList graph = new PrimsAlgorithAdjacencyList(9);

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

		// Method invoked
		graph.primsMST();
	}

}