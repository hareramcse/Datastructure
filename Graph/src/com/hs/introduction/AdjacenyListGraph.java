package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

class AdjacenyListGraph {
	private int noOfVertices;
	private List<ArrayList<Integer>> adj;

	private AdjacenyListGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new ArrayList<ArrayList<Integer>>(noOfVertices);

		for (int i = 0; i < noOfVertices; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<ArrayList<Integer>> edge, int source, int destination) {
		edge.get(source).add(destination);
		edge.get(destination).add(source);
	}

	// A utility function to print the adjacency list representation of graph
	private void printGraph(List<ArrayList<Integer>> adj) {
		for (int i = 0; i < noOfVertices; i++) {
			System.out.println("Adjacency list of vertex " + i);
			System.out.print("head");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AdjacenyListGraph graph = new AdjacenyListGraph(5);
		List<ArrayList<Integer>> edge = graph.adj;
		graph.addEdge(edge, 0, 1);
		graph.addEdge(edge, 0, 4);
		graph.addEdge(edge, 1, 2);
		graph.addEdge(edge, 1, 3);
		graph.addEdge(edge, 1, 4);
		graph.addEdge(edge, 2, 3);
		graph.addEdge(edge, 3, 4);

		graph.printGraph(edge);
	}
}
