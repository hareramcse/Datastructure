package com.hs.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortArraybyIncreasingFrequency {
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Queue<Integer> minHeap = new PriorityQueue<>(
				(a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));

		minHeap.addAll(map.keySet());

		int[] result = new int[nums.length];
		int j = 0;

		while (!minHeap.isEmpty()) {
			int key = minHeap.poll();
			int freq = map.get(key);
			for (int i = 0; i < freq; i++) {
				result[j++] = key;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SortArraybyIncreasingFrequency obj = new SortArraybyIncreasingFrequency();
		int[] nums = { 1, 1, 2, 2, 2, 3 };
		int[] result = obj.frequencySort(nums);
		System.out.println(Arrays.toString(result));
	}
}