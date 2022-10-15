package com.hs.shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUnweightedGraph {

	// function to form edge between two vertices source and dest
	private void addEdge(List<List<Integer>> adjList, int source, int destination) {
		adjList.get(source).add(destination);
		adjList.get(destination).add(source);
	}

	// print the shortest distance and path between source and destination
	private void printShortestDistance(int V, int source, int destination, List<List<Integer>> adjList) {
		// predecessor[i] array stores predecessor of i
		// distance array stores distance of i from s
		int pred[] = new int[V];
		int dist[] = new int[V];

		if (BFS(V, source, destination, pred, dist, adjList) == false) {
			System.out.println("Given source and destination are not connected");
			return;
		}

		List<Integer> path = new ArrayList<>();
		int crawl = destination;
		path.add(crawl);
		while (pred[crawl] != -1) {
			path.add(pred[crawl]);
			crawl = pred[crawl];
		}

		// Print distance
		System.out.println("Shortest path length is: " + dist[destination]);

		// Print path
		System.out.println("Path is: ");
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
	}

	// a modified version of BFS that stores predecessor of each vertex in array
	// pred and its distance from source in array dist
	private boolean BFS(int V, int src, int dest, int pred[], int dist[], List<List<Integer>> adjList) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}

		// now source is first to be visited and
		// distance from source to itself should be 0
		visited[src] = true;
		dist[src] = 0;
		queue.add(src);

		// bfs Algorithm
		while (!queue.isEmpty()) {
			int u = queue.remove();
			for (Integer node : adjList.get(u)) {
				if (visited[node] == false) {
					visited[node] = true;
					dist[node] = dist[u] + 1;
					pred[node] = u;
					queue.add(node);

					// stopping condition when we find our destination
					if (node == dest)
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		ShortestPathInUnweightedGraph graph = new ShortestPathInUnweightedGraph();
		List<List<Integer>> adjList = new ArrayList<>();
		int V = 8;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		graph.addEdge(adjList, 0, 1);
		graph.addEdge(adjList, 0, 3);
		graph.addEdge(adjList, 1, 2);
		graph.addEdge(adjList, 3, 4);
		graph.addEdge(adjList, 3, 7);
		graph.addEdge(adjList, 4, 5);
		graph.addEdge(adjList, 4, 6);
		graph.addEdge(adjList, 4, 7);
		graph.addEdge(adjList, 5, 6);
		graph.addEdge(adjList, 6, 7);
		int source = 0, dest = 7;
		graph.printShortestDistance(V, source, dest, adjList);
	}
}