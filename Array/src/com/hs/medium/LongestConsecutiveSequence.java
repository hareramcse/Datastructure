package com.hs.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], true);
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] - 1)) {
				map.put(nums[i], false);
			}
		}

		int max = 0;
		for (Integer key : map.keySet()) {
			if (map.get(key) == true) {
				int len = findLength(map, key);
				max = Math.max(max, len);
			}
		}
		return max;
	}

	private int findLength(Map<Integer, Boolean> map, int key) {
		int ans = 0;
		while (map.containsKey(key)) {
			ans++;
			key++;
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int result = obj.longestConsecutive(nums);
		System.out.println(result);
	}
}