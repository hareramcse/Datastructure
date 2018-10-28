package com.hs.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class IDSSearch {
	int v;
	LinkedList<Integer> adj[];

	public IDSSearch(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for (int i = 0; i < 5; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].addFirst(destination);
	}

	private boolean DLS(int source, int target, int limit) {
		if (source == target)
			return true;

		// If reached the maximum depth, stop recursing.
		if (limit <= 0)
			return false;

		// Recur for all the vertices adjacent to source vertex
		Iterator<Integer> iterator = adj[source].listIterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			if (DLS(value, target, limit - 1) == true) {
				return true;
			}
		}

		return false;
	}

	private boolean IDDFS(int src, int target, int max_depth) {
		// Repeatedly depth-limit search till the maximum depth.
		for (int i = 0; i <= max_depth; i++)
			if (DLS(src, target, i) == true)
				return true;

		return false;
	}

	public static void main(String[] args) {
		int noOfVertices = 7;
		IDSSearch g = new IDSSearch(noOfVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(2, 6);

		int target = 6, maxDepth = 3, src = 0;
		if (g.IDDFS(src, target, maxDepth) == true)
			System.out.println("Target is reachable from source within max depth");
		else
			System.out.println("Target is NOT reachable from source within max depth");
	}
}
