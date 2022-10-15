package com.hs.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KrushkalMst {

	private void addEdge(List<Edge> edges, int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		edges.add(edge);
	}

	private void kruskalMST(int V, List<Edge> edges) {
		List<Edge> mst = new ArrayList<>();
		Queue<Edge> pq = new PriorityQueue<>(edges.size());

		// add all the edges to priority queue
		pq.addAll(edges);

		int[] parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

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

	// Find the parent of the set in which element `k` belongs
	private int find(int[] parent, int k) {
		if (parent[k] == k) {
			return k;
		}
		return find(parent, parent[k]);
	}

	// Perform Union of two subsets
	private void union(int[] parent, int a, int b) {
		// find the parent of the sets in which elements `x` and `y` belongs
		int x = find(parent, a);
		int y = find(parent, b);
		parent[x] = y;
	}

	private void printGraph(List<Edge> mst) {
		int minimumCost = 0;
		System.out.println("Edge \tWeight ");
		for (int i = 0; i < mst.size(); i++) {
			Edge edge = mst.get(i);
			System.out.println(edge.source + "->" + edge.destination + "\t" + edge.weight);
			minimumCost = minimumCost + edge.weight;
		}
		System.out.println("Minimum cost is " + minimumCost);
	}

	public static void main(String[] args) {
		KrushkalMst graph = new KrushkalMst();
		List<Edge> edges = new ArrayList<>();
		int V = 4;
		graph.addEdge(edges, 0, 1, 10);
		graph.addEdge(edges, 0, 2, 6);
		graph.addEdge(edges, 0, 3, 5);
		graph.addEdge(edges, 1, 3, 15);
		graph.addEdge(edges, 2, 3, 4);
		graph.kruskalMST(V, edges);
	}
}