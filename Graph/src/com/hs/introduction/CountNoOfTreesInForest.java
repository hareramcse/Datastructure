package com.hs.introduction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CountNoOfTreesInForest {

	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	CountNoOfTreesInForest(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int detination) {
		adj[source].add(detination);
	}

	private int countTrees() {
		// Mark all the vertices as not visited(set as false by default in java)
		boolean visited[] = new boolean[noOfVertices];
		int res = 0;

		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i = 0; i < noOfVertices; i++) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
				res++;
			}
		}
		return res;
	}

	// A function used by DFS
	private void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> iterator = adj[v].iterator();
		while (iterator.hasNext()) {
			int vertex = iterator.next();
			if (!visited[vertex]) {
				DFSUtil(vertex, visited);
			}
		}
	}

	public static void main(String args[]) {
		CountNoOfTreesInForest graph = new CountNoOfTreesInForest(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(3, 4);

		System.out.println(graph.countTrees());
	}

}