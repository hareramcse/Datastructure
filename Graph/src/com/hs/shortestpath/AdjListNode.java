package com.hs.shortestpath;

public class AdjListNode {
	public int vertex, weight;

	AdjListNode(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	int getVertex() {
		return vertex;
	}

	int getWeight() {
		return weight;
	}
}
