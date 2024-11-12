package com.hs.leetcode.medium;

import com.hs.graph.mst.DisjointSet;

public class NumberOfOperationsToMakeNetworkConnected {
	public int makeConnected(int V, int[][] connections) {
		DisjointSet ds = new DisjointSet(V);
		int extraEdges = 0;
		int E = connections.length;

		for (int i = 0; i < E; i++) {
			int u = connections[i][0];
			int v = connections[i][1];
			if (ds.findUPar(u) == ds.findUPar(v)) {
				extraEdges++;
			} else {
				ds.unionBySize(u, v);
			}
		}

		int numberOfComponents = 0;
		for (int i = 0; i < V; i++) {
			if (ds.parent[i] == i)
				numberOfComponents++;
		}

		int ans = numberOfComponents - 1;
		if (extraEdges >= ans)
			return ans;
		return -1;
	}

	public static void main(String[] args) {
		NumberOfOperationsToMakeNetworkConnected obj = new NumberOfOperationsToMakeNetworkConnected();
		int V = 9;
		int[][] edge = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };
		int result = obj.makeConnected(V, edge);
		System.out.println(result);
	}
}