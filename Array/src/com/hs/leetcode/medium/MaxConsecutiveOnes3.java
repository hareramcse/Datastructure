package com.hs.leetcode.medium;

public class MaxConsecutiveOnes3 {
	public int longestOnes(int[] nums, int k) {
		int start = 0;
		int end = 0;
		int maxLen = 0;
		int flippedOnes = 0;

		while (end < nums.length) {
			if (nums[end] == 1) {
				end++;
			} else {
				if (flippedOnes < k) {
					flippedOnes++;
					end++;
				} else {
					while (flippedOnes == k) {
						if (nums[start] == 0) {
							flippedOnes--;
						}
						start++;
					}
				}
			}

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		MaxConsecutiveOnes3 obj = new MaxConsecutiveOnes3();
		int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		int result = obj.longestOnes(nums, k);
		System.out.println(result);
	}
}