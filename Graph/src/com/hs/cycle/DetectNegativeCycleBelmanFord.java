package com.hs.cycle;

public class DetectNegativeCycleBelmanFord {
	// A structure to represent a connected, directed and weighted graph
	private int noOfVertices, noOfEdges;
	private Edge edge[];
	private int[] distance;

	// Creates a graph with noOfVertices vertices and noOfEdges edges
	DetectNegativeCycleBelmanFord(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		edge = new Edge[noOfEdges];
		distance = new int[noOfVertices];
		for (int i = 0; i < noOfEdges; i++) {
			edge[i] = new Edge();
		}
		// Step 1: Initialize distances from src to all other vertices as INFINITE
		for (int i = 0; i < noOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
	}

	// Returns true if given graph has negative weight cycle.
	private boolean hasNegativeWeightCycle() {

		// To keep track of visited vertices to avoid recomputations.
		boolean visited[] = new boolean[noOfVertices];

		// Call Bellman-Ford for all those vertices that are not visited
		for (int i = 0; i < noOfVertices; i++) {
			if (visited[i] == false) {

				// If cycle found
				if (isNegCycleBellmanFord(i))
					return true;

				// Mark all vertices that are visited in above call.
				for (int j = 0; j < noOfVertices; j++)
					if (distance[j] != Integer.MAX_VALUE)
						visited[j] = true;
			}
		}
		return false;
	}

	//The function also detects negative weight cycle
	private boolean isNegCycleBellmanFord(int src) {
		distance[src] = 0;

		// Step 2: Relax all edges |V| - 1 times.
		// shortest path from src to any other vertex can have at-most |V| - 1 edges
		for (int i = 1; i <= noOfVertices - 1; i++) {
			for (int j = 0; j < noOfEdges; j++) {
				int source = edge[j].source;
				int destination = edge[j].destination;
				int weight = edge[j].weight;

				if (distance[source] != Integer.MAX_VALUE && distance[source] + weight < distance[destination])
					distance[destination] = distance[source] + weight;
			}
		}

		// Step 3: check for negative-weight cycles.
		// The above step guarantees shortest distances
		// if graph doesn't contain negative weight cycle.
		// If we get a shorter path, then there is a cycle.
		for (int i = 0; i < noOfEdges; i++) {
			int source = edge[i].source;
			int destination = edge[i].destination;
			int weight = edge[i].weight;

			if (distance[source] != Integer.MAX_VALUE && distance[source] + weight < distance[destination])
				return true;
		}

		return false;
	}

	// Driver Code
	public static void main(String[] args) {
		DetectNegativeCycleBelmanFord graph = new DetectNegativeCycleBelmanFord(5, 8);

		// Add edge 0-1 (or A-B in above figure)
		graph.edge[0].source = 0;
		graph.edge[0].destination = 1;
		graph.edge[0].weight = -1;

		// Add edge 0-2 (or A-C in above figure)
		graph.edge[1].source = 0;
		graph.edge[1].destination = 2;
		graph.edge[1].weight = 4;

		// Add edge 1-2 (or B-C in above figure)
		graph.edge[2].source = 1;
		graph.edge[2].destination = 2;
		graph.edge[2].weight = 3;

		// Add edge 1-3 (or B-D in above figure)
		graph.edge[3].source = 1;
		graph.edge[3].destination = 3;
		graph.edge[3].weight = 2;

		// Add edge 1-4 (or A-E in above figure)
		graph.edge[4].source = 1;
		graph.edge[4].destination = 4;
		graph.edge[4].weight = 2;

		// Add edge 3-2 (or D-C in above figure)
		graph.edge[5].source = 3;
		graph.edge[5].destination = 2;
		graph.edge[5].weight = 5;

		// Add edge 3-1 (or D-B in above figure)
		graph.edge[6].source = 3;
		graph.edge[6].destination = 1;
		graph.edge[6].weight = 1;

		// Add edge 4-3 (or E-D in above figure)
		graph.edge[7].source = 4;
		graph.edge[7].destination = 3;
		graph.edge[7].weight = -3;

		if (graph.hasNegativeWeightCycle())
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}