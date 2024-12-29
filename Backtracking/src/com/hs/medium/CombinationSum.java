package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
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
			list.add(candidates[i]);
			backtrack(i, candidates, target - candidates[i], list, result); // not i + 1 because we can reuse same
																			// elements
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum obj = new CombinationSum();
		int[] nums = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> result = obj.combinationSum(nums, target);
		System.out.println(result);
	}
}
