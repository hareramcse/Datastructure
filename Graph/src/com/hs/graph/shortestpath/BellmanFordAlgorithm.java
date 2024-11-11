package com.hs.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hs.graph.mst.Edge;

public class BellmanFordAlgorithm {

	private void addEdge(List<List<Edge>> adjList, int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjList.get(source).add(edge);

		edge = new Edge(destination, source, weight);
		adjList.get(destination).add(edge);
	}

	// The function also detects negative weight cycle
	private int[] bellmanFord(int V, int source, List<List<Edge>> adjList) {
		int[] distance = new int[V];
		for (int i = 0; i < V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		distance[source] = 0;
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				for (Edge edge : adjList.get(j)) {
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
		for (int j = 0; j < V; j++) {
			for (Edge edge : adjList.get(j)) {
				int src = edge.source;
				int dest = edge.destination;
				int weight = edge.weight;
				if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
					System.out.println("Graph contains negative weight cycle");
					return new int[] { -1 };
				}
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		int V = 8;
		BellmanFordAlgorithm graph = new BellmanFordAlgorithm();
		List<List<Edge>> adjList = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1, 4);
		graph.addEdge(adjList, 0, 2, 4);
		graph.addEdge(adjList, 2, 4, 4);
		graph.addEdge(adjList, 2, 5, -2);
		graph.addEdge(adjList, 3, 0, 3);
		graph.addEdge(adjList, 3, 2, 2);
		graph.addEdge(adjList, 4, 3, 1);
		graph.addEdge(adjList, 4, 6, -2);
		graph.addEdge(adjList, 5, 1, 3);
		graph.addEdge(adjList, 5, 4, -3);
		graph.addEdge(adjList, 6, 5, 2);
		graph.addEdge(adjList, 6, 7, 2);
		graph.addEdge(adjList, 7, 4, -2);
		int[] result = graph.bellmanFord(V, 0, adjList);
		System.out.println(Arrays.toString(result));
	}
}