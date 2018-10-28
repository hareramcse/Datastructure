package com.hs.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class TransitiveClosure {
	int noOfVertices;
	LinkedList<Integer> adj[];
	int tc[][];

	TransitiveClosure(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		tc = new int[noOfVertices][noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}

		for (int i = 0; i < noOfVertices; i++) {
			for (int j = 0; j < noOfVertices; j++) {
				tc[i][j] = 0;
			}
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].addFirst(destination);
	}

	public void DFSUtil(int source, int destination) {
		tc[source][destination] = 1;
		Iterator<Integer> iterator = adj[destination].listIterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			if (tc[source][value] == 0) {
				DFSUtil(source, value);
			}
		}
	}

	public void getTransitiveClosure() {
		for (int i = 0; i < noOfVertices; i++)
			DFSUtil(i, i); // Every vertex is reachable from self.

		for (int i = 0; i < noOfVertices; i++) {
			for (int j = 0; j < noOfVertices; j++) {
				System.out.print(tc[i][j]);
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		TransitiveClosure g = new TransitiveClosure(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.getTransitiveClosure();
	}
}
