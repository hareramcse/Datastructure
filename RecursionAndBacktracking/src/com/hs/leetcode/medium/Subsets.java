package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		subsetsUtil(nums, 0, nums.length, ans, new ArrayList<>());
		return ans;
	}

	private void subsetsUtil(int[] nums, int i, int n, List<List<Integer>> ans, List<Integer> list) {
		if (i >= n) {
			ans.add(new ArrayList<>(list));
			return;
		}

		list.add(nums[i]);
		subsetsUtil(nums, i + 1, n, ans, list);
		list.remove(list.size() - 1);

		subsetsUtil(nums, i + 1, n, ans, list);
	}
}
