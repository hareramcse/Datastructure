package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum2Util(candidates, target, 0, candidates.length, ans, new ArrayList<>());
		return ans;
	}

	private void combinationSum2Util(int[] arr, int target, int ind, int n, List<List<Integer>> ans,
			List<Integer> list) {
		if (target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i = ind; i < n; i++) {
			if (i > ind && arr[i] == arr[i - 1])
				continue;
			if (arr[i] > target)
				break;

			list.add(arr[i]);
			combinationSum2Util(arr, target - arr[i], i + 1, n, ans, list);
			list.remove(list.size() - 1);
		}
	}
}
