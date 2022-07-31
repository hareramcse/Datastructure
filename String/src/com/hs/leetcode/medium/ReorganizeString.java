package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
	public String reorganizeString(String s) {
		Map<Character, Integer> counts = new HashMap<>();
		for (char ch : s.toCharArray()) {
			counts.put(ch, counts.getOrDefault(ch, 0) + 1);
		}

		Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
		maxHeap.addAll(counts.keySet());

		StringBuilder result = new StringBuilder();
		while (maxHeap.size() > 1) {
			char current = maxHeap.remove();
			char next = maxHeap.remove();
			result.append(current);
			result.append(next);
			counts.put(current, counts.get(current) - 1);
			counts.put(next, counts.get(next) - 1);
			if (counts.get(current) > 0) {
				maxHeap.add(current);
			}
			if (counts.get(next) > 0) {
				maxHeap.add(next);
			}
		}

		if (!maxHeap.isEmpty()) {
			char last = maxHeap.remove();
			if (counts.get(last) > 1) {
				return "";
			}
			result.append(last);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		ReorganizeString obj = new ReorganizeString();
		String s = "aab";
		String result = obj.reorganizeString(s);
		System.out.println(result);
	}
}