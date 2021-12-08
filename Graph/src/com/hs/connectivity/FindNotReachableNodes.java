package com.hs.connectivity;

import java.util.ArrayList;

public class FindNotReachableNodes {

	// No. of vertices
	public int V;

	// Pointer to an array containing
	// adjacency lists
	public ArrayList[] adj;

	public FindNotReachableNodes(int V)
	{
		this.V = V;
		adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
		{
			adj[i] = new ArrayList();
		}
	}

	void addEdge(int v, int w) {

		// add w to v’s list.
		adj[v].add(w);

		// add v to w's list.
		adj[w].add(v);
	}

	void DFSUtil(int v, boolean[] visited) {

		// Mark the current node as visited and
		// print it
		visited[v] = true;

		// Recur for all the vertices adjacent
		// to this vertex
		for (int i : (ArrayList<Integer>) adj[v]) {
			if (!visited[i])
				DFSUtil(i, visited);
		}
	}

	// Returns count of not reachable nodes from
	// vertex v.
	// It uses recursive DFSUtil()
	int countNotReach(int v) {

		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Call the recursive helper function
		// to print DFS traversal
		DFSUtil(v, visited);

		// Return count of not visited nodes
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				count++;
		}
		return count;
	}

	// Driver Code
	public static void main(String[] args) {

		// Create a graph given in the above diagram
		FindNotReachableNodes g = new FindNotReachableNodes(8);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(6, 7);

		System.out.print(g.countNotReach(2));
	}

}