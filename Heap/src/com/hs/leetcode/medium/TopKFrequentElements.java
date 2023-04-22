package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
	private int[] topKFrequent(int[] nums, int k) {
		int res[] = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
		maxHeap.addAll(map.keySet());

		for (int i = 0; i < k; i++) {
			res[i] = maxHeap.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		TopKFrequentElements sol = new TopKFrequentElements();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] topKFrequent = sol.topKFrequent(nums, k);
		System.out.println(Arrays.toString(topKFrequent));
	}
}