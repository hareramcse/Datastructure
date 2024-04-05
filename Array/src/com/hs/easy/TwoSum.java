package com.hs.easy;

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
}