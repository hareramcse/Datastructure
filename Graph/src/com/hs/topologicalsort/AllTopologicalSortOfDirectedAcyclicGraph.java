package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class AllTopologicalSortOfDirectedAcyclicGraph {
	private List<List<Integer>> adjList;

	private AllTopologicalSortOfDirectedAcyclicGraph(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	public void allTopologicalSorts(List<List<Integer>> adjList, int noOfVertices) {
		boolean[] visited = new boolean[noOfVertices];
		int[] indegree = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			for (int j : adjList.get(i)) {
				indegree[j]++;
			}
		}

		List<Integer> result = new ArrayList<>();
		allTopologicalSortsUtil(visited, indegree, result, adjList, noOfVertices);
	}

	private void allTopologicalSortsUtil(boolean[] visited, int[] indegree, List<Integer> result,
			List<List<Integer>> adjList, int noOfVertices) {
		// To indicate whether all topological are found or not
		boolean flag = false;
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i] && indegree[i] == 0) {
				visited[i] = true;
				result.add(i);
				for (int adjacent : adjList.get(i)) {
					indegree[adjacent]--;
				}
				allTopologicalSortsUtil(visited, indegree, result, adjList, noOfVertices);

				// backtracks
				visited[i] = false;
				result.remove(result.size() - 1);
				for (int adjacent : adjList.get(i)) {
					indegree[adjacent]++;
				}

				flag = true;
			}
		}

		// We reach here if all vertices are visited. So we print the solution
		if (!flag) {
			result.forEach(i -> System.out.print(i + " "));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AllTopologicalSortOfDirectedAcyclicGraph graph = new AllTopologicalSortOfDirectedAcyclicGraph(6);
		List<List<Integer>> adjList = graph.adjList;
		graph.addEdge(adjList, 5, 2);
		graph.addEdge(adjList, 5, 0);
		graph.addEdge(adjList, 4, 0);
		graph.addEdge(adjList, 4, 1);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 1);
		System.out.println("All Topological sorts");
		graph.allTopologicalSorts(adjList, 6);
	}
}