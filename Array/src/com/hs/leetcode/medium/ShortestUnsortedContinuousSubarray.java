package com.hs.leetcode.medium;

public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int start = -1, end = -1, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (max > nums[i]) {
				if (start == -1)
					start = i - 1;
				while (start - 1 >= 0 && nums[start - 1] > nums[i])
					start--;
				end = i + 1;
			} else
				max = nums[i];
		}
		return end - start;
	}
}
