package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	// The function to do Topological Sort.
	public void topologicalSort(int V, List<List<Integer>> adjList) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++)
			if (!visited[i])
				DFS(i, visited, stack, adjList);

		// Print contents of stack
		while (!stack.empty())
			System.out.print(stack.pop() + " ");
	}

	private void DFS(int source, boolean visited[], Stack<Integer> stack, List<List<Integer>> adjList) {
		// Mark the current node as visited.
		visited[source] = true;

		// Recur for all the vertices adjacent to this vertex
		for (Integer vertex : adjList.get(source)) {
			if (!visited[vertex])
				DFS(vertex, visited, stack, adjList);
		}
		// Push current vertex to stack which stores result
		stack.push(source);
	}

	public static void main(String args[]) {
		TopologicalSort graph = new TopologicalSort();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 6;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 5, 2);
		graph.addEdge(adjList, 5, 0);
		graph.addEdge(adjList, 4, 0);
		graph.addEdge(adjList, 4, 1);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 1);

		System.out.println("Following is a Topological sort of the given graph");
		// Function Call
		graph.topologicalSort(V, adjList);
	}
}