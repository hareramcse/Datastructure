package com.hs.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AllTopologicalSortOfDirectedAcyclicGraph {

	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	public AllTopologicalSortOfDirectedAcyclicGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// Utility function to add edge
	public void addEdge(int src, int dest) {
		adj[src].add(dest);
	}

	// The function does all Topological Sort.It uses recursive
	// alltopologicalSortUtil()
	public void allTopologicalSorts() {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[noOfVertices];

		int[] inDegree = new int[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			for (int var : adj[i]) {
				inDegree[var]++;
			}
		}

		ArrayList<Integer> stack = new ArrayList<>();
		allTopologicalSortsUtil(visited, inDegree, stack);
	}

	// Main recursive function to print all possible topological sorts
	private void allTopologicalSortsUtil(boolean[] visited, int[] inDegree, ArrayList<Integer> stack) {
		// To indicate whether all topological are found or not
		boolean flag = false;

		for (int i = 0; i < noOfVertices; i++) {
			// If indegree is 0 and not yet visited then only choose that vertex
			if (!visited[i] && inDegree[i] == 0) {

				// including in result
				visited[i] = true;
				stack.add(i);
				for (int adjacent : adj[i]) {
					inDegree[adjacent]--;
				}
				allTopologicalSortsUtil(visited, inDegree, stack);

				// resetting visited, res and indegree for backtracking
				visited[i] = false;
				stack.remove(stack.size() - 1);
				for (int adjacent : adj[i]) {
					inDegree[adjacent]++;
				}

				flag = true;
			}
		}
		// We reach here if all vertices are visited. So we print the solution here
		if (!flag) {
			stack.forEach(i -> System.out.print(i + " "));
			System.out.println();
		}

	}

	// Driver code
	public static void main(String[] args) {

		// Create a graph given in the above diagram
		AllTopologicalSortOfDirectedAcyclicGraph graph = new AllTopologicalSortOfDirectedAcyclicGraph(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		System.out.println("All Topological sorts");
		graph.allTopologicalSorts();
	}

}