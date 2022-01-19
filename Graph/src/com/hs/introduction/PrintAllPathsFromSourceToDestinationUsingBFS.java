package com.hs.introduction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPathsFromSourceToDestinationUsingBFS {
	private int noOfVertices;
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	PrintAllPathsFromSourceToDestinationUsingBFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < 4; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	private void addEdges(int source, int destination) {
		adj[source].add(destination);
	}

	// Utility function for finding paths in graph from source to destination
	private void findPaths(int source, int destination) {

		// Create a queue which stores the paths
		Queue<List<Integer>> queue = new LinkedList<>();

		// Path vector to store the current path
		List<Integer> path = new ArrayList<>();
		path.add(source);
		queue.add(path);

		while (!queue.isEmpty()) {
			path = queue.poll();
			int last = path.get(path.size() - 1);

			// If last vertex is the desired destination then print the path
			if (last == destination) {
				System.out.println(path);
			}

			// Traverse nodes connected to current vertex and push new path to queue
			Iterator<Integer> it = adj[last].iterator();

			while (it.hasNext()) {
				Integer currentAdjNode = it.next();
				if (isNotPresentInPath(path, currentAdjNode)) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(currentAdjNode);
					queue.add(newPath);
				}
			}
		}
	}

	// Utility function to check if current vertex is already present in path
	private boolean isNotPresentInPath(List<Integer> path, int currentAdjNode) {
		for (int i = 0; i < path.size(); i++)
			if (path.get(i) == currentAdjNode)
				return false;

		return true;
	}

	public static void main(String[] args) {
		PrintAllPathsFromSourceToDestinationUsingBFS graph = new PrintAllPathsFromSourceToDestinationUsingBFS(4);
		graph.addEdges(0, 3);
		graph.addEdges(0, 1);
		graph.addEdges(0, 2);
		graph.addEdges(1, 3);
		graph.addEdges(2, 0);
		graph.addEdges(2, 1);

		int source = 2, destination = 3;
		System.out.println("path from source " + source + " to destination " + destination + " are ");

		// Function for finding the paths
		graph.findPaths(source, destination);
	}

}