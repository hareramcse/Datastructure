package com.hs.mst;

public class PrimsAlgorithmMST {
	private int noOfVertices = 5;
	private int parent[];
	private int weight[];
	private boolean mst[];

	private PrimsAlgorithmMST(int noOfVertices) {
		// Array to store constructed MST
		parent = new int[noOfVertices];

		// weight values used to pick minimum weight edge in cut
		weight = new int[noOfVertices];

		// To represent set of vertices included in MST
		mst = new boolean[noOfVertices];

		// Initialize all keys as INFINITE
		for (int i = 0; i < noOfVertices; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
	}

	// construct and print MST for a graph represented using adjacency matrix
	private void primsMST(int graph[][]) {
		// Always include first 1st vertex in MST.
		// Make weight 0 so that this vertex is picked as first vertex
		weight[0] = 0;
		parent[0] = -1; // First node is always root of MST

		// The MST will have V vertices
		for (int i = 0; i < noOfVertices - 1; i++) {
			// Pick the minimum weight vertex from the set of vertices not yet included in
			// MST
			int u = minWeightVertex(weight, mst);

			// Add the picked vertex to the MST Set
			mst[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < noOfVertices; v++)

				// graph[u][v] is non zero only for adjacent vertices of u
				// mstSet[v] is false for vertices not yet included in MST
				// Update the weight only if graph[u][v] is smaller than weight[v]
				if (graph[u][v] != 0 && mst[v] == false && graph[u][v] < weight[v]) {
					parent[v] = u;
					weight[v] = graph[u][v];
				}
		}

		// print the constructed MST
		printMST(parent, graph);
	}

	// A utility function to find the vertex with minimum weight
	// from the set of vertices not yet included in MST
	private int minWeightVertex(int weight[], boolean mst[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int v = 0; v < noOfVertices; v++)
			if (mst[v] == false && weight[v] < min) {
				min = weight[v];
				minIndex = v;
			}

		return minIndex;
	}

	// print the constructed MST stored in parent[]
	private void printMST(int parent[], int graph[][]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < noOfVertices; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	public static void main(String[] args) {

		PrimsAlgorithmMST mst = new PrimsAlgorithmMST(5);
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };

		// Print the solution
		mst.primsMST(graph);
	}

}