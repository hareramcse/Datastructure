package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSubStringSearch {

	// This function search for all permutations of pat[] in txt[]
	private List<Integer> anagramSearch(String s, String p) {
		List<Integer> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();

		// put all elements of pattern and its count
		for (int i = 0; i < p.length(); i++) {
			map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
		}

		int size = map.size();
		int i = 0, j = 0;
		while (j < s.length()) {
			// calculations
			if (map.containsKey(s.charAt(j))) {
				map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
				if (map.get(s.charAt(j)) == 0) {
					size--;
				}
			}
			if (j - i + 1 == p.length()) {
				// calculate answer
				if (size == 0) {
					list.add(i);
				}

				// before sliding the window, restore the count of ith char if its present in
				// map, which we had decremented in previous step.
				if (map.containsKey(s.charAt(i))) {
					map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
					if (map.get(s.charAt(i)) == 1)
						size++;
				}
				i++;
			}
			j++;
		}
		return list;
	}

	public static void main(String args[]) {
		AnagramSubStringSearch string = new AnagramSubStringSearch();
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> ids = string.anagramSearch(s, p);
		System.out.println(ids);
	}
}