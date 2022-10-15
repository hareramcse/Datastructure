package com.hs.shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedACyclicGraph {

	private void addEdge(List<List<Edge>> adjList, int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjList.get(source).add(edge);
	}

	private void shortestPath(int V, int source, List<List<Edge>> adjList) {
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[V];

		// Get the vertices in topological order
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				DFS(i, visited, stack, adjList);

		int[] dist = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[source] = 0;

		// Process vertices in topological order
		while (!stack.isEmpty()) {
			// Get the next vertex from topological order
			int u = stack.pop();

			// Update distances of all adjacent vertices
			if (dist[u] != Integer.MAX_VALUE) {
				for (Edge edge : adjList.get(u)) {
					if (dist[edge.destination] > dist[u] + edge.weight)
						dist[edge.destination] = dist[u] + edge.weight;
				}
			}
		}

		// Print the calculated shortest distances
		for (int i = 0; i < V; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(dist[i] + " ");
		}
	}

	private void DFS(int source, boolean visited[], Stack<Integer> stack, List<List<Edge>> adjList) {
		visited[source] = true;
		for (Edge node : adjList.get(source)) {
			if (!visited[node.destination])
				DFS(node.destination, visited, stack, adjList);
		}
		stack.push(source);
	}

	public static void main(String args[]) {
		ShortestPathInDirectedACyclicGraph graph = new ShortestPathInDirectedACyclicGraph();
		int V = 6;
		List<List<Edge>> adjList = new ArrayList<>();
		for (int i = 0; i < V; ++i) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1, 5);
		graph.addEdge(adjList, 0, 2, 3);
		graph.addEdge(adjList, 1, 3, 6);
		graph.addEdge(adjList, 1, 2, 2);
		graph.addEdge(adjList, 2, 4, 4);
		graph.addEdge(adjList, 2, 5, 2);
		graph.addEdge(adjList, 2, 3, 7);
		graph.addEdge(adjList, 3, 4, -1);
		graph.addEdge(adjList, 4, 5, -2);

		int source = 1;
		System.out.println("Following are shortest distances from source " + source);
		graph.shortestPath(V, source, adjList);
	}
}