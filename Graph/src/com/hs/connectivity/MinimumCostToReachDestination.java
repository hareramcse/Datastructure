package com.hs.connectivity;

public class MinimumCostToReachDestination {

	private static int INF = Integer.MAX_VALUE, noOfVertices = 4;
	// A recursive function to find the shortest path from
	// source 's' to destination 'd'.

	// This function returns the smallest possible cost to
	// reach station N-1 from station 0.
	private int minCost(int cost[][]) {
		// dist[i] stores minimum cost to reach station i from station 0.
		int dist[] = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			dist[i] = INF;
		dist[0] = 0;

		// Go through every station and check if using it
		// as an intermediate station gives better path
		for (int i = 0; i < noOfVertices; i++)
			for (int j = i + 1; j < noOfVertices; j++)
				if (dist[j] > dist[i] + cost[i][j])
					dist[j] = dist[i] + cost[i][j];

		return dist[noOfVertices - 1];
	}

	public static void main(String args[]) {
		MinimumCostToReachDestination graph = new MinimumCostToReachDestination();
		int cost[][] = { { 0, 15, 80, 90 }, { INF, 0, 40, 50 }, { INF, INF, 0, 70 }, { INF, INF, INF, 0 } };
		System.out.println("The Minimum cost to reach station " + noOfVertices + " is " + graph.minCost(cost));
	}

}