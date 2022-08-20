package com.hs.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FrequencySort {
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
		minHeap.addAll(map.keySet());

		int[] res = new int[nums.length];
		int j = 0;
		while (!minHeap.isEmpty()) {
			int key = minHeap.poll();
			Integer count = map.get(key);
			while (count > 0) {
				res[j++] = key;
				count--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FrequencySort heap = new FrequencySort();
		int[] arr = { 1, 1, 2, 2, 2, 3 };
		int[] res = heap.frequencySort(arr);
		System.out.println(Arrays.toString(res));
	}
}