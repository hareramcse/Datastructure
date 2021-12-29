package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintPathsFromSourceToDestination {
	private int noOfVertices;
	private List<ArrayList<Integer>> adj;

	PrintPathsFromSourceToDestination(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new ArrayList<ArrayList<Integer>>(noOfVertices);
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
	}

	// Utility function for finding paths in graph from source to destination
	private void findpaths(List<ArrayList<Integer>> graph, int src, int dst, int noOfVertices) {

		// Create a queue which stores the paths
		Queue<List<Integer>> queue = new LinkedList<>();

		// Path vector to store the current path
		List<Integer> path = new ArrayList<>();
		path.add(src);
		queue.offer(path);

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
					List<Integer> newpath = new ArrayList<>(path);
					newpath.add(lastNode.get(i));
					queue.offer(newpath);
				}
			}
		}
	}

	// Utility function to check if current vertex is already present in path
	private boolean isNotVisited(int x, List<Integer> path) {
		int size = path.size();
		for (int i = 0; i < size; i++)
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
		PrintPathsFromSourceToDestination graph = new PrintPathsFromSourceToDestination(4);
		List<ArrayList<Integer>> adj = graph.adj;
		// Construct a graph
		adj.get(0).add(3);
		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(1).add(3);
		adj.get(2).add(0);
		adj.get(2).add(1);
		int src = 2, dst = 3;
		System.out.println("path from src " + src + " to dst " + dst + " are ");

		// Function for finding the paths
		graph.findpaths(adj, src, dst, graph.noOfVertices);
	}

}