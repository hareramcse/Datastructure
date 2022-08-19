package com.hs.shortestpath;

public class PrintAllDijkstrahShortestPath {
	private int noOfVertices;

	private PrintAllDijkstrahShortestPath(int[][] graph) {
		this.noOfVertices = graph.length;
	}

	private void dijkstra(int[][] graph, int source) {
		boolean[] visited = new boolean[noOfVertices];
		int[] distance = new int[noOfVertices];
		int[] parents = new int[noOfVertices];
		
		for (int i = 0; i < noOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
			parents[i] = -1;
		}
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

	private void printPath(int currentVertex, int[] parents) {
		if (currentVertex == -1) {
			return;
		}
		printPath(parents[currentVertex], parents);
		System.out.print(currentVertex + " ");
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		PrintAllDijkstrahShortestPath dij = new PrintAllDijkstrahShortestPath(graph);
		dij.dijkstra(graph, 0);
	}
}