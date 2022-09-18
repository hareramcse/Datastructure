package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointToOrigin {
	public int[][] kClosest(int[][] points, int k) {
		Queue<Pair> maxHeap = new PriorityQueue<>(
				(a, b) -> ((b.value == a.value) ? (b.key - a.key) : (b.value - a.value)));
		for (int i = 0; i < points.length; i++) {
			Integer square = takeSquare(points[i]);
			maxHeap.add(new Pair(square, i));
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		int res[][] = new int[maxHeap.size()][2];
		int row = 0;
		while (!maxHeap.isEmpty()) {
			Pair pair = maxHeap.poll();
			res[row][0] = points[pair.value][0];
			res[row][1] = points[pair.value][1];
			row++;
		}
		return res;
	}

	private Integer takeSquare(int[] points) {
		return ((points[0] * points[0]) + (points[1] * points[1]));
	}

	public static void main(String[] args) {
		KClosestPointToOrigin heap = new KClosestPointToOrigin();
		int[][] points = { { 1, 3 }, { -2, 2 } };
		int k = 1;
		points = heap.kClosest(points, k);
		System.out.println(Arrays.deepToString(points));
	}
}