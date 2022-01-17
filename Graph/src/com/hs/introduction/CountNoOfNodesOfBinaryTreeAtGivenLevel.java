package com.hs.introduction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CountNoOfNodesOfBinaryTreeAtGivenLevel {

	private int noOfVertices;
	private Queue<Integer> adj[];
	private boolean[] visited;

	@SuppressWarnings("unchecked")
	CountNoOfNodesOfBinaryTreeAtGivenLevel(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		visited = new boolean[noOfVertices];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	private void addEdge(int source, int destination) {
		// because graph is non directed graph so we need to add src to dest and
		// vice-versa
		adj[source].add(destination);
		adj[destination].add(source);
	}

	private int BFS(int source, int givenLevel) {
		int[] level = new int[noOfVertices];

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);
		
		level[source] = 0;
		while (!queue.isEmpty()) {

			// Dequeue a vertex from queue and print it
			source = queue.poll();

			Iterator<Integer> it = adj[source].iterator();
			// Get all adjacent vertices of the dequeued vertex source.
			// If a adjacent has not been visited, then mark it visited and enqueue it
			while (it.hasNext()) {
				Integer vertex = it.next();
				if (!visited[vertex]) {
					visited[vertex] = true;
					queue.add(vertex);
					level[vertex] = level[source] + 1;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < noOfVertices; i++)
			if (level[i] == givenLevel)
				count++;
		
		return count;
	}

	public static void main(String[] args) {
		CountNoOfNodesOfBinaryTreeAtGivenLevel graph = new CountNoOfNodesOfBinaryTreeAtGivenLevel(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(2, 6);
		int level = 2;
		System.out.print(graph.BFS(0, level));
	}

}