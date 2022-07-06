package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class FindMotherVertex {
	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	FindMotherVertex(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	private int findMotherVertex() {
		boolean visited[] = new boolean[noOfVertices];
		int lastIndex = 0;

		// Do a DFS traversal and find the last finished vertex
		for (int i = 0; i < noOfVertices; i++) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
				lastIndex = i;
			}
		}

		for (int i = 0; i < noOfVertices; i++) {
			visited[i] = false;
		}

		DFSUtil(lastIndex, visited);

		for (int i = 0; i < noOfVertices; i++) {
			if (visited[i] == false) {
				return -1;
			}
		}
		return lastIndex;
	}

	private void DFSUtil(int source, boolean visited[]) {
		visited[source] = true;
		for (int adjNode : adj[source]) {
			if (!visited[adjNode])
				DFSUtil(adjNode, visited);
		}
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
		System.out.println(graph.findMotherVertex());
	}
}