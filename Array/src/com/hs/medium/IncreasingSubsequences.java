package com.hs.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		findSubsequencesUtil(nums, 0, new ArrayList<>(), ans);
		return ans;
	}

	private void findSubsequencesUtil(int[] nums, int start, List<Integer> path, List<List<Integer>> ans) {
		if (path.size() > 1)
			ans.add(new ArrayList<>(path));

		Set<Integer> used = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (used.contains(nums[i]))
				continue;
			
			if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
				used.add(nums[i]);
				path.add(nums[i]);
				findSubsequencesUtil(nums, i + 1, path, ans);
				path.remove(path.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		IncreasingSubsequences obj = new IncreasingSubsequences();
		int[] arr = { 4, 6, 7, 7 };
		List<List<Integer>> result = obj.findSubsequences(arr);
		System.out.println(result);
	}
}