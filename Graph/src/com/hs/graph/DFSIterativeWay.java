package com.hs.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSIterativeWay {
	int noOfVertices;
	LinkedList<Integer> adj[];
	boolean visited[];

	DFSIterativeWay(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		visited = new boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].addFirst(destination);
	}

	// prints all not yet visited vertices reachable from s
	void DFSUtil(int source, boolean visited[]) {
		// Create a stack for DFS
		Stack<Integer> stack = new Stack<>();

		// Push the current source node
		stack.push(source);

		while (stack.empty() == false) {
			// Pop a vertex from stack and print it
			source = stack.peek();
			stack.pop();

			// Stack may contain same vertex twice. So
			// we need to print the popped item only
			// if it is not visited.
			if (visited[source] == false) {
				visited[source] = true;
				System.out.print(source + " ");
			}

			// Get all adjacent vertices of the popped vertex s
			// If a adjacent has not been visited, then puah it
			// to the stack.
			Iterator<Integer> iterator = adj[source].iterator();

			while (iterator.hasNext()) {
				int value = iterator.next();
				if (!visited[value]) {
					stack.push(value);
				}
			}
		}
	}

	// prints all vertices in DFS manner
	void DFS() {
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i]) {
				DFSUtil(i, visited);
			}
		}
	}

	public static void main(String[] args) {
		int noOfVertices = 5;
		DFSIterativeWay graph = new DFSIterativeWay(noOfVertices);
		graph.addEdge(1, 0);
		graph.addEdge(2, 1);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);

		graph.DFS();
	}
}