package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

public class Transpose {

	private int noOfVertices;
	private List<Integer>[] adj;
	private List<Integer>[] transpose;

	@SuppressWarnings("unchecked")
	Transpose(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new ArrayList[noOfVertices];
		transpose = new ArrayList[noOfVertices];
	}

	// Function to add an edge from source vertex u to
	// destination vertex v, if choice is false the edge is added
	// to adj otherwise the edge is added to transpose
	private void addEdge(int source, int destination, boolean choice) {
		if (!choice)
			adj[source].add(destination);
		else
			transpose[source].add(destination);
	}

	// print the transpose of the graph represented as adj and store it in transpose
	private void getTranspose() {

		// for each edge u, v in graph add the edge v, u in transpose
		for (int i = 0; i < noOfVertices; i++)
			for (int j = 0; j < adj[i].size(); j++)
				addEdge(adj[i].get(j), i, true);
	}

	// Function to print the graph representation
	private void printGraph() {
		for (int i = 0; i < noOfVertices; i++) {
			System.out.print(i + "--> ");
			for (int j = 0; j < transpose[i].size(); j++)
				System.out.print(transpose[i].get(j) + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Transpose graph = new Transpose(5);
		for (int i = 0; i < graph.noOfVertices; i++) {
			graph.adj[i] = new ArrayList<Integer>();
			graph.transpose[i] = new ArrayList<Integer>();
		}
		graph.addEdge(0, 1, false);
		graph.addEdge(0, 4, false);
		graph.addEdge(0, 3, false);
		graph.addEdge(2, 0, false);
		graph.addEdge(3, 2, false);
		graph.addEdge(4, 1, false);
		graph.addEdge(4, 3, false);

		// Finding transpose of the graph
		graph.getTranspose();

		// Printing the graph representation
		graph.printGraph();
	}

}