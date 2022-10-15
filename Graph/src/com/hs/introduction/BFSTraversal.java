package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
		adjList.get(destination).add(source);
	}

	// prints BFS traversal from a given source s
	private List<Integer> bfsTraversal(int noOfVertices, int source, List<List<Integer>> adjList) {
		List<Integer> ans = new ArrayList<>();
		boolean[] visited = new boolean[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i]) {
				BFS(i, visited, adjList, ans);
			}
		}
		return ans;
	}

	private void BFS(int source, boolean[] visited, List<List<Integer>> adjList, List<Integer> ans) {
		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			source = queue.poll();
			ans.add(source);

			// Get all adjacent vertices of the dequeued vertex source
			// If a adjacent has not been visited, then mark it visited and enqueue it
			for (int adjNode : adjList.get(source)) {
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}
	}

	public static void main(String args[]) {
		BFSTraversal graph = new BFSTraversal();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 4;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 1, 2);
		graph.addEdge(adjList, 2, 0);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 3);
		List<Integer> result = graph.bfsTraversal(V, 2, adjList);
		System.out.println(result);
	}
}