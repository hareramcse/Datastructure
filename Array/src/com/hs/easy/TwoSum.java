package com.hs.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int remaining = target - nums[i];
			if (map.containsKey(remaining)) {
				int firstIndex = map.get(remaining);
				return new int[] { firstIndex, i };
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = obj.twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}
}