package com.hs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		int maxLength = 0;
		for (int num : nums) {
			int currLen = 1;
			int left = num;
			int right = num;

			while (set.contains(left - 1)) {
				currLen++;
				set.remove(left - 1);
				left--;
			}

			while (set.contains(right + 1)) {
				currLen++;
				set.remove(right + 1);
				right++;
			}

			maxLength = Math.max(maxLength, currLen);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int result = obj.longestConsecutive(nums);
		System.out.println(result);
	}
}