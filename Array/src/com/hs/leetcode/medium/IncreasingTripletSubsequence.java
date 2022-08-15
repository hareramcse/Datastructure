package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
		findSubsequencesUtil(nums, 0, new ArrayList<>(), ans);
		return ans.size() != 0;
    }
    
    private void findSubsequencesUtil(int[] nums, int start, List<Integer> path, List<List<Integer>> ans) {
		if (path.size() > 2)
			ans.add(new ArrayList<>(path));

		Set<Integer> visited = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (visited.contains(nums[i]))
				continue;
			if (path.isEmpty() || nums[i] > path.get(path.size() - 1)) {
				visited.add(nums[i]);
				path.add(nums[i]);
				findSubsequencesUtil(nums, i + 1, path, ans);
				path.remove(path.size() - 1);
			}
		}
	}
}
