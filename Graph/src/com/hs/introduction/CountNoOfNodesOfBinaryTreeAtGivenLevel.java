package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class CountNoOfNodesOfBinaryTreeAtGivenLevel {

	private int noOfVertices;
	private Queue<Integer> adj[];
	boolean[] visited;

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

	private int BFS(int start, int givenLevel) {

		// Mark all the vertices as not visited
		boolean[] visited = new boolean[noOfVertices];
		int[] level = new int[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			visited[i] = false;
			level[i] = 0;
		}

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		visited[start] = true;
		queue.add(start);
		level[start] = 0;
		int count = 0;
		while (!queue.isEmpty()) {

			// Dequeue a vertex from queue and print it
			start = queue.peek();
			queue.poll();

			Queue<Integer> list = adj[start];
			// Get all adjacent vertices of the dequeued vertex start.
			// If a adjacent has not been visited, then mark it visited and enqueue it
			for (int i : list) {
				if (!visited[i]) {
					visited[i] = true;
					level[i] = level[start] + 1;
					queue.add(i);
				}
			}

			count = 0;
			for (int i = 0; i < noOfVertices; i++)
				if (level[i] == givenLevel)
					count++;
		}
		return count;
	}

	public static void main(String[] args) {
		CountNoOfNodesOfBinaryTreeAtGivenLevel graph = new CountNoOfNodesOfBinaryTreeAtGivenLevel(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		int level = 2;
		System.out.print(graph.BFS(0, level));
	}

}