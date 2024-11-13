package com.hs.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToConnectAllPoint {
	public int minCostConnectPoints(int[][] points) {
		int n = points.length;
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);

		boolean[] visited = new boolean[n];
		pq.add(new int[] { 0, 0 });

		int totalCost = 0;
		int edgesUsed = 0;

		while (edgesUsed < n) {
			int[] current = pq.poll();
			int cost = current[0];
			int pointIndex = current[1];

			if (visited[pointIndex])
				continue;

			visited[pointIndex] = true;
			totalCost += cost;
			edgesUsed++;

			// Add all edges from this point to unvisited points
			for (int i = 0; i < n; i++) {
				int nextCost = calculateDistance(points, pointIndex, i);
				pq.add(new int[] { nextCost, i });
			}
		}
		return totalCost;
	}

	private int calculateDistance(int[][] points, int i, int j) {
		return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
	}

	public static void main(String[] args) {
		MinimumCostToConnectAllPoint obj = new MinimumCostToConnectAllPoint();
		int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
		int result = obj.minCostConnectPoints(points);
		System.out.println(result);
	}
}