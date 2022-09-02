package com.hs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
	public int subarraysWithKDistinct(int[] nums, int k) {
		return subarraysWithKDistinctUtil(nums, k) - subarraysWithKDistinctUtil(nums, k - 1);
	}

	public int subarraysWithKDistinctUtil(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int j = 0;
		int i = 0;
		int ans = 0;

		while (j < nums.length) {
			map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
			while (map.size() > k) {
				map.put(nums[i], map.get(nums[i]) - 1);
				if (map.get(nums[i]) == 0) {
					map.remove(nums[i]);
				}
				i++;
			}
			// window size is nothing but no of subarrays from index 0 to index j
			ans += j - i + 1;
			j++;
		}
		return ans;
	}
}
