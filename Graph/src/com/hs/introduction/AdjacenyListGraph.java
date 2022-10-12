package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

class AdjacenyListGraph {
	private List<List<Integer>> adjList;

	private AdjacenyListGraph(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
		adjList.get(destination).add(source);
	}

	// A utility function to print the adjacency list representation of graph
	private void printGraph(List<List<Integer>> adjList) {
		for (List<Integer> list : adjList) {
			System.out.println("Adjacency list of vertex " + list.get(0));
			System.out.print("head");
			for (Integer adjNode : list) {
				System.out.print(" -> " + adjNode);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AdjacenyListGraph graph = new AdjacenyListGraph(5);
		List<List<Integer>> adjList = graph.adjList;
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 4);
		graph.addEdge(adjList, 1, 2);
		graph.addEdge(adjList, 1, 3);
		graph.addEdge(adjList, 1, 4);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 4);
		graph.printGraph(adjList);
	}
}