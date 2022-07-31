package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groupAnagrams = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String current : strs) {
			char[] chars = current.toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);

			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}
			map.get(sorted).add(current);
		}

		groupAnagrams.addAll(map.values());
		return groupAnagrams;
	}

	public static void main(String[] args) {
		GroupAnagrams obj = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = obj.groupAnagrams(strs);
		System.out.println(result);
	}
}