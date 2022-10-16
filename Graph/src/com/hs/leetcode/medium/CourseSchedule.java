package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		int m = prerequisites.length;
		for (int i = 0; i < m; i++) {
			adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		return topologicalSort(adjList, numCourses);
	}

	public boolean topologicalSort(List<List<Integer>> adjList, int noOfVertices) {
		int indegree[] = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			for (int j : adjList.get(i)) {
				indegree[j]++;
			}
		}

		// Create a queue and enqueue all vertices with indegree 0
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < noOfVertices; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			// perform dequeue and add it to topological order
			int u = queue.poll();
			result.add(u);

			for (int adjNode : adjList.get(u)) {
				indegree[adjNode]--;
				if (indegree[adjNode] == 0) {
					queue.add(adjNode);
				}
			}
		}

		// Check if there was a cycle
		if (result.size() != noOfVertices)
			return false;
		return true;
	}
}
