package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						ans.add(Arrays.asList(nums[i], nums[low], nums[high]));

						while (low < high && nums[low] == nums[low + 1])
							low++;

						while (low < high && nums[high] == nums[high - 1])
							high--;

						low++;
						high--;
					} else if (nums[low] + nums[high] < sum) {
						low++;
					} else {
						high--;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = obj.threeSum(nums);
		System.out.println(result);
	}
}