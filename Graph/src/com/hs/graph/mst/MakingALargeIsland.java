package com.hs.graph.mst;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
	public int largestIsland(int[][] grid) {
		int n = grid.length;
		DisjointSet ds = new DisjointSet(n * n);

		// step - 1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0)
					continue;

				int dRow[] = { -1, 0, 1, 0 };
				int dCol[] = { 0, -1, 0, 1 };

				for (int k = 0; k < 4; k++) {
					int nRow = i + dRow[k];
					int nCol = j + dCol[k];
					if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1) {
						int nodeNo = i * n + j;
						int adjNodeNo = nRow * n + nCol;
						ds.unionBySize(nodeNo, adjNodeNo);
					}
				}
			}
		}

		// step 2
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					continue;

				int dRow[] = { -1, 0, 1, 0 };
				int dCol[] = { 0, -1, 0, 1 };
				Set<Integer> components = new HashSet<>();
				for (int k = 0; k < 4; k++) {
					int nRow = i + dRow[k];
					int nCol = j + dCol[k];
					if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n) {
						if (grid[nRow][nCol] == 1) {
							components.add(ds.findUPar(nRow * n + nCol));
						}
					}
				}

				int sizeTotal = 0;
				for (Integer parents : components) {
					sizeTotal += ds.size[parents];
				}
				max = Math.max(max, sizeTotal + 1);
			}
		}

		for (int i = 0; i < n * n; i++) {
			max = Math.max(max, ds.size[ds.findUPar(i)]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 1, 1, 0 }, { 1, 1, 0, 1, 1, 0 }, { 1, 1, 0, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 } };

		MakingALargeIsland obj = new MakingALargeIsland();
		int ans = obj.largestIsland(grid);
		System.out.println("The largest group of connected 1s is of size: " + ans);
	}
}