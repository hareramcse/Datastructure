package com.hs.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KrushkalMst {
	private int noOfVertices;
	private List<Edge> edges;
	private int[] parent;

	KrushkalMst(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		edges = new ArrayList<>();
		// create `n` disjoint sets (one for each vertex)
		parent = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			parent[i] = i;
		}
	}

	private void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		edges.add(edge);
	}

	private void kruskalMST() {
		List<Edge> mst = new ArrayList<>();
		Queue<Edge> pq = new PriorityQueue<>(edges.size());

		// add all the edges to priority queue
		pq.addAll(edges);

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			// check if adding this edge creates a cycle
			int x = find(edge.source);
			int y = find(edge.destination);

			// here parents are diff it means both belongs to diff sets
			if (x != y) {
				mst.add(edge);
				union(x, y);
			}
		}
		// print MST
		System.out.println("Minimum Spanning Tree: ");
		printGraph(mst);
	}

	// Find the root of the set in which element `k` belongs
	private int find(int k) {
		// if `k` is root
		if (parent[k] == k) {
			return k;
		}
		// recur for the parent until we find the root
		return find(parent[k]);
	}

	// Perform Union of two subsets
	private void union(int a, int b) {
		// find the root of the sets in which elements `x` and `y` belongs
		int x = find(a);
		int y = find(b);
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
		KrushkalMst graph = new KrushkalMst(4);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 3, 15);
		graph.addEdge(2, 3, 4);
		graph.kruskalMST();
	}
}