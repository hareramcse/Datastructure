package com.hs.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Leetcode MEDIUM
public class KMostFrequentElement {

	private int[] topKFrequent(int[] nums, int k) {
		int res[] = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		Queue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(new Pair(entry.getValue(), entry.getKey()));
		}

		for (int i = 0; i < k; i++) {
			Pair pair = maxHeap.poll();
			res[i] = pair.value;
		}
		return res;
	}

	public static void main(String[] args) {
		KMostFrequentElement sol = new KMostFrequentElement();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] topKFrequent = sol.topKFrequent(nums, k);
		System.out.println(Arrays.toString(topKFrequent));
	}
}