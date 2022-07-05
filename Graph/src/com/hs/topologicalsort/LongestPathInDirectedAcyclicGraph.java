package com.hs.topologicalsort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestPathInDirectedAcyclicGraph {
	private int noOfVertices;
	private int[] distance;
	private Queue<Edge> adj[];

	@SuppressWarnings("unchecked")
	LongestPathInDirectedAcyclicGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		distance = new int[noOfVertices];
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
			distance[i] = Integer.MIN_VALUE;
		}
	}

	// Function to add an edge into the graph
	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);
	}

	private void longestPath(int source) {
		Stack<Integer> stack = new Stack<Integer>();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[noOfVertices];

		// Call the recursive helper function to store Topological
		// Sort starting from all vertices one by one
		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);

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

	// A recursive function used by longestPath.
	private void topologicalSortUtil(int source, boolean visited[], Stack<Integer> stack) {
		// Mark the current node as visited
		visited[source] = true;

		Iterator<Edge> it = adj[source].iterator();
		while (it.hasNext()) {
			Edge node = it.next();
			if (!visited[node.destination])
				topologicalSortUtil(node.destination, visited, stack);
		}
		// Push current vertex to stack which stores topological sort
		stack.push(source);
	}

	// Driver program to test above functions
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
