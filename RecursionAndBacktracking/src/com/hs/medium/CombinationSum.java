package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<>(), nums, target, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			result.add(new ArrayList<>(list));
		else {
			for (int i = start; i < nums.length; i++) {
				list.add(nums[i]);
				backtrack(result, list, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSum obj = new CombinationSum();
		int[] nums = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> result = obj.combinationSum(nums, target);
		System.out.println(result);
	}
}
