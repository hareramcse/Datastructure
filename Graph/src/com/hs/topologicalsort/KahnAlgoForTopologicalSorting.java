package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgoForTopologicalSorting {
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public KahnAlgoForTopologicalSorting(int noOfVertices) {
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	public void addEdge(Queue<Integer>[] adj, int source, int destination) {
		adj[source].add(destination);
	}

	// prints a Topological Sort of the complete graph
	public void topologicalSort(Queue<Integer>[] adj, int noOfVertices) {
		int indegree[] = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			for (int j : adj[i]) {
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

			for (int currentAdjNode : adj[u]) {
				indegree[currentAdjNode]--;
				if (indegree[currentAdjNode] == 0) {
					queue.add(currentAdjNode);
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
		Queue<Integer>[] adj = g.adj;
		g.addEdge(adj, 5, 2);
		g.addEdge(adj, 5, 0);
		g.addEdge(adj, 4, 0);
		g.addEdge(adj, 4, 1);
		g.addEdge(adj, 2, 3);
		g.addEdge(adj, 3, 1);
		System.out.println("Following is a Topological Sort");
		g.topologicalSort(adj, noOfVertices);
	}
}