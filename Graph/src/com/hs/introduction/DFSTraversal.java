package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
		adjList.get(destination).add(source);
	}

	private List<Integer> dfsTraversl(int noOfVertices, int source, List<List<Integer>> adjList) {
		List<Integer> ans = new ArrayList<>();
		boolean[] visited = new boolean[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i]) {
				// Call the recursive helper function to print DFS traversal
				DFS(i, visited, adjList, ans);
			}
		}
		return ans;
	}

	private void DFS(int source, boolean[] visited, List<List<Integer>> adjList, List<Integer> ans) {
		// Mark the current node as visited and print it
		visited[source] = true;
		ans.add(source);

		// Recur for all the vertices adjacent to this vertex
		for (int adjNode : adjList.get(source)) {
			if (!visited[adjNode])
				DFS(adjNode, visited, adjList, ans);
		}
	}

	public static void main(String args[]) {
		DFSTraversal graph = new DFSTraversal();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 4;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 1, 2);
		graph.addEdge(adjList, 2, 0);
		graph.addEdge(adjList, 2, 3);
		graph.addEdge(adjList, 3, 3);
		System.out.println("Following is Depth First Traversal starting from vertex 2");
		List<Integer> result = graph.dfsTraversl(V, 0, adjList);
		System.out.println(result);
	}
}