package com.hs.heap;

import java.util.PriorityQueue;

public class ConectNRopesWithMinimumCost {

	private int minCost(int arr[], int n) {
		// Create a priority queue
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		// Adding items to the pQueue
		for (int i = 0; i < n; i++) {
			minHeap.add(arr[i]);
		}

		// Initialize result
		int res = 0;

		// While size of priority queue is more than 1
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
		int size = len.length;
		System.out.println("Total cost for connecting ropes is " + array.minCost(len, size));
	}
}