package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindIfThereIsPathBetweenTwoVertices {
	private List<List<Integer>> adjList;

	private FindIfThereIsPathBetweenTwoVertices(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	// prints BFS traversal from a given source
	private Boolean isReachable(List<List<Integer>> adjList, int source, int destination) {
		boolean visited[] = new boolean[adjList.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
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
		FindIfThereIsPathBetweenTwoVertices graph = new FindIfThereIsPathBetweenTwoVertices(4);
		List<List<Integer>> adjList = graph.adjList;
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 1, 2);
		graph.addEdge(adjList, 2, 0);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 3);

		int source = 1;
		int destination = 3;
		if (graph.isReachable(graph.adjList, source, destination))
			System.out.println("There is a path from " + source + " to " + destination);
		else
			System.out.println("There is no path from " + source + " to " + destination);
	}
}