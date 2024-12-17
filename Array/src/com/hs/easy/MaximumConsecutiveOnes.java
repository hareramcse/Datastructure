package com.hs.easy;

public class MaximumConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int max = 0;

		for (int num : nums) {
			if (num == 1)
				count++;
			else
				count = 0;

			max = Math.max(max, count);
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumConsecutiveOnes obj = new MaximumConsecutiveOnes();
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		int result = obj.findMaxConsecutiveOnes(nums);
		System.out.println(result);
	}
}
