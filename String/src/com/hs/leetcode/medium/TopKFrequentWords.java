package com.hs.leetcode.medium;

import java.util.ArrayList;
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

		Queue<String> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
		maxHeap.addAll(map.keySet());
		while (k > 0) {
			result.add(maxHeap.poll());
			k--;
		}
		return result;
	}

	public static void main(String[] args) {
		TopKFrequentWords obj = new TopKFrequentWords();
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;
		List<String> result = obj.topKFrequent(words, k);
		System.out.println(result);
	}
}