package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation2ndApproach {
	public List<List<Integer>> permutation(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		permutationUtil(nums, 0, ans, new ArrayList<>());
		return ans;
	}

	private void permutationUtil(int[] nums, int index, List<List<Integer>> ans, List<Integer> list) {
		if (index == nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			swap(nums, i, index);
			permutationUtil(nums, index + 1, ans, list);
			list.remove(list.size() - 1);
			swap(nums, i, index);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		Permutation2ndApproach obj = new Permutation2ndApproach();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = obj.permutation(nums);
		System.out.println(result);
	}
}