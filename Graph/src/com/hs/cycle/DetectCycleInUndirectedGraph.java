package com.hs.cycle;

public class DetectCycleInUndirectedGraph {
	int noOfVertices, noOfEdges; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // /collection of all edges

	class Edge {
		int source, destination;
	};

	// Creates a graph with V vertices and E edges
	DetectCycleInUndirectedGraph(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		edge = new Edge[noOfEdges];
		for (int i = 0; i < noOfEdges; ++i)
			edge[i] = new Edge();
	}

	// A utility function to find the subset of an element i
	int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	// A utility function to do union of two subsets
	void Union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	// The main function to check whether a given graph
	// contains cycle or not
	int isCycle(DetectCycleInUndirectedGraph graph) {
		// Allocate memory for creating V subsets
		int parent[] = new int[graph.noOfVertices];

		// Initialize all subsets as single element sets
		for (int i = 0; i < graph.noOfVertices; ++i)
			parent[i] = -1;

		// Iterate through all edges of graph, find subset of both
		// vertices of every edge, if both subsets are same, then
		// there is cycle in graph.
		for (int i = 0; i < graph.noOfEdges; ++i) {
			int x = graph.find(parent, graph.edge[i].source);
			int y = graph.find(parent, graph.edge[i].destination);

			if (x == y)
				return 1;

			graph.Union(parent, x, y);
		}
		return 0;
	}

	// Driver Method
	public static void main(String[] args) {
		/*
		 * Let us create following graph 0 | \ | \ 1-----2
		 */
		int V = 3, E = 3;
		DetectCycleInUndirectedGraph graph = new DetectCycleInUndirectedGraph(V, E);

		// add edge 0-1
		graph.edge[0].source = 0;
		graph.edge[0].destination = 1;

		// add edge 1-2
		graph.edge[1].source = 1;
		graph.edge[1].destination = 2;

		// add edge 0-2
		graph.edge[2].source = 0;
		graph.edge[2].destination = 2;

		if (graph.isCycle(graph) == 1)
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}
}
