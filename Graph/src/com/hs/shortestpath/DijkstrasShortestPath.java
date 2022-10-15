package com.hs.shortestpath;

public class DijkstrasShortestPath {

	private void dijkstra(int V, int src, int graph[][]) {
		// visited[i] will be true if vertex i is included in shortest path tree
		boolean[] visited = new boolean[V];

		int[] dist = new int[V];
		// Initialize all distances as INFINITE
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int i = 0; i < V - 1; i++) {
			// Pick the minimum distance
			int u = minDistance(dist, visited);

			// Mark the picked vertex as visited
			visited[u] = true;

			for (int v = 0; v < V; v++)
				// Update dist[v] only
				// if vertex is not visited
				// there is an edge from u to v
				// total weight of path from src to v through u is smaller than current value of
				// dist[v]
				if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		printSolution(dist);
	}

	private int minDistance(int distance[], boolean visited[]) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for (int i = 0; i < distance.length; i++) {
			if (visited[i] == false && distance[i] <= min) {
				min = distance[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private void printSolution(int dist[]) {
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		DijkstrasShortestPath dij = new DijkstrasShortestPath();
		int V = matrix.length;
		int source = 0;
		dij.dijkstra(V, source, matrix);
	}
}