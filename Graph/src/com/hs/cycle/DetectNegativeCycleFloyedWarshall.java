package com.hs.cycle;

public class DetectNegativeCycleFloyedWarshall {

	private int noOfVertices = 4;

	// This value will be used for vertices not connected to each other
	private int INF = Integer.MAX_VALUE;

	// Returns true if graph has negative weight cycle else false.
	private boolean hasNegativeCyclefloydWarshall(int graph[][]) {

		/*
		 * dist[][] will be the output matrix that will finally have the shortest
		 * distances between every pair of vertices
		 */
		int dist[][] = new int[noOfVertices][noOfVertices];

		/*
		 * Initialize the solution matrix same as input graph matrix. Or we can say the
		 * initial values of shortest distances are based on shortest paths considering
		 * no intermediate vertex.
		 */
		for (int i = 0; i < noOfVertices; i++)
			for (int j = 0; j < noOfVertices; j++)
				dist[i][j] = graph[i][j];

		/*
		 * Add all vertices one by one to the set of intermediate vertices. ---> Before
		 * start of a iteration, we have shortest distances between all pairs of
		 * vertices such that the shortest distances consider only the vertices in set
		 * {0, 1, 2, .. k-1} as intermediate vertices. ----> After the end of a
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
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		// If distance of any vertex from itself becomes negative, then there is a
		// negative weight cycle.
		for (int i = 0; i < noOfVertices; i++)
			if (dist[i][i] < 0)
				return true;

		return false;
	}

	// Driver code
	public static void main(String[] args) {
		DetectNegativeCycleFloyedWarshall graph = new DetectNegativeCycleFloyedWarshall();
		int graph1[][] = { { 0, 1, graph.INF, graph.INF }, { graph.INF, 0, -1, graph.INF },
				{ graph.INF, graph.INF, 0, -1 }, { -1, graph.INF, graph.INF, 0 } };

		if (graph.hasNegativeCyclefloydWarshall(graph1))
			System.out.print("Yes");
		else
			System.out.print("No");
	}

}