package com.hs.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int num : nums) {
			sum += num;
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
