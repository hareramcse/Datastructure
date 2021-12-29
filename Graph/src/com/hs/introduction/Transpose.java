package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

public class Transpose {

	// Total number of vertices
	private int noOfVertices = 5;

	// Find transpose of graph represented by adj
	private List<Integer>[] adj = new ArrayList[noOfVertices];

	// Store the transpose of graph represented by tr
	private List<Integer>[] transpose = new ArrayList[noOfVertices];

	// Function to add an edge from source vertex u to
	// destination vertex v, if choice is false the edge is added
	// to adj otherwise the edge is added to tr
	private void addedge(int u, int v, boolean choice) {
		if (!choice)
			adj[u].add(v);
		else
			transpose[u].add(v);
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

	// Function to print the transpose of
	// the graph represented as adj and store it in tr
	private void getTranspose() {

		// Traverse the graph and for each edge u, v
		// in graph add the edge v, u in transpose
		for (int i = 0; i < noOfVertices; i++)
			for (int j = 0; j < adj[i].size(); j++)
				addedge(adj[i].get(j), i, true);
	}

	public static void main(String[] args) {
		Transpose graph = new Transpose();
		for (int i = 0; i < graph.noOfVertices; i++) {
			graph.adj[i] = new ArrayList<Integer>();
			graph.transpose[i] = new ArrayList<Integer>();
		}
		graph.addedge(0, 1, false);
		graph.addedge(0, 4, false);
		graph.addedge(0, 3, false);
		graph.addedge(2, 0, false);
		graph.addedge(3, 2, false);
		graph.addedge(4, 1, false);
		graph.addedge(4, 3, false);

		// Finding transpose of the graph
		graph.getTranspose();

		// Printing the graph representation
		graph.printGraph();
	}

}