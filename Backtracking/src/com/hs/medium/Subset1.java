package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class Subset1 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(0, nums, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(int start, int[] nums, List<Integer> list, List<List<Integer>> result) {
		result.add(new ArrayList<>(list));
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			backtrack(i + 1, nums, list, result);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subset1 obj = new Subset1();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = obj.subsets(nums);
		System.out.println(result);
	}
}
