package com.hs.cycle;

import java.util.Arrays;

public class DetectNegativeCycleBelmanFord {
	// A structure to represent a connected, directed and weighted graph
	private int noOfVertices, noOfEdges;
	private Edge edge[];

	// Creates a graph with noOfVertices vertices and noOfEdges edges
	DetectNegativeCycleBelmanFord(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		edge = new Edge[noOfEdges];

		for (int i = 0; i < noOfEdges; i++) {
			edge[i] = new Edge();
		}
	}

	// The main function that finds shortest distances from src to all other
	// vertices using Bellman-Ford algorithm. The function also detects negative
	// weight cycle
	private boolean isNegCycleBellmanFord(int src, int dist[]) {
		int V = noOfVertices;
		int E = noOfEdges;

		// Step 1: Initialize distances from src to all other vertices as INFINITE
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;

		// Step 2: Relax all edges |V| - 1 times.
		// A simple shortest path from src to any
		// other vertex can have at-most |V| - 1 edges
		for (int i = 1; i <= V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = edge[j].src;
				int v = edge[j].dest;
				int weight = edge[j].weight;

				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}

		// Step 3: check for negative-weight cycles.
		// The above step guarantees shortest distances
		// if graph doesn't contain negative weight cycle.
		// If we get a shorter path, then there is a cycle.
		for (int i = 0; i < E; i++) {
			int u = edge[i].src;
			int v = edge[i].dest;
			int weight = edge[i].weight;

			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
				return true;
		}

		return false;
	}

	// Returns true if given graph has negative weight cycle.
	private boolean isNegCycleDisconnected() {
		int V = noOfVertices;

		// To keep track of visited vertices to avoid recomputations.
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);

		// This array is filled by Bellman-Ford
		int dist[] = new int[V];

		// Call Bellman-Ford for all those vertices that are not visited
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {

				// If cycle found
				if (isNegCycleBellmanFord(i, dist))
					return true;

				// Mark all vertices that are visited in above call.
				for (int j = 0; j < V; j++)
					if (dist[j] != Integer.MAX_VALUE)
						visited[j] = true;
			}
		}
		return false;
	}

	// Driver Code
	public static void main(String[] args) {
		DetectNegativeCycleBelmanFord graph = new DetectNegativeCycleBelmanFord(5, 8);

		// Add edge 0-1 (or A-B in above figure)
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// Add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// Add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// Add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// Add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// Add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// Add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// Add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		if (graph.isNegCycleDisconnected())
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}