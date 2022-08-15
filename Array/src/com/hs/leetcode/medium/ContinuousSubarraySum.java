package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) {
				sum = sum % k;
			}
			if (map.containsKey(sum)) {
				int currLen = i - map.get(sum);
				if (currLen >= 2)
					return true;
			} else {
				map.put(sum, i);
			}
		}
		return false;
	}
}