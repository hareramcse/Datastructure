package com.hs.medium;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		int i = 0, j = 0;

		while (j < nums.length) {
			sum = sum + nums[j];
			while (i <= j && sum >= target) {
				minLength = Math.min(minLength, j - i + 1);
				sum = sum - nums[i];
				i++;
			}
			j++;
		}
		return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int target = 7;
		int result = obj.minSubArrayLen(target, nums);
		System.out.println(result);
	}
}