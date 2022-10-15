package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class AllTopologicalSortOfDirectedAcyclicGraph {

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	public void allTopologicalSorts(int V, List<List<Integer>> adjList) {
		boolean[] visited = new boolean[V];
		int[] indegree = new int[V];
		for (int i = 0; i < V; i++) {
			for (int j : adjList.get(i)) {
				indegree[j]++;
			}
		}

		List<Integer> result = new ArrayList<>();
		allTopologicalSortsUtil(V, visited, indegree, adjList, result);
	}

	private void allTopologicalSortsUtil(int V, boolean[] visited, int[] indegree, List<List<Integer>> adjList,
			List<Integer> result) {
		// To indicate whether all topological are found or not
		boolean flag = false;
		for (int i = 0; i < V; i++) {
			if (!visited[i] && indegree[i] == 0) {
				visited[i] = true;
				result.add(i);
				for (int adjNode : adjList.get(i)) {
					indegree[adjNode]--;
				}
				allTopologicalSortsUtil(V, visited, indegree, adjList, result);

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
		AllTopologicalSortOfDirectedAcyclicGraph graph = new AllTopologicalSortOfDirectedAcyclicGraph();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 6;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 5, 2);
		graph.addEdge(adjList, 5, 0);
		graph.addEdge(adjList, 4, 0);
		graph.addEdge(adjList, 4, 1);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 1);
		System.out.println("All Topological sorts");
		graph.allTopologicalSorts(V, adjList);
	}
}