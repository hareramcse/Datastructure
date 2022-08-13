package com.hs.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortArraybyIncreasingFrequency {
	public static int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		Queue<Integer> minHeap = new PriorityQueue<>(
				(a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));

		minHeap.addAll(map.keySet());

		int[] res = new int[nums.length];
		int j = 0;
		while (!minHeap.isEmpty()) {
			Integer key = minHeap.poll();
			int fre = map.get(key);
			for (int i = 0; i < fre; i++) {
				res[j++] = key;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1,1,2,2,2,3 };
		int[] result = SortArraybyIncreasingFrequency.frequencySort(nums);
		System.out.println(Arrays.toString(result));
	}
}