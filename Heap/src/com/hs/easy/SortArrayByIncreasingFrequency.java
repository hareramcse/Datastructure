package com.hs.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortArrayByIncreasingFrequency {
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// If frequencies are the same, sort by value in descending order
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
		SortArrayByIncreasingFrequency heap = new SortArrayByIncreasingFrequency();
		int[] arr = { 1, 1, 2, 2, 2, 3 };
		int[] res = heap.frequencySort(arr);
		System.out.println(Arrays.toString(res));
	}
}