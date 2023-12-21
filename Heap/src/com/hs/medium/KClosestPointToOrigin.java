package com.hs.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointToOrigin {
	public int[][] kClosest(int[][] points, int k) {
		Queue<int[]> q = new PriorityQueue<>(
				(a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

		for (int[] point : points) {
			q.add(point);
			// remove when size increase k
			if (q.size() > k) {
				q.remove();
			}
		}
		int[][] ans = new int[k][2];
		for (int i = 0; i < k; i++) {
			int[] cur = q.poll();
			ans[i][0] = cur[0];
			ans[i][1] = cur[1];
		}
		return ans;
	}

	public static void main(String[] args) {
		KClosestPointToOrigin heap = new KClosestPointToOrigin();
		int[][] points = { { 1, 3 }, { -2, 2 } };
		int k = 1;
		points = heap.kClosest(points, k);
		System.out.println(Arrays.deepToString(points));
	}
}