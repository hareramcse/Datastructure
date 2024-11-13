package com.hs.graph.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.hs.leetcode.medium.Node;

public class ShortestPathInDAG {
	public int[] longestPath(int N, int M, int[][] edges) {
		List<List<Node>> adjList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			adjList.get(u).add(new Node(v, w));
		}

		// in stack we have topologically sorted vertex.
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++)
			if (!visited[i])
				DFS(i, visited, stack, adjList);

		int[] distance = new int[N];
		for (int i = 0; i < N; i++) {
			distance[i] = (int) 1e9;
		}
		distance[0] = 0;

		// Process vertices in topological order
		while (!stack.isEmpty()) {
			int u = stack.pop();

			for (Node adjNode : adjList.get(u)) {
				int v = adjNode.destination;
				int weight = adjNode.weight;

				if (distance[u] + weight < distance[v]) {
					distance[v] = distance[u] + weight;
				}
			}
		}

		// Print the calculated longest distances
		for (int i = 0; i < N; i++) {
			if (distance[i] == 1e9)
				distance[i] = -1;
		}
		return distance;
	}

	private void DFS(int source, boolean[] visited, Stack<Integer> stack, List<List<Node>> adjList) {
		visited[source] = true;
		for (Node adjNode : adjList.get(source)) {
			if (!visited[adjNode.destination])
				DFS(adjNode.destination, visited, stack, adjList);
		}
		stack.push(source);
	}

	public static void main(String args[]) {
		ShortestPathInDAG graph = new ShortestPathInDAG();
		int N = 6, M = 7;
		int[][] edge = { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 } };
		int[] distance = graph.longestPath(N, M, edge);
		System.out.println(Arrays.toString(distance));
	}
}