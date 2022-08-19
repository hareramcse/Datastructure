package com.hs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CountFriendCircle {
	private int noOfVertices;
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	CountFriendCircle(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int detination) {
		adj[source].add(detination);
	}

	private int countTrees(Queue<Integer>[] adj, int noOfVertices) {
		boolean visited[] = new boolean[noOfVertices];
		int ans = 0;

		for (int i = 0; i < noOfVertices; i++) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
				ans++;
			}
		}
		return ans;
	}

	private void DFSUtil(int source, boolean visited[]) {
		visited[source] = true;
		for (Integer adjNode : adj[source]) {
			if (!visited[adjNode]) {
				DFSUtil(adjNode, visited);
			}
		}
	}

	public static void main(String args[]) {
		CountFriendCircle graph = new CountFriendCircle(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(3, 4);
		System.out.println(graph.countTrees(graph.adj, graph.noOfVertices));
	}
}