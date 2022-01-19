package com.hs.connectivity;

public class TransitiveClosure {

	private int noOfVertices = 4; // Number of vertices in a graph

	// Prints transitive closure of graph[][] using Floyd Warshall algorithm
	private void transitiveClosure(int graph[][]) {
		/*
		 * reach[][] will be the output matrix that will finally have the shortest
		 * distances between every pair of vertices
		 */
		int reach[][] = new int[noOfVertices][noOfVertices];
		int i, j, k;

		/*
		 * Initialize the solution matrix same as input graph matrix. Or we can say the
		 * initial values of shortest distances are based on shortest paths considering
		 * no intermediate vertex.
		 */
		for (i = 0; i < noOfVertices; i++)
			for (j = 0; j < noOfVertices; j++)
				reach[i][j] = graph[i][j];

		/*
		 * Add all vertices one by one to the set of intermediate vertices. ---> Before
		 * start of a iteration, we have reachability values for all pairs of vertices
		 * such that the reachability values consider only the vertices in set {0, 1, 2,
		 * .. k-1} as intermediate vertices. ----> After the end of a iteration, vertex
		 * no. k is added to the set of intermediate vertices and the set becomes {0, 1,
		 * 2, .. k}
		 */
		for (k = 0; k < noOfVertices; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < noOfVertices; i++) {
				// Pick all vertices as destination for the
				// above picked source
				for (j = 0; j < noOfVertices; j++) {
					// If vertex k is on a path from i to j,
					// then make sure that the value of reach[i][j] is 1
					reach[i][j] = (reach[i][j] != 0) || ((reach[i][k] != 0) && (reach[k][j] != 0)) ? 1 : 0;
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(reach);
	}

	/* A utility function to print solution */
	private void printSolution(int reach[][]) {
		System.out.println("Following matrix is transitive closure" + " of the given graph");
		for (int i = 0; i < noOfVertices; i++) {
			for (int j = 0; j < noOfVertices; j++) {
				if (i == j)
					System.out.print("1 ");
				else
					System.out.print(reach[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Driver Code
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 1, 1, 0, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } };

		// Print the solution
		TransitiveClosure tc = new TransitiveClosure();
		tc.transitiveClosure(graph);
	}

}