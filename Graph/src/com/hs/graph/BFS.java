package com.hs.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	int noOfVertices;
	LinkedList<Integer> adj[];
	boolean visited[];

	BFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		visited = new boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public static void addEdge(BFS graph, int source, int destination) {
		graph.adj[source].addFirst(destination);
		graph.adj[destination].addFirst(source);
	}

	public void printBFS(int source) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited[source] = true;

		while (!queue.isEmpty()) {
			int value = queue.pop();
			System.out.print(value);
			System.out.print(" ");
			Iterator<Integer> iterator = adj[value].iterator();
			while (iterator.hasNext()) {
				int val = iterator.next();
				if (!visited[val]) {
					visited[val] = true;
					queue.add(val);
				}
			}
		}

	}

	public static void main(String[] args) {
		int noOfVertices = 5;
		BFS graph = new BFS(noOfVertices);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);

		graph.printBFS(0);
	}
}
