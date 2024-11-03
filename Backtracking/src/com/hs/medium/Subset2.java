package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		result.add(new ArrayList<>(list));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue; // skip duplicates

			list.add(nums[i]);
			backtrack(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subset2 obj = new Subset2();
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> result = obj.subsetsWithDup(nums);
		System.out.println(result);
	}
}
