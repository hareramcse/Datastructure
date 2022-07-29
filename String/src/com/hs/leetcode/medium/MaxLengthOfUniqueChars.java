package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 1239. Maximum Length of a Concatenated String with Unique Characters Leetcode Medium
public class MaxLengthOfUniqueChars {
	public int maxLength(List<String> arr) {
		int[] result = new int[1];
		maxUnique(arr, 0, "", result);
		return result[0];
	}

	private void maxUnique(List<String> arr, int index, String current, int[] result) {
		if (index == arr.size() && uniqueCharCount(current) > result[0]) {
			result[0] = current.length();
			return;
		}
		if (index == arr.size()) {
			return;
		}
		maxUnique(arr, index + 1, current, result);
		maxUnique(arr, index + 1, current + arr.get(index), result);
	}

	private int uniqueCharCount(String s) {
		int[] counts = new int[26];
		for (char ch : s.toCharArray()) {
			if (counts[ch - 'a']++ > 0) {
				return -1;
			}
		}
		return s.length();
	}

	public static void main(String[] args) {
		MaxLengthOfUniqueChars obj = new MaxLengthOfUniqueChars();
		List<String> list = new ArrayList<>();
		list.add("cha");
		list.add("r");
		list.add("act");
		list.add("ers");
		int maxLength = obj.maxLength(list);
		System.out.println(maxLength);
	}
}