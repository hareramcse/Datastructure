package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			if (map.get(num) > nums.length / 2)
				return num;
		}
		return -1;
	}

	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int result = obj.majorityElement(nums);
		System.out.println(result);
	}
}