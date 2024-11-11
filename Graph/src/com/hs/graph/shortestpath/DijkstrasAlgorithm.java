package com.hs.graph.shortestpath;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstrasAlgorithm {

	// Function to find the shortest distance of all the vertices from the source
	public int[] dijkstra(int V, int source, List<List<List<Integer>>> adjList) {
		int[] distance = new int[V];
		for (int i = 0; i < V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		Queue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
		distance[source] = 0;
		pq.add(new Node(source, 0));

		while (!pq.isEmpty()) {
			int u = pq.peek().destination;
			int weight = pq.peek().weight;
			pq.remove();

			for (List<Integer> adjNode : adjList.get(u)) {
				int v = adjNode.get(0);
				int edgeWeight = adjNode.get(1);

				if (weight + edgeWeight < distance[v]) {
					distance[v] = weight + edgeWeight;
					pq.add(new Node(v, distance[v]));
				}
			}
		}
		return distance;
	}
}