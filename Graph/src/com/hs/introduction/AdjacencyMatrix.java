package com.hs.introduction;

public class AdjacencyMatrix {

	private int noOfVertices;
	private int matrix[][];

	private AdjacencyMatrix(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		matrix = new int[noOfVertices][noOfVertices];
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(int matrix[][], int source, int destination) {
		matrix[source][destination] = 1;
	}

	// A utility function to print the adjacency list representation of graph
	private void printGraph(int[][] adj) {
		for (int i = 0; i < noOfVertices; i++) {
			for (int j = 0; j < noOfVertices; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AdjacencyMatrix graph = new AdjacencyMatrix(5);
		int[][] matrix = graph.matrix;
		graph.addEdge(matrix, 0, 1);
		graph.addEdge(matrix, 0, 4);
		graph.addEdge(matrix, 1, 2);
		graph.addEdge(matrix, 1, 3);
		graph.addEdge(matrix, 1, 4);
		graph.addEdge(matrix, 2, 3);
		graph.addEdge(matrix, 3, 4);

		graph.printGraph(matrix);
	}

}
