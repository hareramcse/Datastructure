package com.hs.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgorithmAdjacencyList {

	// method to add edge
	private void addEdge(List<List<Edge>> adjList, int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjList.get(source).add(edge);

		edge = new Edge(destination, source, weight);
		adjList.get(destination).add(edge);
	}

	private void primsMST(int V, List<List<Edge>> adjList) {
		Edge[] edge = new Edge[V];
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];

		// initialize all the edge weight to infinity
		for (int i = 0; i < V; i++) {
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

		Queue<Edge> pq = new PriorityQueue<>(V);
		for (int i = 0; i < V; i++) {
			pq.add(edge[i]);
		}

		while (!pq.isEmpty()) {
			// Extracts a node with min weight value
			Edge minWeightEdge = pq.poll();

			// mark the node as visited
			visited[minWeightEdge.destination] = true;

			// update the weight and parent array
			for (Edge adjEdge : adjList.get(minWeightEdge.destination)) {
				if (visited[adjEdge.destination] == false && adjEdge.weight < edge[adjEdge.destination].weight) {
					pq.remove(edge[adjEdge.destination]);
					edge[adjEdge.destination].weight = adjEdge.weight;
					pq.add(edge[adjEdge.destination]);
					parent[adjEdge.destination] = minWeightEdge.destination;
				}
			}
		}

		System.out.println("Edge \tWeight ");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " " + "-" + " " + i + "\t" + edge[i].weight);
	}

	public static void main(String[] args) {
		PrimsAlgorithmAdjacencyList graph = new PrimsAlgorithmAdjacencyList();
		List<List<Edge>> adjList = new ArrayList<>();
		int V = 9;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1, 4);
		graph.addEdge(adjList, 0, 7, 8);
		graph.addEdge(adjList, 1, 2, 8);
		graph.addEdge(adjList, 1, 7, 11);
		graph.addEdge(adjList, 2, 3, 7);
		graph.addEdge(adjList, 2, 8, 2);
		graph.addEdge(adjList, 2, 5, 4);
		graph.addEdge(adjList, 3, 4, 9);
		graph.addEdge(adjList, 3, 5, 14);
		graph.addEdge(adjList, 4, 5, 10);
		graph.addEdge(adjList, 5, 6, 2);
		graph.addEdge(adjList, 6, 7, 1);
		graph.addEdge(adjList, 6, 8, 6);
		graph.addEdge(adjList, 7, 8, 7);
		graph.primsMST(V, adjList);
	}
}