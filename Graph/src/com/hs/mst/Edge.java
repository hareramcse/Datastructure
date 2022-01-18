package com.hs.mst;

public class Edge implements Comparable<Edge> {
	public int src, dest, weight;

	// Comparator function used for sorting edges based on their weight
	public int compareTo(Edge compareEdge) {
		return this.weight - compareEdge.weight;
	}
}
