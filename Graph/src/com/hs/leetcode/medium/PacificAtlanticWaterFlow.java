package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> result = new ArrayList<>();
		if (heights == null || heights.length == 0 || heights[0].length == 0) {
			return result;
		}

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int n = heights.length;
		int m = heights[0].length;

		// Two boolean arrays to track cells reachable by Pacific and Atlantic
		boolean[][] pacific = new boolean[n][m];
		boolean[][] atlantic = new boolean[n][m];

		// Perform DFS from Pacific and Atlantic borders
		for (int i = 0; i < n; i++) {
			DFS(i, 0, heights, pacific, directions); // Pacific - left border
			DFS(i, m - 1, heights, atlantic, directions); // Atlantic - right border
		}

		for (int j = 0; j < m; j++) {
			DFS(0, j, heights, pacific, directions); // Pacific - top border
			DFS(n - 1, j, heights, atlantic, directions); // Atlantic - bottom border
		}

		// Find all cells that are reachable by both oceans
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					result.add(Arrays.asList(i, j));
				}
			}
		}

		return result;
	}

	private void DFS(int row, int col, int[][] grid, boolean[][] ocean, int[][] directions) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || ocean[row][col]) {
			return;
		}

		ocean[row][col] = true;

		for (int[] direction : directions) {
			int nRow = row + direction[0];
			int nCol = col + direction[1];

			// First check if the new cell is within bounds
			if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length) {
				// Then check if the water can flow to this cell based on elevation
				if (grid[nRow][nCol] >= grid[row][col]) {
					DFS(nRow, nCol, grid, ocean, directions);
				}
			}
		}
	}

	public static void main(String[] args) {
		PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<List<Integer>> result = obj.pacificAtlantic(heights);
		System.out.println(result);
	}
}