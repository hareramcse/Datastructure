package com.hs.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSTraversal {
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	DFSTraversal(int noOfVertices) {
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(Queue<Integer>[] adj, int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	private List<Integer> dfsTraversl(Queue<Integer>[] adj, int noOfVertices, int source) {
		List<Integer> ans = new ArrayList<>();
		boolean visited[] = new boolean[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i]) {
				// Call the recursive helper function to print DFS traversal
				DFS(i, visited, ans);
			}
		}
		return ans;
	}

	private void DFS(int source, boolean visited[], List<Integer> ans) {
		// Mark the current node as visited and print it
		visited[source] = true;
		ans.add(source);

		// Recur for all the vertices adjacent to this vertex
		for (int adjNode : adj[source]) {
			if (!visited[adjNode])
				DFS(adjNode, visited, ans);
		}
	}

	public static void main(String args[]) {
		int noOfVertices = 4;
		DFSTraversal graph = new DFSTraversal(noOfVertices);
		Queue<Integer>[] adj = graph.adj;
		graph.addEdge(adj, 0, 1);
		graph.addEdge(adj, 0, 2);
		graph.addEdge(adj, 1, 2);
		graph.addEdge(adj, 2, 0);
		graph.addEdge(adj, 2, 3);
		graph.addEdge(adj, 3, 3);
		System.out.println("Following is Depth First Traversal starting from vertex 2");
		List<Integer> result = graph.dfsTraversl(adj, noOfVertices, 2);
		System.out.println(result);
	}
}