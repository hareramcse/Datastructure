package com.hs.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
	private List<Integer> sortByFreq(int arr[]) {
		int n = arr.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(new Pair(entry.getValue(), entry.getKey()));
		}

		List<Integer> list = new ArrayList<>();
		while (maxHeap.size() > 0) {
			int frequency = (int) maxHeap.peek().key;
			int key = (int) maxHeap.peek().value;
			for (int i = 1; i <= frequency; i++) {
				list.add(key);
			}
			maxHeap.poll();
		}
		return list;
	}

	public static void main(String[] args) {
		FrequencySort heap = new FrequencySort();
		int arr[] = { 3, 1, 4, 4, 4, 5, 2, 6, 1 };
		List<Integer> list = heap.sortByFreq(arr);
		System.out.println(list);
	}
}