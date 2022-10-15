package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestPathInDAG {

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Edge>> adjList, int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjList.get(source).add(edge);
	}

	private void longestPath(int V, int source, List<List<Edge>> adjList) {
		// in stack we have topologically sorted vertex.
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++)
			if (!visited[i])
				DFS(i, visited, stack, adjList);

		int[] distance = new int[V];
		for (int i = 0; i < V; i++) {
			distance[i] = Integer.MIN_VALUE;
		}
		distance[source] = 0;

		// Process vertices in topological order
		while (!stack.isEmpty()) {
			// Get the next vertex from topological order
			int nextVertex = stack.pop();

			// Update distances of all adjacent vertices ;
			if (distance[nextVertex] != Integer.MIN_VALUE) {
				for (Edge node : adjList.get(nextVertex)) {
					if (distance[node.destination] < distance[nextVertex] + node.weight) {
						distance[node.destination] = distance[nextVertex] + node.weight;
					}
				}
			}
		}

		// Print the calculated longest distances
		for (int i = 0; i < V; i++)
			if (distance[i] == Integer.MIN_VALUE)
				System.out.print("INF ");
			else
				System.out.print(distance[i] + " ");
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
		LongestPathInDAG graph = new LongestPathInDAG();
		List<List<Edge>> adjList = new ArrayList<>();
		int V = 6;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1, 5);
		graph.addEdge(adjList, 0, 2, 3);
		graph.addEdge(adjList, 1, 3, 6);
		graph.addEdge(adjList, 1, 2, 2);
		graph.addEdge(adjList, 2, 4, 4);
		graph.addEdge(adjList, 2, 5, 2);
		graph.addEdge(adjList, 2, 3, 7);
		graph.addEdge(adjList, 3, 5, 1);
		graph.addEdge(adjList, 3, 4, -1);
		graph.addEdge(adjList, 4, 5, -2);

		int source = 1;
		System.out.println("Following are longest distances from source vertex " + source);
		graph.longestPath(V, source, adjList);
	}
}