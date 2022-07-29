package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// 451. Sort Characters By Frequency Leetcode Medium
public class SortCharacterByFrequency {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		// sort map by values
		Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
		maxHeap.addAll(map.keySet());

		StringBuilder result = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			char current = maxHeap.remove();
			for (int i = 0; i < map.get(current); i++) {
				result.append(current);
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		SortCharacterByFrequency obj = new SortCharacterByFrequency();
		String input = "tree";
		String frequencySort = obj.frequencySort(input);
		System.out.println(frequencySort);
	}
}