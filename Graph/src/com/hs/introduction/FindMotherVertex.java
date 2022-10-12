package com.hs.introduction;

import java.util.ArrayList;
import java.util.List;

public class FindMotherVertex {
	private List<List<Integer>> adjList;

	private FindMotherVertex(int noOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// A utility function to add an edge in an undirected graph
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
	}

	private int findMotherVertex(List<List<Integer>> adjList) {
		boolean visited[] = new boolean[adjList.size()];
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
		FindMotherVertex graph = new FindMotherVertex(7);
		List<List<Integer>> adjList = graph.adjList;
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 2);
		graph.addEdge(adjList, 1, 3);
		graph.addEdge(adjList, 4, 1);
		graph.addEdge(adjList, 6, 4);
		graph.addEdge(adjList, 5, 6);
		graph.addEdge(adjList, 5, 2);
		graph.addEdge(adjList, 6, 0);
		System.out.println(graph.findMotherVertex(adjList));
	}
}