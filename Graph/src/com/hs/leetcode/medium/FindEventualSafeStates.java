package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
	
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<List<Integer>> adjList = new ArrayList<>();
		int V = graph.length;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < V; i++) {
			// here i -> j means there is a edge between i -> j
			// so we need to change its direction and make it to j -> i
			for (int j : graph[i]) {
				adjList.get(j).add(i);
			}
		}

		return topologicalSort(adjList, V);
	}

	private List<Integer> topologicalSort(List<List<Integer>> adjList, int V) {
		int[] indegree = new int[V];
		for (int i = 0; i < V; i++) {
			for (int j : adjList.get(i)) {
				indegree[j]++;
			}
		}

		// Create a queue and enqueue all vertices with indegree 0
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		List<Integer> result = new ArrayList<>();
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

		Collections.sort(result);

		return result;
	}

	public static void main(String[] args) {
		FindEventualSafeStates graph = new FindEventualSafeStates();
		int[][] matrix = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		List<Integer> result = graph.eventualSafeNodes(matrix);
		System.out.println(result);
	}
}