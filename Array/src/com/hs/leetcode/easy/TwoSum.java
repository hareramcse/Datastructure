package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (map.containsKey(key)) {
				ans[0] = map.get(key);
				ans[1] = i;
			}
			map.put(nums[i], i);
		}
		return ans;
	}
}