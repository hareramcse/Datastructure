package com.hs.hard;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;

		// Step 1: Place each number in its correct position
		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				// Swap nums[i] with nums[nums[i] - 1]
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}

		// Step 2: Find the first missing positive
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		// If all numbers are in their correct positions, return n + 1
		return n + 1;
	}

	public static void main(String[] args) {
		FirstMissingPositive obj = new FirstMissingPositive();
		int[] nums = { 3, 4, -1, 1 };
		int result = obj.firstMissingPositive(nums);
		System.out.println(result);
	}
}
