package com.hs.shortestpath;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstrasAdjacencyListRepresenation {
	private int noOfVertices;
	private Queue<Edge> adj[];
	private int[] distance;

	@SuppressWarnings("unchecked")
	DijkstrasAdjacencyListRepresenation(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		distance = new int[noOfVertices];
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
			distance[i] = Integer.MAX_VALUE;
		}
	}

	private void addEdge(int source, int destination, int weight) {
		adj[source].add(new Edge(source, destination, weight));
	}

	// Function to find the shortest distance of all the vertices from the source
	private int[] dijkstra(int source) {
		distance[source] = 0;
		Queue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge());

		while (queue.size() > 0) {
			Edge minWeightEdge = queue.poll();

			for (Edge adjEdge : adj[minWeightEdge.destination]) {
				if (distance[minWeightEdge.destination] + adjEdge.weight < distance[adjEdge.destination]) {
					distance[adjEdge.destination] = adjEdge.weight + distance[minWeightEdge.destination];
					queue.add(new Edge(adjEdge.source, adjEdge.destination, distance[adjEdge.destination]));
				}
			}
		}
		return distance;
	}

	public static void main(String[] args) {

		DijkstrasAdjacencyListRepresenation dij = new DijkstrasAdjacencyListRepresenation(9);

		int source = 0;
		dij.addEdge(0, 1, 4);
		dij.addEdge(0, 7, 8);
		dij.addEdge(1, 2, 8);
		dij.addEdge(1, 7, 11);
		dij.addEdge(1, 0, 7);
		dij.addEdge(2, 1, 8);
		dij.addEdge(2, 3, 7);
		dij.addEdge(2, 8, 2);
		dij.addEdge(2, 5, 4);
		dij.addEdge(3, 2, 7);
		dij.addEdge(3, 4, 9);
		dij.addEdge(3, 5, 14);
		dij.addEdge(4, 3, 9);
		dij.addEdge(4, 5, 10);
		dij.addEdge(5, 4, 10);
		dij.addEdge(5, 6, 2);
		dij.addEdge(6, 5, 2);
		dij.addEdge(6, 7, 1);
		dij.addEdge(6, 8, 6);
		dij.addEdge(7, 0, 8);
		dij.addEdge(7, 1, 11);
		dij.addEdge(7, 6, 1);
		dij.addEdge(7, 8, 7);
		dij.addEdge(8, 2, 2);
		dij.addEdge(8, 6, 6);
		dij.addEdge(8, 7, 1);

		int[] distance = dij.dijkstra(source);

		System.out.println("Vertex " + " Distance from Source");
		for (int i = 0; i < dij.noOfVertices; i++) {
			System.out.println(i + "           " + distance[i]);
		}
	}

}