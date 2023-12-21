package com.hs.mst;

public class DisjointSet {
	public int[] rank;
	public int[] parent;
	public int[] size;

	public DisjointSet(int n) {
		rank = new int[n + 1];
		parent = new int[n + 1];
		size = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			rank[i] = 0;
			parent[i] = i;
			size[i] = 1;
		}
	}

	public int findUPar(int node) {
		if (node == parent[node])
			return node;

		return parent[node] = findUPar(parent[node]);
	}

	public void unionByRank(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v)
			return;

		if (rank[ulp_u] < rank[ulp_v]) {
			parent[ulp_u] = ulp_v;
		} else if (rank[ulp_v] < rank[ulp_u]) {
			parent[ulp_v] = ulp_u;
		} else {
			parent[ulp_v] = ulp_u;
			rank[ulp_u]++;
		}
	}

	public void unionBySize(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v)
			return;

		if (size[ulp_u] < size[ulp_v]) {
			parent[ulp_u] = ulp_v;
			size[ulp_v] = size[ulp_v] + size[ulp_u];
		} else {
			parent[ulp_v] = ulp_u;
			size[ulp_u] = size[ulp_u] + size[ulp_v];
		}
	}

	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet(7);
		ds.unionBySize(1, 2);
		ds.unionBySize(2, 3);
		ds.unionBySize(4, 5);
		ds.unionBySize(6, 7);
		ds.unionBySize(5, 6);

		// if 3 and 7 same or not
		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");

		ds.unionByRank(3, 7);
		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");
	}
}