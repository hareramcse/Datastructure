package com.hs.shortestpath;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPathInDirectedACyclicGraph {

	private int INF = Integer.MAX_VALUE;

	private int noOfVertices;
	private LinkedList<AdjListNode> adj[];

	@SuppressWarnings("unchecked")
	ShortestPathInDirectedACyclicGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i) {
			adj[i] = new LinkedList<AdjListNode>();
		}
	}

	private void addEdge(int source, int destination, int weight) {
		AdjListNode node = new AdjListNode(destination, weight);
		adj[source].add(node);// Add v to u's list
	}

	// The function to find shortest paths from given vertex. It
	// uses recursive topologicalSortUtil() to get topological
	// sorting of given graph.
	private void shortestPath(int source) {
		Stack<Integer> stack = new Stack<>();
		int dist[] = new int[noOfVertices];

		// Mark all the vertices as not visited
		Boolean visited[] = new Boolean[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			visited[i] = false;

		// Call the recursive helper function to store Topological
		// Sort starting from all vertices one by one
		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);

		// Initialize distances to all vertices as infinite and
		// distance to source as 0
		for (int i = 0; i < noOfVertices; i++)
			dist[i] = INF;
		dist[source] = 0;

		// Process vertices in topological order
		while (stack.empty() == false) {
			// Get the next vertex from topological order
			int u = (int) stack.pop();

			// Update distances of all adjacent vertices
			Iterator<AdjListNode> it;
			if (dist[u] != INF) {
				it = adj[u].iterator();
				while (it.hasNext()) {
					AdjListNode i = it.next();
					if (dist[i.vertex] > dist[u] + i.getWeight())
						dist[i.vertex] = dist[u] + i.getWeight();
				}
			}
		}

		// Print the calculated shortest distances
		for (int i = 0; i < noOfVertices; i++) {
			if (dist[i] == INF)
				System.out.print("INF ");
			else
				System.out.print(dist[i] + " ");
		}
	}

	private void topologicalSortUtil(int source, Boolean visited[], Stack<Integer> stack) {
		// Mark the current node as visited.
		visited[source] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<AdjListNode> it = adj[source].iterator();
		while (it.hasNext()) {
			AdjListNode node = it.next();
			if (!visited[node.vertex])
				topologicalSortUtil(node.vertex, visited, stack);
		}
		// Push current vertex to stack which stores result
		stack.push(source);
	}

	public static void main(String args[]) {
		ShortestPathInDirectedACyclicGraph graph = new ShortestPathInDirectedACyclicGraph(6);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, 2);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, -1);
		graph.addEdge(4, 5, -2);

		int source = 1;
		System.out.println("Following are shortest distances from source " + source);
		graph.shortestPath(source);
	}

}