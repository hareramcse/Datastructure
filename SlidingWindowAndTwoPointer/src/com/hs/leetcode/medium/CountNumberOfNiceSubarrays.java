package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
	public int numberOfSubarrays(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		int count = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] % 2 == 1 ? 1 : 0;
			map.put(count, map.getOrDefault(count, 0) + 1);
			res += map.getOrDefault(count - k, 0);
		}
		return res;
	}
}
