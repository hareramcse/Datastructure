package com.hs.mst;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class PrimsAlgorithAdjacencyList {

	private int noOfVertices;
	private Queue<Pair> adj[];

	@SuppressWarnings("unchecked")
	PrimsAlgorithAdjacencyList(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i) {
			adj[i] = new LinkedList<Pair>();
		}
	}

	// class to represent a node in PriorityQueue
	// Stores a vertex and its corresponding
	// key value
	class Node {
		int vertex;
		int key;
	}

	// Comparator class created for PriorityQueue
	// returns 1 if node0.key > node1.key
	// returns 0 if node0.key < node1.key and
	// returns -1 otherwise
	class comparator implements Comparator<Node> {

		@Override
		public int compare(Node node0, Node node1) {
			return node0.key - node1.key;
		}
	}

	// method to add an edge between two vertices
	private void addEdge(int src, int dest, int weight) {
		Pair node0 = new Pair(dest, weight);
		Pair node = new Pair(src, weight);
		adj[src].add(node0);
		adj[dest].add(node);
	}

	// method used to find the mst
	private void primsMST() {

		// Whether a vertex is in PriorityQueue or not
		boolean[] mstSet = new boolean[noOfVertices];
		Node[] node = new Node[noOfVertices];

		// Stores the parents of a vertex
		int[] parent = new int[noOfVertices];

		for (int i = 0; i < noOfVertices; i++)
			node[i] = new Node();

		for (int i = 0; i < noOfVertices; i++) {

			// Initialize to false
			mstSet[i] = false;

			// Initialize key values to infinity
			node[i].key = Integer.MAX_VALUE;
			node[i].vertex = i;
			parent[i] = -1;
		}

		// Include the source vertex in mstset
		mstSet[0] = true;

		// Set key value to 0
		// so that it is extracted first
		// out of PriorityQueue
		node[0].key = 0;

		// Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n)
		// in java.
		TreeSet<Node> queue = new TreeSet<Node>(new comparator());

		for (int i = 0; i < noOfVertices; i++)
			queue.add(node[i]);

		// Loops until the queue is not empty
		while (!queue.isEmpty()) {

			// Extracts a node with min key value
			Node node0 = queue.pollFirst();

			// Include that node into mstset
			mstSet[node0.vertex] = true;

			// For all adjacent vertex of the extracted vertex V
			for (Pair iterator : adj[node0.vertex]) {

				// If V is in queue
				if (mstSet[iterator.dest] == false) {
					// If the key value of the adjacent vertex is
					// more than the extracted key
					// update the key value of adjacent vertex
					// to update first remove and add the updated vertex
					if (node[iterator.dest].key > iterator.weight) {
						queue.remove(node[iterator.dest]);
						node[iterator.dest].key = iterator.weight;
						queue.add(node[iterator.dest]);
						parent[iterator.dest] = node0.vertex;
					}
				}
			}
		}

		// Prints the vertex pair of mst
		for (int o = 1; o < noOfVertices; o++)
			System.out.println(parent[o] + " " + "-" + " " + o);
	}

	public static void main(String[] args) {
		PrimsAlgorithAdjacencyList graph = new PrimsAlgorithAdjacencyList(9);

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);

		// Method invoked
		graph.primsMST();
	}

}