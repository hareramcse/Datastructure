package com.hs.shortestpath;

public class DijkstrasShortestPath {

	private int noOfVertices = 9;

	private void dijkstra(int graph[][], int src) {
		// The output array. dist[i] will hold
		// the shortest distance from src to i
		int dist[] = new int[noOfVertices];

		// spt[i] will be true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		boolean spt[] = new boolean[noOfVertices];

		// Initialize all distances as INFINITE and stp[] as false
		for (int i = 0; i < noOfVertices; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < noOfVertices - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minDistance(dist, spt);

			// Mark the picked vertex as processed
			spt[u] = true;

			// Update dist value of the adjacent vertices of the picked vertex.
			for (int v = 0; v < noOfVertices; v++)

				// Update dist[v] only if is not in sptSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of dist[v]
				if (!spt[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		printSolution(dist);
	}

	private int minDistance(int distance[], boolean spt[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int i = 0; i < noOfVertices; i++)
			if (spt[i] == false && distance[i] <= min) {
				min = distance[i];
				minIndex = i;
			}

		return minIndex;
	}

	// A utility function to print the constructed distance array
	private void printSolution(int dist[]) {
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < noOfVertices; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	// Driver method
	public static void main(String[] args) {
		DijkstrasShortestPath dij = new DijkstrasShortestPath();
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		dij.dijkstra(graph, 0);
	}

}