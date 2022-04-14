package com.hs.heap;

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

		Queue<Pair> minHeap = new PriorityQueue<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(new Pair(entry.getValue(), entry.getKey()));
		}

		int[] res = new int[nums.length];
		int j = 0;
		while (!minHeap.isEmpty()) {
			Pair pair = minHeap.poll();
			for (int i = 0; i < pair.key; i++) {
				res[j++] = pair.value;
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