package com.hs.mst;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgorithAdjacencyList {
	private int noOfVertices;
	private int[] parent;
	private boolean[] visited;
	private Edge[] edge;
	private Queue<Edge> adj[];

	@SuppressWarnings("unchecked")
	PrimsAlgorithAdjacencyList(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		parent = new int[noOfVertices];
		visited = new boolean[noOfVertices];
		edge = new Edge[noOfVertices];
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i) {
			adj[i] = new LinkedList<Edge>();
			edge[i] = new Edge();
			edge[i].weight = Integer.MAX_VALUE;
			edge[i].destination = i;
			parent[i] = -1;
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

		// mark the source vertex as visited
		visited[0] = true;

		// Set weight value to 0 so that it is extracted first out of PriorityQueue
		edge[0].weight = 0;

		Queue<Edge> pq = new PriorityQueue<>(noOfVertices);

		for (int i = 0; i < noOfVertices; i++)
			pq.add(edge[i]);

		// Loops until the queue is not empty
		while (!pq.isEmpty()) {

			// Extracts a node with min weight value
			Edge minWeightEdge = pq.poll();

			// mark the node as visited
			visited[minWeightEdge.destination] = true;

			// For all adjacent vertex of the extracted vertex
			for (Edge currentAdjEdge : adj[minWeightEdge.destination]) {

				if (visited[currentAdjEdge.destination] == false) {
					// If the weight of the adjacent vertex is more than the extracted key
					// update the weight of adjacent vertex
					// to update first remove and add the updated vertex
					if (currentAdjEdge.weight < edge[currentAdjEdge.destination].weight) {
						pq.remove(edge[currentAdjEdge.destination]);
						edge[currentAdjEdge.destination].weight = currentAdjEdge.weight;
						pq.add(edge[currentAdjEdge.destination]);
						parent[currentAdjEdge.destination] = minWeightEdge.destination;
					}
				}
			}
		}

		System.out.println("Edge \tWeight ");
		for (int i = 1; i < noOfVertices; i++)
			System.out.println(parent[i] + " " + "-" + " " + i + "\t" + edge[i].weight);
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