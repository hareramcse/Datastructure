package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {
				// We find two numbers (nums[start] and nums[end]) such that their sum,
				// together with nums[i], equals zero
				int sum = nums[i] + nums[start] + nums[end];

				if (sum == 0) {
					result.add(List.of(nums[i], nums[start], nums[end]));

					// Skip duplicate values for start and end
					while (start < end && nums[start] == nums[start + 1])
						start++;

					while (start < end && nums[end] == nums[end - 1])
						end--;

					start++;
					end--;
				} else if (sum < 0) {
					start++;
				} else {
					end--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = obj.threeSum(nums);
		System.out.println(result);
	}
}