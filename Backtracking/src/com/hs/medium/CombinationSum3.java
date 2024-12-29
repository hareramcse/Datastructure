package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(1, 9, k, n, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(int start, int end, int k, int target, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == k && target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= end; i++) {
			list.add(i);
			backtrack(i + 1, end, k, target - i, list, result);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum3 obj = new CombinationSum3();
		System.out.println(obj.combinationSum3(3, 9));
	}
}