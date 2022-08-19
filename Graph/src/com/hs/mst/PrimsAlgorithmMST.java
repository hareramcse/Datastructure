package com.hs.mst;

public class PrimsAlgorithmMST {
	private int noOfVertices;

	// construct and print MST for a graph represented using adjacency matrix
	private void primsMST(int graph[][]) {
		noOfVertices = graph.length;

		int weight[] = new int[noOfVertices];
		boolean visited[] = new boolean[noOfVertices];
		int parent[] = new int[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			weight[i] = Integer.MAX_VALUE;
			visited[i] = false;
			parent[i] = -1;
		}

		// Make weight 0 to 1st edge so that this vertex is picked as first vertex
		weight[0] = 0;

		for (int i = 0; i < noOfVertices - 1; i++) {
			// pick minimum weight vertex from the set of vertices not yet included in MST
			int u = minWeightVertex(weight, visited);

			// mark the node as visited
			visited[u] = true;

			// update parent and weight array
			for (int v = 0; v < noOfVertices; v++)
				if (graph[u][v] != 0 && visited[v] == false && graph[u][v] < weight[v]) {
					weight[v] = graph[u][v];
					parent[v] = u;
				}
		}
		printMST(parent, graph);
	}

	// A utility function to find the vertex with minimum weight
	// from the set of vertices not yet included in MST
	private int minWeightVertex(int weight[], boolean visited[]) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for (int v = 0; v < noOfVertices; v++)
			if (visited[v] == false && weight[v] < min) {
				min = weight[v];
				minIndex = v;
			}
		return minIndex;
	}

	private void printMST(int parent[], int graph[][]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < noOfVertices; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };
		PrimsAlgorithmMST mst = new PrimsAlgorithmMST();
		mst.primsMST(graph);
	}
}