package com.hs.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentElement {

	private int[] topKFrequent(int[] nums, int k) {
		int res[] = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
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
		KMostFrequentElement heap = new KMostFrequentElement();
		int arr[] = { 3, 1, 4, 4, 5, 2, 2, 2, 2, 6, 1, 1 };
		int k = 2;
		int[] topKFrequent = heap.topKFrequent(arr, k);
		System.out.println(Arrays.toString(topKFrequent));
	}
}