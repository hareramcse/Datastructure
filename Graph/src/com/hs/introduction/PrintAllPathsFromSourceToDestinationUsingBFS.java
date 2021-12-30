package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPathsFromSourceToDestinationUsingBFS {
	private int noOfVertices;
	private List<ArrayList<Integer>> adj;

	PrintAllPathsFromSourceToDestinationUsingBFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new ArrayList<ArrayList<Integer>>(noOfVertices);
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
	}

	private void addEdges(int source, int destination) {
		adj.get(source).add(destination);
	}

	// Utility function for finding paths in graph from source to destination
	private void findPaths(List<ArrayList<Integer>> graph, int src, int dst, int noOfVertices) {

		// Create a queue which stores the paths
		Queue<List<Integer>> queue = new LinkedList<>();

		// Path vector to store the current path
		List<Integer> path = new ArrayList<>();
		path.add(src);
		queue.add(path);

		while (!queue.isEmpty()) {
			path = queue.poll();
			int last = path.get(path.size() - 1);

			// If last vertex is the desired destination then print the path
			if (last == dst) {
				printPath(path);
			}

			// Traverse to all the nodes connected to current vertex and push new path to
			// queue
			List<Integer> lastNode = graph.get(last);
			for (int i = 0; i < lastNode.size(); i++) {
				if (isNotVisited(lastNode.get(i), path)) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(lastNode.get(i));
					queue.add(newPath);
				}
			}
		}
	}

	// Utility function to check if current vertex is already present in path
	private boolean isNotVisited(int x, List<Integer> path) {
		for (int i = 0; i < path.size(); i++)
			if (path.get(i) == x)
				return false;

		return true;
	}

	// utility function for printing the found path in graph
	private void printPath(List<Integer> path) {
		for (Integer v : path) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PrintAllPathsFromSourceToDestinationUsingBFS graph = new PrintAllPathsFromSourceToDestinationUsingBFS(4);
		List<ArrayList<Integer>> adj = graph.adj;

		graph.addEdges(0, 3);
		graph.addEdges(0, 1);
		graph.addEdges(0, 2);
		graph.addEdges(1, 3);
		graph.addEdges(2, 0);
		graph.addEdges(2, 1);

		int src = 2, dst = 3;
		System.out.println("path from source " + src + " to destination " + dst + " are ");

		// Function for finding the paths
		graph.findPaths(adj, src, dst, graph.noOfVertices);
	}

}