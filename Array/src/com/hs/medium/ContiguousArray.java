package com.hs.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}

		return maxSubArrayLengthOfSumZero(nums, 0);
	}

	private int maxSubArrayLengthOfSumZero(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1); // to handle cases where the sub array starts at index 0

		int sum = 0;
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				int currLen = i - map.get(sum - k);
				maxLen = Math.max(maxLen, currLen);
			} else {
				map.put(sum, i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		ContiguousArray obj = new ContiguousArray();
		int[] arr = { 0, 1, 1, 0, 1, 1, 0 };
		int result = obj.findMaxLength(arr);
		System.out.println(result);
	}
}