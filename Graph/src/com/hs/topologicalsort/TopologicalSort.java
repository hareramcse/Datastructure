package com.hs.topologicalsort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
	private int noOfVertices;
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	TopologicalSort(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	// Function to add an edge into the graph
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// The function to do Topological Sort.
	private void topologicalSort(Queue<Integer>[] adj) {
		Stack<Integer> stack = new Stack<Integer>();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[noOfVertices];

		// Call the recursive helper function to store
		// Topological Sort starting from all vertices one by one
		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				DFS(i, visited, stack);

		// Print contents of stack
		while (!stack.empty())
			System.out.print(stack.pop() + " ");
	}

	// A recursive function used by topologicalSort
	private void DFS(int source, boolean visited[], Stack<Integer> stack) {
		// Mark the current node as visited.
		visited[source] = true;

		// Recur for all the vertices adjacent to this vertex
		for(Integer vertex : adj[source]) {
			if (!visited[vertex])
				DFS(vertex, visited, stack);
		}
		// Push current vertex to stack which stores result
		stack.push(source);
	}

	public static void main(String args[]) {
		TopologicalSort graph = new TopologicalSort(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		System.out.println("Following is a Topological sort of the given graph");
		// Function Call
		graph.topologicalSort(graph.adj);
	}
}