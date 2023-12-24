package com.hs.easy;

public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		int i = 0;
		int j = 0;

		int max = 0;
		while (j < nums.length) {
			if (j > 0 && nums[j - 1] >= nums[j])
				i = j;
			max = Math.max(max, j - i + 1);
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		LongestContinuousIncreasingSubsequence obj = new LongestContinuousIncreasingSubsequence();
		int[] arr = { 1, 3, 5, 4, 7 };
		int result = obj.findLengthOfLCIS(arr);
		System.out.println(result);
	}
}
