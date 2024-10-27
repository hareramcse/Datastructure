package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start) {
		if (target < 0)
			return;

		if (target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1])
				continue; // skip duplicates

			list.add(candidates[i]);
			backtrack(result, list, candidates, target - candidates[i], i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum2 obj = new CombinationSum2();
		int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> result = obj.combinationSum2(nums, target);
		System.out.println(result);
	}
}
