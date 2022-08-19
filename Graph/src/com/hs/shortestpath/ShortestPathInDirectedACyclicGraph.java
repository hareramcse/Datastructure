package com.hs.shortestpath;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathInDirectedACyclicGraph {
	private int noOfVertices;
	private Queue<Edge>[] adj;

	@SuppressWarnings("unchecked")
	ShortestPathInDirectedACyclicGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);
	}

	private void shortestPath(Queue<Edge>[] adj, int source) {
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				DFS(i, visited, stack);

		int[] dist = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[source] = 0;

		// Process vertices in topological order
		while (stack.empty() == false) {
			// Get the next vertex from topological order
			int u = stack.pop();

			// Update distances of all adjacent vertices
			if (dist[u] != Integer.MAX_VALUE) {
				Iterator<Edge> it = adj[u].iterator();
				while (it.hasNext()) {
					Edge edge = it.next();
					if (dist[edge.destination] > dist[u] + edge.weight)
						dist[edge.destination] = dist[u] + edge.weight;
				}
			}
		}

		// Print the calculated shortest distances
		for (int i = 0; i < noOfVertices; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(dist[i] + " ");
		}
	}

	private void DFS(int source, boolean visited[], Stack<Integer> stack) {
		visited[source] = true;
		for (Edge node : adj[source]) {
			if (!visited[node.destination])
				DFS(node.destination, visited, stack);
		}
		stack.push(source);
	}

	public static void main(String args[]) {
		ShortestPathInDirectedACyclicGraph graph = new ShortestPathInDirectedACyclicGraph(6);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, 2);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, -1);
		graph.addEdge(4, 5, -2);

		int source = 1;
		System.out.println("Following are shortest distances from source " + source);
		graph.shortestPath(graph.adj, source);
	}
}