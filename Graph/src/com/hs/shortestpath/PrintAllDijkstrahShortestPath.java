package com.hs.shortestpath;

public class PrintAllDijkstrahShortestPath {
	private int noOfVertices;
	private int[] distance;
	private int[] parents;
	private boolean[] visited;

	private PrintAllDijkstrahShortestPath(int[][] graph) {
		this.noOfVertices = graph.length;

		// shortestDistances[i] will hold the shortest distance from src to i
		distance = new int[noOfVertices];

		// visited[i] will true if vertex i is included in shortest path tree
		visited = new boolean[noOfVertices];

		// Initialize all distances as INFINITE and added[] as false
		for (int i = 0; i < noOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		// Parent array to store shortest path tree
		parents = new int[noOfVertices];
	}

	private void dijkstra(int[][] graph, int source) {

		// Distance of source vertex from itself is always 0
		distance[source] = 0;

		// The starting vertex does not have a parent
		parents[source] = -1;

		// Find shortest path for all vertices
		for (int i = 1; i < noOfVertices; i++) {

			// Pick the minimum distance vertex from the set of vertices not yet
			// processed. nearestVertex is always equal to startNode in first iteration.
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0; vertexIndex < noOfVertices; vertexIndex++) {
				if (!visited[vertexIndex] && distance[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex;
					shortestDistance = distance[vertexIndex];
				}
			}

			// Mark the picked vertex as processed
			visited[nearestVertex] = true;

			// Update dist value of the adjacent vertices of the picked vertex.
			for (int vertexIndex = 0; vertexIndex < noOfVertices; vertexIndex++) {
				int edgeDistance = graph[nearestVertex][vertexIndex];

				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < distance[vertexIndex])) {
					parents[vertexIndex] = nearestVertex;
					distance[vertexIndex] = shortestDistance + edgeDistance;
				}
			}
		}

		printSolution(source, distance, parents);
	}

	// function to print the constructed distances array and shortest paths
	private void printSolution(int startVertex, int[] distances, int[] parents) {
		int noOfVertices = distances.length;
		System.out.print("Vertex\t\t Distance\tPath");

		for (int vertexIndex = 0; vertexIndex < noOfVertices; vertexIndex++) {
			if (vertexIndex != startVertex) {
				System.out.print("\n" + startVertex + " -> ");
				System.out.print(vertexIndex + " \t\t ");
				System.out.print(distances[vertexIndex] + "\t\t");
				printPath(vertexIndex, parents);
			}
		}
	}

	// print shortest path from source to currentVertex using parents array
	private void printPath(int currentVertex, int[] parents) {

		// Base case : Source node has been processed
		if (currentVertex == -1) {
			return;
		}
		printPath(parents[currentVertex], parents);
		System.out.print(currentVertex + " ");
	}

	// Driver Code
	public static void main(String[] args) {

		int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		PrintAllDijkstrahShortestPath dij = new PrintAllDijkstrahShortestPath(graph);
		dij.dijkstra(graph, 0);
	}

}