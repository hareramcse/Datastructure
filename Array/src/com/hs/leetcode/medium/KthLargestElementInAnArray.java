package com.hs.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int num : nums) {
			pq.add(num);
		}

		int ans = 0;
		while (k > 0) {
			ans = pq.poll();
			k--;
		}
		return ans;
	}
}
