package com.hs.graph.shortestpath;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import com.hs.leetcode.medium.Node;

public class DijkstrasShortestPath {

	private void dijkstra(int V, int src, int[][] graph) {
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);

		// Distance of source vertex from itself is always 0
		distance[src] = 0;

		boolean[] visited = new boolean[V];

		Queue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
		pq.add(new Node(src, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int u = current.destination;
			int w = current.weight;

			if (visited[u])
				continue;

			visited[u] = true;

			// For each neighbor of the current node (u)
			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && w + graph[u][v] < distance[v]) {
					// Relax the edge if a shorter path is found
					distance[v] = w + graph[u][v];
					pq.add(new Node(v, distance[v]));
				}
			}
		}
		printSolution(distance);
	}

	private void printSolution(int dist[]) {
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		DijkstrasShortestPath dij = new DijkstrasShortestPath();
		int V = matrix.length;
		int source = 0;
		dij.dijkstra(V, source, matrix);
	}
}