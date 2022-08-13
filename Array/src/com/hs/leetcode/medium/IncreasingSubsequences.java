package com.hs.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		findSubsequencesUtil(nums, 0, new LinkedList<>(), ans);
		return ans;
	}

	private void findSubsequencesUtil(int[] nums, int s, LinkedList<Integer> path, List<List<Integer>> ans) {
		if (path.size() > 1)
			ans.add(new LinkedList<>(path));

		Set<Integer> used = new HashSet<>();
		for (int i = s; i < nums.length; ++i) {
			if (used.contains(nums[i]))
				continue;
			if (path.isEmpty() || nums[i] >= path.getLast()) {
				used.add(nums[i]);
				path.addLast(nums[i]);
				findSubsequencesUtil(nums, i + 1, path, ans);
				path.removeLast();
			}
		}
	}
}
