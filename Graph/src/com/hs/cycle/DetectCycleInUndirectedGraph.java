package com.hs.cycle;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	DetectCycleInUndirectedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
	}

	// Function to add an edge into the graph
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	private Boolean isCyclic(Queue<Integer> adj[], int noOfVertices) {
		boolean visited[] = new boolean[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i]) {
				// parent of source vertex is -1
				if (isCyclicUtil(adj, i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private Boolean isCyclicUtil(Queue<Integer> adj[], int source, boolean visited[], int parent) {
		visited[source] = true;
		for (int adjNode : adj[source]) {
			if (!visited[adjNode]) {
				if (isCyclicUtil(adj, adjNode, visited, source)) {
					return true;
				}
			}

			// adjacent is visited and not parent of current vertex, then there is a cycle.
			else if (adjNode != parent) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		DetectCycleInUndirectedGraph g1 = new DetectCycleInUndirectedGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		Boolean result = g1.isCyclic(g1.adj, g1.noOfVertices);
		System.out.println(result);
	}
}