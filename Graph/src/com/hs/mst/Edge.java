package com.hs.mst;

public class Edge implements Comparable<Edge> {
	public int source, destination, weight;

	public Edge() {

	}

	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	// Comparator function used for sorting edges based on their weight
	public int compareTo(Edge compareEdge) {
		return this.weight - compareEdge.weight;
	}
}
