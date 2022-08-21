package com.hs.greedy;

import java.util.ArrayList;
import java.util.List;

public class KCenterProblem {

	public void selectKcities(int n, int weights[][], int k) {
		int[] dist = new int[n];
		List<Integer> centers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// Index of city having the maximum distance to it's closest center
		int max = 0;
		for (int i = 0; i < k; i++) {
			centers.add(max);
			for (int j = 0; j < n; j++) {

				// Updating the distance of the cities to their closest centers
				dist[j] = Math.min(dist[j], weights[max][j]);
			}

			// Updating the index of the city with the maximum
			// distance to it's closest center
			max = maxindex(dist, n);
		}

		// Printing the maximum distance of a city to a center that is our answer
		System.out.println(dist[max]);

		// Printing the cities that were chosen to be made centers
		for (int i = 0; i < centers.size(); i++) {
			System.out.print(centers.get(i) + " ");
		}
	}

	private int maxindex(int[] dist, int n) {
		int mi = 0;
		for (int i = 0; i < n; i++) {
			if (dist[i] > dist[mi])
				mi = i;
		}
		return mi;
	}

	public static void main(String[] args) {
		KCenterProblem obj = new KCenterProblem();
		int n = 4;
		int[][] weights = new int[][] { { 0, 4, 8, 5 }, { 4, 0, 10, 7 }, { 8, 10, 0, 9 }, { 5, 7, 9, 0 } };
		int k = 2;
		obj.selectKcities(n, weights, k);
	}
}