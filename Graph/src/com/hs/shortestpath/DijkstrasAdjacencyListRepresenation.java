package com.hs.shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstrasAdjacencyListRepresenation {

	private void addEdge(List<List<Node>> adjList, int source, int destination, int weight) {
		Node node = new Node(weight, destination);
		adjList.get(source).add(node);
		node = new Node(weight, source);
		adjList.get(destination).add(node);
	}

	// Function to find the shortest distance of all the vertices from the source
	private int[] dijkstra(int V, int source, List<List<Node>> adjList) {
		int[] dist = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		Queue<Node> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
		dist[source] = 0;
		pq.add(new Node(0, source));

		while (!pq.isEmpty()) {
			int distance = pq.peek().distance;
			int node = pq.peek().node;
			pq.remove();

			for (Node it : adjList.get(node)) {
				int edgeWeight = it.distance;
				int adjNode = it.node;
				
				if (distance + edgeWeight < dist[adjNode]) {
					dist[adjNode] = distance + edgeWeight;
					pq.add(new Node(dist[adjNode], adjNode));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		DijkstrasAdjacencyListRepresenation dij = new DijkstrasAdjacencyListRepresenation();
		List<List<Node>> adjList = new ArrayList<>();
		int V = 9;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		dij.addEdge(adjList, 0, 1, 4);
		dij.addEdge(adjList, 0, 7, 8);
		dij.addEdge(adjList, 1, 2, 8);
		dij.addEdge(adjList, 1, 7, 11);
		dij.addEdge(adjList, 2, 3, 7);
		dij.addEdge(adjList, 2, 8, 2);
		dij.addEdge(adjList, 2, 5, 4);
		dij.addEdge(adjList, 3, 4, 9);
		dij.addEdge(adjList, 3, 5, 14);
		dij.addEdge(adjList, 4, 5, 10);
		dij.addEdge(adjList, 5, 6, 2);
		dij.addEdge(adjList, 6, 7, 1);
		dij.addEdge(adjList, 6, 8, 6);
		dij.addEdge(adjList, 7, 8, 7);

		int source = 0;
		int[] distance = dij.dijkstra(V, source, adjList);

		System.out.println("Vertex " + " Distance from Source");
		for (int i = 0; i < V; i++) {
			System.out.println(i + "           " + distance[i]);
		}
	}
}