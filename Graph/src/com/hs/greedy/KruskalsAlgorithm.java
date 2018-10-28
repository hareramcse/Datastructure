package com.hs.greedy;

import java.util.Arrays;

public class KruskalsAlgorithm {
	int noOfVertex, noOfEdges;

	Edge edge[];

	KruskalsAlgorithm(int noOfVertex, int noOfEdge) {
		this.noOfVertex = noOfVertex;
		this.noOfEdges = noOfEdge;
		edge = new Edge[noOfEdge];

		for (int i = 0; i < noOfEdge; ++i) {
			edge[i] = new Edge();
		}
	}

	// A utility function to find set of an element
	// (uses path compression technique)
	int findSet(Subset subsets[], int value) {
		if (subsets[value].parent != value) {
			subsets[value].parent = findSet(subsets, subsets[value].parent);
		}
		return subsets[value].parent;
	}

	// A function that does union of two sets of set which contains x and set which
	// contains y
	void Union(Subset subsets[], int x, int y) {
		int xroot = findSet(subsets, x);
		int yroot = findSet(subsets, y);

		// Make higher rank tree as parent and smaller rank tree as child
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		// If ranks are same, then make one as root and increment its parent rank by one
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	// The main function to construct MST using Kruskal's algorithm
	void KruskalMST() {
		Edge result[] = new Edge[noOfVertex]; // This will store the resultant MST
		int e = 0; // An index variable, used for result[]
		int i = 0; // An index variable, used for sorted edges
		for (i = 0; i < noOfVertex; ++i)
			result[i] = new Edge();

		// Step 1: Sort all the edges in non-decreasing order of their
		// weight. If we are not allowed to change the given graph, we
		// can create a copy of array of edges
		Arrays.sort(edge);

		// Allocate memory for creating V subsets
		Subset subsets[] = new Subset[noOfVertex];
		for (i = 0; i < noOfVertex; ++i)
			subsets[i] = new Subset();

		// Create V subsets with single elements
		for (int v = 0; v < noOfVertex; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0; // Index used to pick next edge

		// Number of edges to be taken is equal to V-1
		while (e < noOfVertex - 1) {
			// Step 2: Pick the smallest edge. And increment
			// the index for next iteration
			Edge next_edge = edge[i++];

			int x = findSet(subsets, next_edge.src);
			int y = findSet(subsets, next_edge.dest);

			// If including this edge does't cause cycle,
			// include it in result and increment the index
			// of result for next edge
			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
			// Else discard the next_edge
		}

		// print the contents of result[] to display
		// the built MST
		System.out.println("Following are the edges in " + "the constructed MST");
		for (i = 0; i < e; ++i)
			System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
	}

	public static void main(String[] args) {

		int noOfVertex = 4; // Number of vertices in graph
		int noOfEdge = 5; // Number of edges in graph
		KruskalsAlgorithm graph = new KruskalsAlgorithm(noOfVertex, noOfEdge);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;

		graph.KruskalMST();
	}
}