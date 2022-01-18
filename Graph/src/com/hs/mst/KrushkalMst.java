package com.hs.mst;

import java.util.Arrays;

public class KrushkalMst {

	// A class to represent a subset for union-find
	class subset {
		int parent, rank;
	};

	int noOfVertices, noOfEdges; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // collection of all edges

	// Creates a graph with noOfVertices vertices and noOfEdges edges
	KrushkalMst(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		edge = new Edge[noOfEdges];
		for (int i = 0; i < noOfEdges; ++i)
			edge[i] = new Edge();
	}

	// The main function to construct MST using Kruskal's algorithm
	private void KruskalMST() {
		// Tnis will store the resultant MST
		Edge result[] = new Edge[noOfVertices];

		// An index variable, used for result[]
		int e = 0;

		// An index variable, used for sorted edges
		int i = 0;
		for (i = 0; i < noOfVertices; ++i)
			result[i] = new Edge();

		// Step 1: Sort all the edges in non-decreasing
		// order of their weight. If we are not allowed to
		// change the given graph, we can create a copy of
		// array of edges
		Arrays.sort(edge);

		// Allocate memory for creating V ssubsets
		subset subsets[] = new subset[noOfVertices];
		for (i = 0; i < noOfVertices; ++i)
			subsets[i] = new subset();

		// Create V subsets with single elements
		for (int v = 0; v < noOfVertices; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0; // Index used to pick next edge

		// Number of edges to be taken is equal to V-1
		while (e < noOfVertices - 1) {
			// Step 2: Pick the smallest edge. And increment
			// the index for next iteration
			Edge next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			// If including this edge does't cause cycle,
			// include it in result and increment the index
			// of result for next edge
			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
			// Else discard the next_edge
		}

		// print the contents of result[] to display the built MST
		System.out.println("Following are the edges in " + "the constructed MST");
		int minimumCost = 0;
		for (i = 0; i < e; ++i) {
			System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree " + minimumCost);
	}

	// A utility function to find set of an element i (uses path compression
	// technique)
	private int find(subset subsets[], int i) {
		// find root and make root as parent of i (path compression)
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	// A function that does union of two sets of x and y (uses union by rank)
	private void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		// Attach smaller rank tree under root of high rank tree (Union by Rank)
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		// If ranks are same, then make one as root and increment its rank by one
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	// Driver Code
	public static void main(String[] args) {
		KrushkalMst graph = new KrushkalMst(4, 5);

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

		// Function call
		graph.KruskalMST();
	}

}