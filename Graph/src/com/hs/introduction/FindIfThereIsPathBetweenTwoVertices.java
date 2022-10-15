package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindIfThereIsPathBetweenTwoVertices {

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	// prints BFS traversal from a given source
	private Boolean isReachable(int V, int source, int destination, List<List<Integer>> adjList) {
		boolean visited[] = new boolean[V];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[source] = true;
		queue.add(source);

		while (!queue.isEmpty()) {
			source = queue.poll();

			for (int adjNode : adjList.get(source)) {
				if (adjNode == destination)
					return true;

				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		FindIfThereIsPathBetweenTwoVertices graph = new FindIfThereIsPathBetweenTwoVertices();
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

		int source = 1;
		int destination = 3;
		if (graph.isReachable(V, source, destination, adjList))
			System.out.println("There is a path from " + source + " to " + destination);
		else
			System.out.println("There is no path from " + source + " to " + destination);
	}
}