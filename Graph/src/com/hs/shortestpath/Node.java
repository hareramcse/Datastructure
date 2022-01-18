package com.hs.shortestpath;

public class Node {
	public int src, dest, distance;

	Node(int source, int destination, int dist) {
		this.src = source;
		this.dest = destination;
		this.distance = dist;
	}
}
