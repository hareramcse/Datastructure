package com.hs.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {
	// Function to find number of strongly connected components in the graph.
	public int kosaraju(int V, List<List<Integer>> adjList) {

		// Step1: iterate the graph and store it in finishing time sequence
		int[] visited = new int[V];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (visited[i] == 0) {
				dfs(i, visited, adjList, stack);
			}
		}

		// Step2: reverse the graph
		// transpose adjacency list to store the reversed graph
		List<List<Integer>> adjT = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjT.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < V; i++) {
			visited[i] = 0;
			for (Integer it : adjList.get(i)) {
				// i -> it
				// it -> i
				adjT.get(it).add(i);
			}
		}

		// Step 3: DFS on stored element in finishing sequence
		int scc = 0;
		while (!stack.isEmpty()) {
			int node = stack.peek();
			stack.pop();
			if (visited[node] == 0) {
				scc++;
				dfs3(node, visited, adjT);
			}
		}
		return scc;
	}

	private void dfs(int node, int[] visited, List<List<Integer>> adjList, Stack<Integer> stack) {
		visited[node] = 1;
		for (Integer it : adjList.get(node)) {
			if (visited[it] == 0) {
				dfs(it, visited, adjList, stack);
			}
		}
		stack.push(node);
	}

	private void dfs3(int node, int[] visited, List<List<Integer>> adjT) {
		visited[node] = 1;
		for (Integer it : adjT.get(node)) {
			if (visited[it] == 0) {
				dfs3(it, visited, adjT);
			}
		}
	}

	public static void main(String[] args) {
		KosarajuAlgorithm obj = new KosarajuAlgorithm();
		int n = 5;
		int[][] edges = { { 1, 0 }, { 0, 2 }, { 2, 1 }, { 0, 3 }, { 3, 4 } };
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
		}
		int ans = obj.kosaraju(n, adj);
		System.out.println("The number of strongly connected components is: " + ans);
	}
}