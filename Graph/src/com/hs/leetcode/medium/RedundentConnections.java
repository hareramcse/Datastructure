package com.hs.leetcode.medium;

import java.util.Arrays;

import com.hs.graph.mst.DisjointSet;

public class RedundentConnections {
	public int[] findRedundantConnection(int[][] edges) {
		DisjointSet ds = new DisjointSet(edges.length);

		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

			// If u and v are already connected, adding this edge would form a cycle
			if (ds.connected(u, v)) {
				return edge;
			}

			// Otherwise, union the two nodes
			ds.unionByRank(u, v);
		}

		return new int[0];
	}

	public static void main(String[] args) {
		RedundentConnections obj = new RedundentConnections();
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		int[] result = obj.findRedundantConnection(edges);
		System.out.println(Arrays.toString(result));
	}
}
