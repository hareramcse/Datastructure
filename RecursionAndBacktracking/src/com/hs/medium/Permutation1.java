package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation1 {
	public List<List<Integer>> permutation(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (list.contains(nums[i]))
					continue; // element already exists, skip
				
				list.add(nums[i]);
				backtrack(result, list, nums);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Permutation1 obj = new Permutation1();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = obj.permutation(nums);
		System.out.println(result);
	}
}