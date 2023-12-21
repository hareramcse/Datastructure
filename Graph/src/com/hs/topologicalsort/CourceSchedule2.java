package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		return  topologicalSort(adjList, numCourses);
	}

	private int[] topologicalSort(List<List<Integer>> adjList, int V) {
		int indegree[] = new int[V];
		for (int i = 0; i < V; i++) {
			for (int j : adjList.get(i)) {
				indegree[j]++;
			}
		}

		// Create a queue and enqueue all vertices with indegree 0
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		int[] result = new int[V];
		int i = 0;
		while (!queue.isEmpty()) {
			// perform dequeue and add it to topological order
			int u = queue.poll();
			result[i++] = u;

			for (int adjNode : adjList.get(u)) {
				indegree[adjNode]--;
				if (indegree[adjNode] == 0) {
					queue.add(adjNode);
				}
			}
		}

		// Check if there was a cycle
		if (i != V)
			return new int[]{};
		
		return result;
	}

	public static void main(String[] args) {
		CourceSchedule2 graph = new CourceSchedule2();
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] result = graph.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(result));
	}
}