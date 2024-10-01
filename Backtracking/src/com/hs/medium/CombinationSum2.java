package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<>(), nums, target, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int remain, int start) {
		if (remain < 0)
			return;

		if (remain == 0) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue; // skip duplicates

			list.add(nums[i]);
			backtrack(result, list, nums, remain - nums[i], i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum2 obj = new CombinationSum2();
		int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> result = obj.combinationSum2(nums, target);
		System.out.println(result);
	}
}
