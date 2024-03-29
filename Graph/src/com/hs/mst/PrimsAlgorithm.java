package com.hs.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgorithm {

	public int primsMST(int V, int E, int edges[][]) {
		List<List<Pair>> adjList = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int weight = edges[i][2];

			adjList.get(u).add(new Pair(v, weight));
			adjList.get(v).add(new Pair(u, weight));
		}

		Queue<Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
		pq.add(new Edge(0, 0, 0));
		int[] visited = new int[V];
		int minWeight = 0;

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.destination;
			int weight = edge.weight;

			if (visited[v] == 1)
				continue;

			minWeight += weight;
			visited[v] = 1;
			for (Pair it : adjList.get(v)) {
				if (visited[it.destination] == 0) {
					pq.add(new Edge(v, it.destination, it.weight));
				}
			}
		}
		return minWeight;
	}

	public static void main(String[] args) {
		PrimsAlgorithm graph = new PrimsAlgorithm();
		int[][] edges = { { 0, 1, 4 }, { 0, 7, 8 }, { 1, 2, 8 }, { 1, 7, 11 }, { 2, 3, 7 }, { 2, 8, 2 }, { 2, 5, 4 },
				{ 3, 4, 9 }, { 3, 5, 14 }, { 4, 5, 10 }, { 5, 6, 2 }, { 6, 7, 1 }, { 6, 8, 6 }, { 7, 8, 7 } };
		int V = edges.length;
		int E = edges[0].length;
		int mstWeight = graph.primsMST(V, E, edges);
		System.out.println(mstWeight);
	}
}