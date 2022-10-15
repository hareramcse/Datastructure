package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

public class FindMotherVertex {

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	private int findMotherVertex(int V, List<List<Integer>> adjList) {
		boolean visited[] = new boolean[V];
		int lastIndex = 0;

		// Do a DFS traversal and find the last finished vertex
		for (int i = 0; i < adjList.size(); i++) {
			if (visited[i] == false) {
				DFSUtil(i, visited, adjList);
				lastIndex = i;
			}
		}

		for (int i = 0; i < adjList.size(); i++) {
			visited[i] = false;
		}

		DFSUtil(lastIndex, visited, adjList);

		for (int i = 0; i < adjList.size(); i++) {
			if (visited[i] == false) {
				return -1;
			}
		}
		return lastIndex;
	}

	private void DFSUtil(int source, boolean visited[], List<List<Integer>> adjList) {
		visited[source] = true;
		for (int adjNode : adjList.get(source)) {
			if (!visited[adjNode])
				DFSUtil(adjNode, visited, adjList);
		}
	}

	public static void main(String[] args) {
		FindMotherVertex graph = new FindMotherVertex();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 7;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 1, 3);
		graph.addEdge(adjList, 4, 1);
		graph.addEdge(adjList, 6, 4);
		graph.addEdge(adjList, 5, 6);
		graph.addEdge(adjList, 5, 2);
		graph.addEdge(adjList, 6, 0);
		System.out.println(graph.findMotherVertex(V, adjList));
	}
}