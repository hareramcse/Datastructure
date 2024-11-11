package com.hs.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KrushkalAlgorithm {

	public int kruskalMST(int V, int E, int[][] edges) {
		List<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			Edge edge = new Edge(edges[i][0], edges[i][1], edges[i][2]);
			edgeList.add(edge);
		}

		// add all the edges to priority queue
		Queue<Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
		DisjointSet ds = new DisjointSet(V);
		int mstWeight = 0;
		pq.addAll(edgeList);

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int u = edge.source;
			int v = edge.destination;
			int w = edge.weight;

			if (ds.findUPar(u) != ds.findUPar(v)) {
				mstWeight += w;
				ds.unionBySize(u, v);
			}
		}

		return mstWeight;
	}

	public static void main(String[] args) {
		KrushkalAlgorithm graph = new KrushkalAlgorithm();
		int[][] edges = { { 0, 1, 4 }, { 0, 7, 8 }, { 1, 2, 8 }, { 1, 7, 11 }, { 2, 3, 7 }, { 2, 8, 2 }, { 2, 5, 4 },
				{ 3, 4, 9 }, { 3, 5, 14 }, { 4, 5, 10 }, { 5, 6, 2 }, { 6, 7, 1 }, { 6, 8, 6 }, { 7, 8, 7 } };
		int V = edges.length;
		int E = edges[0].length;
		int mstWeight = graph.kruskalMST(V, E, edges);
		System.out.println(mstWeight);
	}
}