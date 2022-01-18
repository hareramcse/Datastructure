package com.hs.shortestpath;

public class FloyedWarshallAlgorithm {

	private static int INF = 999999;
	private int noOfVertices = 4;
	private int distance[][];

	FloyedWarshallAlgorithm(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		distance = new int[noOfVertices][noOfVertices];
	}

	private void floydWarshall(int graph[][]) {

		/*
		 * Initialize the solution matrix same as input graph matrix. Or we can say the
		 * initial values of shortest distances are based on shortest paths considering
		 * no intermediate vertex.
		 */
		for (int i = 0; i < noOfVertices; i++)
			for (int j = 0; j < noOfVertices; j++)
				distance[i][j] = graph[i][j];

		/*
		 * Add all vertices one by one to the set of intermediate vertices. ---> Before
		 * start of an iteration, we have shortest distances between all pairs of
		 * vertices such that the shortest distances consider only the vertices in set
		 * {0, 1, 2, .. k-1} as intermediate vertices. ----> After the end of an
		 * iteration, vertex no. k is added to the set of intermediate vertices and the
		 * set becomes {0, 1, 2, .. k}
		 */
		for (int k = 0; k < noOfVertices; k++) {
			// Pick all vertices as source one by one
			for (int i = 0; i < noOfVertices; i++) {
				// Pick all vertices as destination for the above picked source
				for (int j = 0; j < noOfVertices; j++) {
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (distance[i][k] + distance[k][j] < distance[i][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(distance);
	}

	private void printSolution(int dist[][]) {
		System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
		for (int i = 0; i < noOfVertices; ++i) {
			for (int j = 0; j < noOfVertices; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Driver program to test above function
	public static void main(String[] args) {
		FloyedWarshallAlgorithm marshal = new FloyedWarshallAlgorithm(4);
		int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };

		// Print the solution
		marshal.floydWarshall(graph);
	}

}