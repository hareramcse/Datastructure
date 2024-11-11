package com.hs.graph.mst;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIsland2 {
	public List<Integer> numOfIslands(int n, int m, int[][] operators) {
		DisjointSet ds = new DisjointSet(n * m);
		int[][] visited = new int[n][m];
		int count = 0;
		List<Integer> ans = new ArrayList<>();
		int len = operators.length;
		for (int i = 0; i < len; i++) {
			int row = operators[i][0];
			int col = operators[i][1];

			if (visited[row][col] == 1) {
				ans.add(count);
				continue;
			}

			// if cell is not visited then visit it and mark the count++ later we will
			// reduce the count if it is already connected
			visited[row][col] = 1;
			count++;

			int dRow[] = { -1, 0, 1, 0 };
			int dCol[] = { 0, 1, 0, -1 };

			for (int j = 0; j < 4; j++) {
				int nRow = row + dRow[j];
				int nCol = col + dCol[j];
				if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
					if (visited[nRow][nCol] == 1) {
						int nodeNo = row * m + col;
						int adjNodeNo = nRow * m + nCol;
						if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
							count--;
							ds.unionBySize(nodeNo, adjNodeNo);
						}
					}
				}
			}
			ans.add(count);
		}
		return ans;
	}
}