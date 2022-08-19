package com.hs.topologicalsort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class KahnAlgoForTopologicalSorting {
	private int noOfVertices;
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public KahnAlgoForTopologicalSorting(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	// Function to add an edge to graph
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// prints a Topological Sort of the complete graph
	public void topologicalSort(Queue<Integer>[] adj) {
		// Initialize all indegrees as 0.
		int indegree[] = new int[noOfVertices];

		// Traverse adjacency lists to fill indegrees of vertices
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

		// Create a vector to store result
		Vector<Integer> result = new Vector<Integer>();
		while (!queue.isEmpty()) {
			// perform dequeue and add it to topological order
			int u = queue.poll();
			result.add(u);

			// Iterate through all its neighbouring nodes of dequeued node u and decrease
			// their in-degree by 1
			for (int currentAdjNode : adj[u]) {
				// If in-degree becomes zero, add it to queue
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
		KahnAlgoForTopologicalSorting g = new KahnAlgoForTopologicalSorting(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is a Topological Sort");
		g.topologicalSort(g.adj);
	}
}