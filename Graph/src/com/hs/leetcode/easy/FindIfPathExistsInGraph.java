package com.hs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExistsInGraph {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		// Mark all the vertices as not visited(By default set as false)
		boolean visited[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				return validPathUtil(visited, n, edges, i, destination);
			}
		}
		return false;
	}

	private boolean validPathUtil(boolean visited[], int n, int[][] edges, int source, int destination) {
		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue
			source = queue.poll();

			// Get all adjacent vertices of the dequeued vertex source
			// If a adjacent has not been visited, then mark it visited and enqueue it
			for (int adjNode : edges[source]) {
				// If this adjacent node is the destination node, then return true
				if (adjNode == destination)
					return true;

				// Else, continue to do BFS
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}
		return false;
	}
}
