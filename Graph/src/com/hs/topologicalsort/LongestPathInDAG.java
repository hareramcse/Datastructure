package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestPathInDAG {
	private List<List<Edge>> adjList;

	private LongestPathInDAG(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Edge>> adjList, int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjList.get(source).add(edge);
	}

	private void longestPath(List<List<Edge>> adjList, int noOfVertices, int source) {
		// in stack we have topologically sorted vertex.
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++)
			if (!visited[i])
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
				for (Edge node : adjList.get(nextVertex)) {
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
		for (Edge node : adjList.get(source)) {
			if (!visited[node.destination])
				DFS(node.destination, visited, stack);
		}
		stack.push(source);
	}

	public static void main(String args[]) {
		int noOfVertices = 6;
		LongestPathInDAG graph = new LongestPathInDAG(6);
		List<List<Edge>> adjList = graph.adjList;
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
		graph.longestPath(adjList, noOfVertices, source);
	}
}