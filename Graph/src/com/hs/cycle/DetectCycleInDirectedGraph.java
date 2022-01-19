package com.hs.cycle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraph {
	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	DetectCycleInDirectedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	private boolean isCyclic(int source) {
		boolean visited[] = new boolean[noOfVertices];
		boolean recStack[] = new boolean[noOfVertices];

		// Call the recursive helper function to detect cycle in different DFS trees
		for (int i = 0; i < noOfVertices; i++)
			if (visited[source] == false)
				if (isCyclicUtil(i, visited, recStack))
					return true;

		return false;
	}

	private boolean isCyclicUtil(int source, boolean visited[], boolean recStack[]) {
		// Mark the current node as visited and part of recursion stack
		visited[source] = true;
		recStack[source] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> iterator = adj[source].iterator();
		while (iterator.hasNext()) {
			int currentAdjNode = iterator.next();
			if (!visited[currentAdjNode]) {
				if (isCyclicUtil(currentAdjNode, visited, recStack)) {
					return true;
				}
			}

			if (recStack[currentAdjNode])
				return true;
		}

		recStack[source] = false; // remove the vertex from recursion stack
		return false;
	}

	public static void main(String[] args) {
		DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.println(graph.isCyclic(0));
	}
}
