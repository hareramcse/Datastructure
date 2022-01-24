package com.hs.shortestpath;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUnweightedGraph {

	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	ShortestPathInUnweightedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// function to form edge between two vertices source and dest
	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	// print the shortest distance and path between source and destination
	private void printShortestDistance(int source, int destination) {
		// predecessor[i] array stores predecessor of i 
		// distance array stores distance of i from s
		int pred[] = new int[noOfVertices];
		int dist[] = new int[noOfVertices];

		if (BFS(source, destination, pred, dist) == false) {
			System.out.println("Given source and destination are not connected");
			return;
		}

		// LinkedList to store path
		LinkedList<Integer> path = new LinkedList<Integer>();
		int crawl = destination;
		path.add(crawl);
		while (pred[crawl] != -1) {
			path.add(pred[crawl]);
			crawl = pred[crawl];
		}

		// Print distance
		System.out.println("Shortest path length is: " + dist[destination]);

		// Print path
		System.out.println("Path is ::");
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
	}

	// a modified version of BFS that stores predecessor of each vertex in array
	// pred and its distance from source in array dist
	private boolean BFS(int src, int dest, int pred[], int dist[]) {
		// a queue to maintain queue of vertices whose
		// adjacency list is to be scanned as per normal
		// BFS algorithm using LinkedList of Integer type
		Queue<Integer> queue = new LinkedList<Integer>();

		// boolean array visited[] which stores the
		// information whether ith vertex is reached
		// at least once in the Breadth first search
		boolean visited[] = new boolean[noOfVertices];

		// initially all vertices are unvisited
		// so v[i] for all i is false
		// and as no path is yet constructed
		// dist[i] for all i set to infinity
		for (int i = 0; i < noOfVertices; i++) {
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
			
			Iterator<Integer> it = adj[u].iterator();
			while(it.hasNext()) {
				Integer node = it.next();
				if (visited[node] == false) {
					visited[node] = true;
					dist[node] = dist[u] + 1;
					pred[node] = u;
					queue.add(node);

					// stopping condition (when we find our destination)
					if (node == dest)
						return true;
				}
			}
		}
		return false;
	}

	// Driver Program
	public static void main(String args[]) {
		ShortestPathInUnweightedGraph graph = new ShortestPathInUnweightedGraph(8);

		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(3, 7);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		int source = 0, dest = 7;
		graph.printShortestDistance(source, dest);
	}

}