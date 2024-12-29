package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(0, nums, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(int start, int[] nums, List<Integer> list, List<List<Integer>> result) {
		result.add(new ArrayList<>(list));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue; // skip duplicates

			list.add(nums[i]);
			backtrack(i + 1, nums, list, result);
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
