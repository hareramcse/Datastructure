package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(0, candidates, target, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(int start, int[] candidates, int target, List<Integer> list, List<List<Integer>> result) {
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
			backtrack(i + 1, candidates, target - candidates[i], list, result);
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
