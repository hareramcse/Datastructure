package com.hs.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
	private Queue<Integer> minHeap;
	private int k;

	public KthLargestElementInAStream(int k, int[] nums) {
		this.k = k;
		minHeap = new PriorityQueue<>();
		for (int num : nums) {
			add(num);
		}
	}

	public int add(int val) {
		minHeap.add(val);
		if (minHeap.size() > k) {
			minHeap.poll();
		}
		return minHeap.peek();
	}
}