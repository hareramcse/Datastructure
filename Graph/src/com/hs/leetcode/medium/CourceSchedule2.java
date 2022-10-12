package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourceSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		int m = prerequisites.length;
		for (int i = 0; i < m; i++) {
			adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		List<Integer> result = topologicalSort(adjList, numCourses);
		int[] ans = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			ans[i] = result.get(i);
		}
		return ans;
	}

	public List<Integer> topologicalSort(List<List<Integer>> adjList, int noOfVertices) {
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

			for (int currentAdjNode : adjList.get(u)) {
				indegree[currentAdjNode]--;
				if (indegree[currentAdjNode] == 0) {
					queue.add(currentAdjNode);
				}
			}
		}

		// Check if there was a cycle
		if (result.size() != noOfVertices)
			return Collections.emptyList();
		return result;
	}
}
