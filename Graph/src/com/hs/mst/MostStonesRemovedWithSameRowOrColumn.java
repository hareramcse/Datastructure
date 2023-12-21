package com.hs.mst;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {
	public int removeStones(int[][] stones) {
		int V = stones.length;

		int maxRow = 0;
		int maxCol = 0;
		for (int i = 0; i < V; i++) {
			maxRow = Math.max(maxRow, stones[i][0]);
			maxCol = Math.max(maxCol, stones[i][1]);
		}
		
		DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
		Map<Integer, Integer> stoneNodes = new HashMap<>();
		
		for (int i = 0; i < V; i++) {
			int nodeRow = stones[i][0];
			int nodeCol = stones[i][1] + maxRow + 1;
			ds.unionBySize(nodeRow, nodeCol);
			stoneNodes.put(nodeRow, 1);
			stoneNodes.put(nodeCol, 1);
		}

		int count = 0;
		for (Map.Entry<Integer, Integer> entry : stoneNodes.entrySet()) {
			if (ds.findUPar(entry.getKey()) == entry.getKey()) {
				count++;
			}
		}
		return V - count;
	}

	public static void main(String[] args) {
		MostStonesRemovedWithSameRowOrColumn obj = new MostStonesRemovedWithSameRowOrColumn();
		int[][] stones = { { 0, 0 }, { 0, 2 }, { 1, 3 }, { 3, 1 }, { 3, 2 }, { 4, 3 } };
		
		int ans = obj.removeStones(stones);
		System.out.println("The maximum number of stones we can remove is: " + ans);
	}
}