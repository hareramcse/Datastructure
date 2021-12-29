package com.hs.introduction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class GraphRepresentationUsingMap {

	// TreeSet is used to get clear understand of graph.
	private Map<Integer, TreeSet<Integer>> graph;
	private int noOfVertices;

	private GraphRepresentationUsingMap(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		graph = new HashMap<>();
		
		for (int i = 0; i < noOfVertices; i++) {
			graph.put(i, new TreeSet<>());
		}
	}

	// Adds an edge to an undirected graph
	private void addEdge(int src, int dest) {

		// Add an edge from src to dest into the set
		graph.get(src).add(dest);

		// Since graph is undirected, add an edge from dest to src into the set
		graph.get(dest).add(src);
	}

	// A utility function to print the graph
	private void printGraph() {
		for (int i = 0; i < noOfVertices; i++) {
			System.out.println("Adjacency list of vertex " + i);
			Iterator<Integer> iterator = graph.get(i).iterator();

			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");

			System.out.println();
			System.out.println();
		}
	}

	// Searches for a given edge in the graph
	public void searchEdge(int source, int destination) {
		if (graph.get(source).contains(destination))
			System.out.println("Edge from " + source + " to " + destination + " found");
		else
			System.out.println("Edge from " + source + " to " + destination + " not found");

		System.out.println();
	}

	// Driver code
	public static void main(String[] args) {

		// Create the graph given in the above figure
		GraphRepresentationUsingMap graph = new GraphRepresentationUsingMap(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// Print the adjacency list representation of
		// the above graph
		graph.printGraph();

		// Search the given edge in the graph
		graph.searchEdge(2, 1);
		graph.searchEdge(0, 3);
	}

}