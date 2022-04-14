package com.hs.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConectNRopesWithMinimumCost {

	private int minCost(int[] arr) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
		}
		int res = 0;
		while (minHeap.size() > 1) {
			// Extract shortest two ropes from pq
			int first = minHeap.poll();
			int second = minHeap.poll();

			// Connect the ropes: update result and insert the new rope to pq
			res += first + second;
			minHeap.add(first + second);
		}
		return res;
	}

	public static void main(String args[]) {
		ConectNRopesWithMinimumCost array = new ConectNRopesWithMinimumCost();
		int len[] = { 4, 3, 2, 6 };
		System.out.println("Total cost for connecting ropes is " + array.minCost(len));
	}
}