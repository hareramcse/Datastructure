package com.hs.introduction;

import java.util.Iterator;
import java.util.LinkedList;

public class FindMotherVertex {

	private int noOfVertices;
	private LinkedList<Integer> adj[];
	boolean visited[];

	@SuppressWarnings("unchecked")
	FindMotherVertex(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		visited = new boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int destination) {
		adj[source].addFirst(destination);
	}

	private void DFSUtil(int source, boolean visited[]) {
		visited[source] = true;
		Iterator<Integer> iterator = adj[source].listIterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			if (!visited[value])
				DFSUtil(value, visited);
		}
	}

	private int findMother() {
		int index = 0;

		// Do a DFS traversal and find the last finished vertex
		for (int i = 0; i < noOfVertices; i++) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
				index = i;
			}
		}

		for (int i = 0; i < noOfVertices; i++) {
			visited[i] = false;
		}

		DFSUtil(index, visited);

		for (int i = 0; i < noOfVertices; i++) {
			if (visited[i] == false) {
				return -1;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		FindMotherVertex graph = new FindMotherVertex(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(4, 1);
		graph.addEdge(6, 4);
		graph.addEdge(5, 6);
		graph.addEdge(5, 2);
		graph.addEdge(6, 0);

		System.out.println(graph.findMother());
	}
}
