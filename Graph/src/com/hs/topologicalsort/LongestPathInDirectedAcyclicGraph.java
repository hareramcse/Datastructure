package com.hs.topologicalsort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestPathInDirectedAcyclicGraph {
	private int noOfVertices;
	private Queue<Edge> adj[];

	@SuppressWarnings("unchecked")
	LongestPathInDirectedAcyclicGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);
	}

	private void longestPath(int source) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[noOfVertices];

		// Call the recursive helper function to store Topological
		// Sort starting from all vertices one by one
		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				DFS(i, visited, stack);

		int[] distance = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			distance[i] = Integer.MIN_VALUE;
		}
		distance[source] = 0;

		// Process vertices in topological order
		while (!stack.isEmpty()) {

			// Get the next vertex from topological order
			int nextVertex = stack.pop();

			// Update distances of all adjacent vertices ;
			if (distance[nextVertex] != Integer.MIN_VALUE) {
				for (Edge node : adj[nextVertex]) {
					if (distance[node.destination] < distance[nextVertex] + node.weight) {
						distance[node.destination] = distance[nextVertex] + node.weight;
					}
				}
			}
		}

		// Print the calculated longest distances
		for (int i = 0; i < noOfVertices; i++)
			if (distance[i] == Integer.MIN_VALUE)
				System.out.print("INF ");
			else
				System.out.print(distance[i] + " ");
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
		LongestPathInDirectedAcyclicGraph graph = new LongestPathInDirectedAcyclicGraph(6);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, 2);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 5, 1);
		graph.addEdge(3, 4, -1);
		graph.addEdge(4, 5, -2);

		int source = 1;
		System.out.println("Following are longest distances from source vertex " + source);
		graph.longestPath(source);
	}
}