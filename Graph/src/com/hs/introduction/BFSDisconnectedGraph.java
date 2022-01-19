package com.hs.introduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSDisconnectedGraph {

	// Implementing graph using HashMap
	private Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

	// utility function to add edge in an undirected graph
	private void addEdge(int source, int destination) {
		if (graph.containsKey(source)) {
			LinkedList<Integer> list = graph.get(source);
			list.add(destination);
			graph.put(source, list);
		} else {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(destination);
			graph.put(source, list);
		}
	}

	// BFS function to check each node
	private void bfs(int noOfVertices) {
		List<Boolean> visited = new ArrayList<Boolean>();
		// Marking each node as unvisited
		for (int i = 0; i < noOfVertices; i++) {
			visited.add(i, false);
		}
		for (int i = 0; i < noOfVertices; i++) {
			// Checking whether the node is visited or not
			if (!visited.get(i)) {
				bfsUtil(i, visited);
			}
		}
	}

	// Helper function for BFS
	private void bfsUtil(int noOfVertices, List<Boolean> visited) {
		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		queue.add(noOfVertices);
		visited.set(noOfVertices, true);

		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue and print it
			int vertex = queue.poll();
			System.out.print(vertex + " ");

			// Check whether the current node is connected to any other node or not
			if (graph.containsKey(vertex)) {
				Iterator<Integer> iterator = graph.get(vertex).listIterator();

				// Get all adjacent vertices of the dequeued vertex
				// if an adjacent has not been visited, then mark it visited and enqueue it

				while (iterator.hasNext()) {
					int currentAdjNode = iterator.next();
					if (!visited.get(currentAdjNode)) {
						visited.set(currentAdjNode, true);
						queue.add(currentAdjNode);
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		BFSDisconnectedGraph graph = new BFSDisconnectedGraph();
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.bfs(5);
	}

}