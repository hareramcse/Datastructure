package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> ans = new ArrayList<>();
		int source = 0;
		int destination = graph.length - 1;
		// Create a queue which stores the paths
		Queue<List<Integer>> queue = new LinkedList<>();

		// Path vector to store the current path
		List<Integer> path = new ArrayList<>();
		path.add(source);
		queue.add(path);

		while (!queue.isEmpty()) {
			path = queue.poll();
			int lastVertex = path.get(path.size() - 1);

			// If last vertex is the desired destination then print the path
			if (lastVertex == destination) {
				ans.add(path);
			}

			// Traverse nodes connected to current vertex and push new path to queue
			for (Integer adjNode : graph[lastVertex]) {
				if (!isPresentInPath(path, adjNode)) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(adjNode);
					queue.add(newPath);
				}
			}
		}
		return ans;
	}

	// Utility function to check if current vertex is already present in path
	private boolean isPresentInPath(List<Integer> path, int adjNode) {
		for (int i = 0; i < path.size(); i++)
			if (path.get(i) == adjNode)
				return true;

		return false;
	}
}
