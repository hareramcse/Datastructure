package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgoForTopologicalSorting {
	private List<List<Integer>> adjList;

	private KahnAlgoForTopologicalSorting(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	// prints a Topological Sort of the complete graph
	public void topologicalSort(List<List<Integer>> adjList, int noOfVertices) {
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

		// Initialize count of visited vertices
		int count = 0;

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
			count++;
		}

		// Check if there was a cycle
		if (count != noOfVertices) {
			System.out.println("There exists a cycle in the graph");
			return;
		}

		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static void main(String args[]) {
		int noOfVertices = 6;
		KahnAlgoForTopologicalSorting g = new KahnAlgoForTopologicalSorting(noOfVertices);
		List<List<Integer>> adjList = g.adjList;
		g.addEdge(adjList, 5, 2);
		g.addEdge(adjList, 5, 0);
		g.addEdge(adjList, 4, 0);
		g.addEdge(adjList, 4, 1);
		g.addEdge(adjList, 2, 3);
		g.addEdge(adjList, 3, 1);
		System.out.println("Following is a Topological Sort");
		g.topologicalSort(adjList, noOfVertices);
	}
}