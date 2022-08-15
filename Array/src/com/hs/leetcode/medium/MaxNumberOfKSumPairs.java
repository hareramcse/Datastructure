package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
	public int maxOperations(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int num : nums) {
			if (map.containsKey(k - num)) {
				int freq = map.get(k - num);
				if (freq == 1) {
					map.remove(k - num);

				} else {
					map.put(k - num, freq - 1);
				}
				count++;
			} else {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}
		return count;
	}
}
