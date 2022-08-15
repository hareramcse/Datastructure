package com.hs.leetcode.medium;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);

		int ans = 0;
		long sum = 0;
		int i = 0, j = 0;
		while (j < nums.length) {
			sum += nums[j];
			while (sum + k < (long) nums[j] * (j - i + 1)) {
				sum -= nums[i];
				i++;
			}
			ans = Math.max(ans, j - i + 1);
			j++;
		}
		return ans;
	}
}
