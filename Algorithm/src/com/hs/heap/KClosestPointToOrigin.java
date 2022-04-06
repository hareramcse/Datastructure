package com.hs.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
	private int[][] kClosest(int[][] arr, int K) {

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			Integer square = takeSquare(arr[i]);
			maxHeap.offer(new Pair(i, square));
			if (maxHeap.size() > K)
				maxHeap.poll();
		}

		int rst[][] = new int[maxHeap.size()][2];
		int row = 0;
		while (maxHeap.size() != 0) {
			Pair p1 = maxHeap.poll();
			rst[row][0] = arr[p1.getKey()][0];
			rst[row][1] = arr[p1.getKey()][1];
			row++;
		}
		return rst;
	}

	private Integer takeSquare(int[] arr) {
		return ((arr[0] * arr[0]) + (arr[1] * arr[1]));
	}

	public static void main(String[] args) {
		KClosestPointToOrigin heap = new KClosestPointToOrigin();
		int[][] arr = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 2 } };
		int K = 2;
		int[][] kClosest = heap.kClosest(arr, K);
		for (int i = 0; i < kClosest.length; i++) {
			for (int j = 0; j < kClosest.length; j++) {
				System.out.print(kClosest[i][j] + " ");
			}
			System.out.println();
		}
	}
}