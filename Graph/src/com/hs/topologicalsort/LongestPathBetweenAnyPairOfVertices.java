package com.hs.topologicalsort;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPathBetweenAnyPairOfVertices {
	private int noOfVertices;
	private Queue<Edge> adj[];
	private int maxLen = Integer.MIN_VALUE;

	@SuppressWarnings("unchecked")
	LongestPathBetweenAnyPairOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);

		edge = new Edge(destination, source, weight);
		adj[destination].add(edge);
	}

	private int longestCable(int noOfVertices) {
		for (int i = 0; i <= noOfVertices; i++) {
			boolean[] visited = new boolean[noOfVertices + 1];
			DFS(i, 0, visited);
		}
		return maxLen;
	}

	private void DFS(int source, int prevLen, boolean[] visited) {
		visited[source] = true;
		int currLen = 0;

		// Adjacent is pair type which stores destination city and cable length
		for (Edge adjacent : adj[source]) {
			// If node or city is not visited
			if (!visited[adjacent.destination]) {
				currLen = prevLen + adjacent.weight;
				DFS(adjacent.destination, currLen, visited);
			}

			// If total cable length till now greater than previous length then update it
			if (maxLen < currLen) {
				maxLen = currLen;
			}

			// make curr_len = 0 for next adjacent
			currLen = 0;
		}
	}

	public static void main(String[] args) {
		int n = 6;
		LongestPathBetweenAnyPairOfVertices graph = new LongestPathBetweenAnyPairOfVertices(n + 1);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 4);
		graph.addEdge(2, 6, 2);
		graph.addEdge(4, 6, 6);
		graph.addEdge(5, 6, 5);
		System.out.print("Maximum length of cable = " + graph.longestCable(graph.noOfVertices));
	}
}