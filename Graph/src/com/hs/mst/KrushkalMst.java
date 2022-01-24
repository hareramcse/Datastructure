package com.hs.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KrushkalMst {

	private int noOfVertices;
	private List<Edge> edges = new ArrayList<>();

	KrushkalMst(int noOfVertices) {
		this.noOfVertices = noOfVertices;
	}

	public void addEgde(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		edges.add(edge);
	}

	public void kruskalMST() {
		Queue<Edge> pq = new PriorityQueue<>(edges.size());

		// add all the edges to priority queue
		for (int i = 0; i < edges.size(); i++) {
			pq.add(edges.get(i));
		}

		// create a parent []
		int[] parent = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			parent[i] = i;
		}

		List<Edge> mst = new ArrayList<>();

		int index = 0;
		while (index < noOfVertices - 1) {
			Edge edge = pq.remove();
			// check if adding this edge creates a cycle
			int x = find(parent, edge.source);
			int y = find(parent, edge.destination);

			if (x != y) {
				mst.add(edge);
				index++;
				union(parent, x, y);
			}
		}
		// print MST
		System.out.println("Minimum Spanning Tree: ");
		printGraph(mst);
	}

	public int find(int[] parent, int vertex) {
		// chain of parent pointers from x upwards through the tree
		// until an element is reached whose parent is itself
		if (parent[vertex] != vertex)
			return find(parent, parent[vertex]);
		return vertex;
	}

	public void union(int[] parent, int x, int y) {
		int x_parent = find(parent, x);
		int y_parent = find(parent, y);
		// make x as parent of y
		parent[y_parent] = x_parent;
	}

	public void printGraph(List<Edge> result) {
		int minimumCost = 0;
		for (int i = 0; i < result.size(); i++) {
			Edge edge = result.get(i);
			System.out.println("Edge-" + i + " source: " + edge.source + " destination: " + edge.destination
					+ " weight: " + edge.weight);
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