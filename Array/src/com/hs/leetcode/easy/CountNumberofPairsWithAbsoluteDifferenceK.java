package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofPairsWithAbsoluteDifferenceK {
	public int countKDifference(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		int ans = 0;
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			if (map.containsKey(num + k)) {
				ans += map.get(num + k);
			}

			if (map.containsKey(num - k)) {
				ans += map.get(num - k);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		CountNumberofPairsWithAbsoluteDifferenceK obj  = new CountNumberofPairsWithAbsoluteDifferenceK();
		int[] nums = {1,2,2,1};
		int k = 1;
		int result = obj.countKDifference(nums, k);
		System.out.println(result);
	}
}