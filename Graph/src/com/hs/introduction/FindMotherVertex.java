package com.hs.introduction;

import java.util.Iterator;
import java.util.LinkedList;

public class FindMotherVertex {

	int noOfVertices;
	LinkedList<Integer> adj[];
	boolean visited[];

	FindMotherVertex(int noOfVertices) {
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

	public void DFSUtil(int source, boolean visited[]) {
		visited[source] = true;
		Iterator<Integer> iterator = adj[source].listIterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			if (!visited[value])
				DFSUtil(value, visited);
		}
	}

	public int findMother() {
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
		FindMotherVertex g = new FindMotherVertex(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(4, 1);
		g.addEdge(6, 4);
		g.addEdge(5, 6);
		g.addEdge(5, 2);
		g.addEdge(6, 0);

		System.out.println(g.findMother());
	}
}
