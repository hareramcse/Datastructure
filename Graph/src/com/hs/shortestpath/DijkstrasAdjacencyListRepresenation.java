package com.hs.shortestpath;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstrasAdjacencyListRepresenation {
	private int noOfVertices;
	private Queue<AdjListNode> adj[];
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

	private void addEdge(int source, AdjListNode adjaAdjListNode) {
		adj[source].add(adjaAdjListNode);
	}

	// Function to find the shortest distance of all the vertices from the source
	private int[] dijkstra(int source) {
		distance[source] = 0;
		PriorityQueue<AdjListNode> queue = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
		queue.add(new AdjListNode(source, 0));

		while (queue.size() > 0) {
			AdjListNode current = queue.poll();

			for (AdjListNode adjListNode : adj[current.getVertex()]) {
				if (distance[current.getVertex()] + adjListNode.getWeight() < distance[adjListNode.getVertex()]) {
					distance[adjListNode.getVertex()] = adjListNode.getWeight() + distance[current.getVertex()];
					queue.add(new AdjListNode(adjListNode.getVertex(), distance[adjListNode.getVertex()]));
				}
			}
		}
		// If you want to calculate distance from source to a particular target,
		// you can return distance[target]
		return distance;
	}

	public static void main(String[] args) {

		DijkstrasAdjacencyListRepresenation dij = new DijkstrasAdjacencyListRepresenation(9);

		int source = 0;
		dij.addEdge(0, new AdjListNode(1, 4));
		dij.addEdge(0, new AdjListNode(7, 8));
		dij.addEdge(1, new AdjListNode(2, 8));
		dij.addEdge(1, new AdjListNode(7, 11));
		dij.addEdge(1, new AdjListNode(0, 7));
		dij.addEdge(2, new AdjListNode(1, 8));
		dij.addEdge(2, new AdjListNode(3, 7));
		dij.addEdge(2, new AdjListNode(8, 2));
		dij.addEdge(2, new AdjListNode(5, 4));
		dij.addEdge(3, new AdjListNode(2, 7));
		dij.addEdge(3, new AdjListNode(4, 9));
		dij.addEdge(3, new AdjListNode(5, 14));
		dij.addEdge(4, new AdjListNode(3, 9));
		dij.addEdge(4, new AdjListNode(5, 10));
		dij.addEdge(5, new AdjListNode(4, 10));
		dij.addEdge(5, new AdjListNode(6, 2));
		dij.addEdge(6, new AdjListNode(5, 2));
		dij.addEdge(6, new AdjListNode(7, 1));
		dij.addEdge(6, new AdjListNode(8, 6));
		dij.addEdge(7, new AdjListNode(0, 8));
		dij.addEdge(7, new AdjListNode(1, 11));
		dij.addEdge(7, new AdjListNode(6, 1));
		dij.addEdge(7, new AdjListNode(8, 7));
		dij.addEdge(8, new AdjListNode(2, 2));
		dij.addEdge(8, new AdjListNode(6, 6));
		dij.addEdge(8, new AdjListNode(7, 1));

		int[] distance = dij.dijkstra(source);

		System.out.println("Vertex " + " Distance from Source");
		for (int i = 0; i < dij.noOfVertices; i++) {
			System.out.println(i + "			 " + distance[i]);
		}
	}

}