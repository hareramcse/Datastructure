package com.hs.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KrushkalMst {

	private int noOfVertices;
	private int[] parent;
	private List<Edge> edges;
	private List<Edge> mst;

	KrushkalMst(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		parent = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			parent[i] = i;
		}
		edges = new ArrayList<>();
		mst = new ArrayList<>();
	}

	private void addEgde(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		edges.add(edge);
	}

	private void kruskalMST() {
		Queue<Edge> pq = new PriorityQueue<>(edges.size());

		// add all the edges to priority queue
		pq.addAll(edges);

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			// check if adding this edge creates a cycle
			int x = find(parent, edge.source);
			int y = find(parent, edge.destination);

			// here parents are diff it means both belongs to diff sets
			if (x != y) {
				mst.add(edge);
				union(parent, x, y);
			}

		}
		// print MST
		System.out.println("Minimum Spanning Tree: ");
		printGraph(mst);
	}

	private int find(int[] parent, int vertex) {
		// chain of parent pointers from x upwards through the tree
		// until an element is reached whose parent is itself
		if (parent[vertex] != vertex)
			return find(parent, parent[vertex]);
		return vertex;
	}

	private void union(int[] parent, int x, int y) {
		int x_parent = find(parent, x);
		int y_parent = find(parent, y);
		// make x as parent of y
		parent[y_parent] = x_parent;
	}

	private void printGraph(List<Edge> result) {
		int minimumCost = 0;
		System.out.println("Edge \tWeight ");
		for (int i = 0; i < result.size(); i++) {
			Edge edge = result.get(i);
			System.out.println(edge.source + "->" + edge.destination + "\t" + edge.weight);
			minimumCost = minimumCost + edge.weight;
		}
		System.out.println("Minimum cost is " + minimumCost);
	}

	// Driver Code
	public static void main(String[] args) {
		KrushkalMst graph = new KrushkalMst(4);

		// add edge 0-1
		graph.addEgde(0, 1, 10);

		// add edge 0-2
		graph.addEgde(0, 2, 6);

		// add edge 0-3
		graph.addEgde(0, 3, 5);

		// add edge 1-3
		graph.addEgde(1, 3, 15);

		// add edge 2-3
		graph.addEgde(2, 3, 4);

		// Function call
		graph.kruskalMST();
	}

}