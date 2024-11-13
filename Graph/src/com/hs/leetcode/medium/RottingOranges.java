package com.hs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int fresh = 0;
		int time = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					fresh++;
				}
			}
		}

		while (fresh > 0 && !queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();
				int row = current[0];
				int col = current[1];

				for (int[] direction : directions) {
					int dRow = row + direction[0];
					int dCol = col + direction[1];

					if (dRow >= 0 && dCol >= 0 && dRow < grid.length && dCol < grid[0].length
							&& grid[dRow][dCol] == 1) {
						grid[dRow][dCol] = 2;
						queue.add(new int[] { dRow, dCol });
						fresh--;
					}
				}
			}
			time++;
		}

		return fresh == 0 ? time : -1;
	}

	public static void main(String args[]) {
		RottingOranges obj = new RottingOranges();
		int arr[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int rotting = obj.orangesRotting(arr);
		System.out.println("Minimum Number of Minutes Required: " + rotting);
	}
}