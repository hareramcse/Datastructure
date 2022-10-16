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
			for (int j : graph[i]) {
				adjList.get(j).add(i);
			}
		}

		return topologicalSort(adjList, V);
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
