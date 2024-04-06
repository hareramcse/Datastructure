package com.hs.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0)
			return 0;

		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		int maxLen = 1;
		for (int num : nums) {
			// if left to num does not exist it means it can be a starting point
			if (!set.contains(num - 1)) {
				int count = 1;
				
				// once we got the starting point check the consecutive numbers
				while (set.contains(num + 1)) {
					num++;
					count++;
				}
				maxLen = Math.max(maxLen, count);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int result = obj.longestConsecutive(nums);
		System.out.println(result);
	}
}