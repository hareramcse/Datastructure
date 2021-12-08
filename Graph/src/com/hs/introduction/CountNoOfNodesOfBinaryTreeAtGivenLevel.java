package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class CountNoOfNodesOfBinaryTreeAtGivenLevel {

	// No. of vertices
	int V;

	// Pointer to an
	// array containing
	// adjacency lists
	Vector<Integer>[] adj;

	// Constructor
	@SuppressWarnings("unchecked")
	CountNoOfNodesOfBinaryTreeAtGivenLevel(int V) {
		adj = new Vector[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new Vector<>();
		}
		this.V = V;
	}

	void addEdge(int v, int w) {

		// Add w to v’s list.
		adj[v].add(w);

		// Add v to w's list.
		adj[w].add(v);
	}

	int BFS(int s, int l) {

		// Mark all the vertices
		// as not visited
		boolean[] visited = new boolean[V];
		int[] level = new int[V];

		for (int i = 0; i < V; i++) {
			visited[i] = false;
			level[i] = 0;
		}

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<>();

		// Mark the current node as
		// visited and enqueue it
		visited[s] = true;
		queue.add(s);
		level[s] = 0;
		int count = 0;
		while (!queue.isEmpty()) {

			// Dequeue a vertex from
			// queue and print it
			s = queue.peek();
			queue.poll();

			Vector<Integer> list = adj[s];
			// Get all adjacent vertices
			// of the dequeued vertex s.
			// If a adjacent has not been
			// visited, then mark it
			// visited and enqueue it
			for (int i : list) {
				if (!visited[i]) {
					visited[i] = true;
					level[i] = level[s] + 1;
					queue.add(i);
				}
			}

			count = 0;
			for (int i = 0; i < V; i++)
				if (level[i] == l)
					count++;
		}
		return count;
	}

	public static void main(String[] args) {

		// Create a graph given
		// in the above diagram
		CountNoOfNodesOfBinaryTreeAtGivenLevel g = new CountNoOfNodesOfBinaryTreeAtGivenLevel(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		int level = 2;
		System.out.print(g.BFS(0, level));
	}

}