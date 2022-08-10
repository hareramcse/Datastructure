package com.hs.leetcode.easy;

import java.util.Arrays;
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

	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = obj.twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}
}
