package com.hs.shortestpath;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.hs.mst.Edge;

public class DijkstrasAdjacencyListRepresenation {
	private int noOfVertices;
	private Queue<Edge> adj[];

	@SuppressWarnings("unchecked")
	DijkstrasAdjacencyListRepresenation(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);

		edge = new Edge(destination, source, weight);
		adj[destination].add(edge);
	}

	// Function to find the shortest distance of all the vertices from the source
	private int[] dijkstra(Queue<Edge>[] adj, int source) {
		int[] distance = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[source] = 0;
		Queue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge());

		while (pq.size() > 0) {
			Edge minWeightEdge = pq.poll();

			for (Edge adjEdge : adj[minWeightEdge.destination]) {
				if (distance[minWeightEdge.destination] + adjEdge.weight < distance[adjEdge.destination]) {
					distance[adjEdge.destination] = distance[minWeightEdge.destination] + adjEdge.weight;
					pq.add(new Edge(adjEdge.source, adjEdge.destination, distance[adjEdge.destination]));
				}
			}
		}
		return distance;
	}

	public static void main(String[] args) {

		DijkstrasAdjacencyListRepresenation dij = new DijkstrasAdjacencyListRepresenation(9);

		dij.addEdge(0, 1, 4);
		dij.addEdge(1, 0, 4);

		dij.addEdge(0, 7, 8);
		dij.addEdge(7, 0, 8);

		dij.addEdge(1, 2, 8);
		dij.addEdge(2, 1, 8);

		dij.addEdge(1, 7, 11);
		dij.addEdge(7, 1, 11);

		dij.addEdge(2, 3, 7);
		dij.addEdge(3, 2, 7);

		dij.addEdge(2, 8, 2);
		dij.addEdge(8, 2, 2);

		dij.addEdge(2, 5, 4);
		dij.addEdge(5, 2, 4);

		dij.addEdge(3, 4, 9);
		dij.addEdge(4, 3, 9);

		dij.addEdge(3, 5, 14);
		dij.addEdge(5, 3, 14);

		dij.addEdge(4, 5, 10);
		dij.addEdge(5, 4, 10);

		dij.addEdge(5, 6, 2);
		dij.addEdge(6, 5, 2);

		dij.addEdge(6, 7, 1);
		dij.addEdge(7, 6, 1);

		dij.addEdge(6, 8, 6);
		dij.addEdge(8, 6, 6);

		dij.addEdge(7, 8, 7);
		dij.addEdge(8, 7, 7);

		int source = 0;
		int[] distance = dij.dijkstra(dij.adj, source);

		System.out.println("Vertex " + " Distance from Source");
		for (int i = 0; i < dij.noOfVertices; i++) {
			System.out.println(i + "           " + distance[i]);
		}
	}
}