package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		Queue<String> maxHeap = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				Integer fre1 = map.get(a);
				Integer fre2 = map.get(b);
				if (fre1 == fre2)
					return b.compareTo(a);
				return fre1 - fre2;
			}
		});
		for (String key : map.keySet()) {
			maxHeap.add(key);
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		while (!maxHeap.isEmpty()) {
			result.add(maxHeap.poll());
		}
		
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		TopKFrequentWords obj = new TopKFrequentWords();
		String[] words = { "i","love","leetcode","i","love","coding" };
		int k = 2;
		List<String> result = obj.topKFrequent(words, k);
		System.out.println(result);
	}
}