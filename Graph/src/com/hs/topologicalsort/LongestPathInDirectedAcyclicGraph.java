package com.hs.topologicalsort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestPathInDirectedAcyclicGraph {

	private int noOfVertices;
	private Queue<Pair> adj[];

	@SuppressWarnings("unchecked")
	LongestPathInDirectedAcyclicGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<Pair>();
		}
	}

	// Function to add an edge into the graph
	private void addEdge(int source, Pair destination) {
		adj[source].add(destination);
	}

	private void longestPath(int source) {
		Stack<Integer> stack = new Stack<Integer>();
		int distance[] = new int[noOfVertices];

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[noOfVertices];

		// Call the recursive helper function to store Topological
		// Sort starting from all vertices one by one
		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);

		// Initialize distances to all vertices as infinite and distance to source as 0
		for (int i = 0; i < noOfVertices; i++)
			distance[i] = Integer.MIN_VALUE;

		distance[source] = 0;

		// Process vertices in topological order
		while (stack.isEmpty() == false) {

			// Get the next vertex from topological order
			int nextVertex = stack.peek();
			stack.pop();

			// Update distances of all adjacent vertices ;
			if (distance[nextVertex] != Integer.MIN_VALUE) {
				Iterator<Pair> it = adj[nextVertex].iterator();
				while (it.hasNext()) {
					Pair node = it.next();
					if (distance[node.vertex] < distance[nextVertex] + node.weight) {
						distance[node.vertex] = distance[nextVertex] + node.weight;
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

		Iterator<Pair> it = adj[source].iterator();
		while (it.hasNext()) {
			Pair node = it.next();
			if (!visited[node.vertex])
				topologicalSortUtil(node.vertex, visited, stack);
		}
		// Push current vertex to stack which stores topological sort
		stack.push(source);
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		LongestPathInDirectedAcyclicGraph graph = new LongestPathInDirectedAcyclicGraph(6);

		graph.addEdge(0, new Pair(1, 5));
		graph.addEdge(0, new Pair(2, 3));
		graph.addEdge(1, new Pair(3, 6));
		graph.addEdge(1, new Pair(2, 2));
		graph.addEdge(2, new Pair(4, 4));
		graph.addEdge(2, new Pair(5, 2));
		graph.addEdge(2, new Pair(3, 7));
		graph.addEdge(3, new Pair(5, 1));
		graph.addEdge(3, new Pair(4, -1));
		graph.addEdge(4, new Pair(5, -2));

		int source = 1;
		System.out.println("Following are longest distances from source vertex " + source);
		graph.longestPath(source);
	}

}
