package com.hs.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloyedWarshallAlgorithm {
	private int noOfVertices;
	// stores the shortest distance between [src][dst]
	private int distance[][];
	// stores the node next to src, used to construct path between [src][dst]
	private int next[][];
	private List<Edge> edges = new ArrayList<Edge>();

	FloyedWarshallAlgorithm(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		distance = new int[noOfVertices][noOfVertices];
		next = new int[noOfVertices][noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			Arrays.fill(distance[i], 999999999); // 999999999 indicates infinite distance
			Arrays.fill(next[i], -1);
		}
	}

	private void addEdge(int src, int dst, int weight, boolean isbidirectional) {
		Edge edge = new Edge(src, dst, weight);
		edges.add(edge);
		if (isbidirectional) {
			edge = new Edge(dst, src, weight);
			edges.add(edge);
		}
	}

	private void floyedWarshall() {
		for (int i = 0; i < noOfVertices; i++) {
			distance[i][i] = 0;
			next[i][i] = i;
		}
		for (Edge edge : edges) {
			int weight = edge.weight;
			int u = edge.source;
			int v = edge.destination;
			distance[u][v] = weight;
			next[u][v] = v;
		}

		for (int k = 0; k < noOfVertices; k++) {
			for (int i = 0; i < noOfVertices; i++) {
				for (int j = 0; j < noOfVertices; j++) {
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}

		System.out.println("Shortest distance between nodes");
		for (int i = 0; i < noOfVertices; i++) {
			for (int j = i + 1; j < noOfVertices; j++) {
				System.out.println("\nDistance between (" + i + "," + j + ") : " + distance[i][j]);
				pathConstruction(i, j);
			}
		}
	}

	// Construct path from source node to destination node
	private void pathConstruction(int src, int dst) {
		System.out.print("Path between (" + src + "," + dst + ") : ");
		if (next[src][dst] == -1) {
			System.out.println("No path exists");
		} else {
			List<Integer> path = new ArrayList<Integer>();
			path.add(src);
			while (src != dst) {
				src = next[src][dst];
				path.add(src);
			}
			for (int n : path)
				System.out.print(n + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		FloyedWarshallAlgorithm graph = new FloyedWarshallAlgorithm(5);
		graph.addEdge(0, 1, 9, true);
		graph.addEdge(0, 3, 2, true);
		graph.addEdge(0, 4, 3, true);
		graph.addEdge(1, 2, 3, true);
		graph.addEdge(1, 4, 7, true);
		// Edge from 2 -> 3 is unidirectional. If it was bidirectional, it would
		// introduce negative weight cycle
		// causing the Floyd-Warshall algorithm to fail.
		graph.addEdge(2, 3, -2, false);
		graph.addEdge(2, 4, 1, true);
		graph.addEdge(3, 4, 1, true);
		graph.floyedWarshall();
	}
}