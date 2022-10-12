package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	private List<List<Integer>> adjList;

	private TopologicalSort(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	// The function to do Topological Sort.
	public void topologicalSort(List<List<Integer>> adjList, int noOfVertices) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++)
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
		TopologicalSort graph = new TopologicalSort(6);
		List<List<Integer>> adjList = graph.adjList;
		graph.addEdge(adjList, 5, 2);
		graph.addEdge(adjList, 5, 0);
		graph.addEdge(adjList, 4, 0);
		graph.addEdge(adjList, 4, 1);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 1);

		System.out.println("Following is a Topological sort of the given graph");
		// Function Call
		graph.topologicalSort(adjList, 6);
	}
}