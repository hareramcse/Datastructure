package com.hs.leetcode.medium;

public class MaxConsecutiveOnes3 {
	public int longestOnes(int[] nums, int k) {
		int i = 0, j = 0, zeroCount = 0, ans = 0;

		while (j < nums.length) {
			if (nums[j] == 0)
				zeroCount++;

			while (zeroCount > k) {
				if (nums[i] == 0)
					zeroCount--;
				i++;
			}

			ans = Math.max(ans, j - i + 1);
			j++;
		}
		return ans;
	}
}
