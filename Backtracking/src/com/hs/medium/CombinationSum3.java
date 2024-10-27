package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), k, n, 1);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int k, int target, int start) {
		if (list.size() == k && target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}

		if (list.size() == k || target < 0) {
			return;
		}

		for (int i = start; i <= 9; i++) {
			list.add(i);
			backtrack(result, list, k, target - i, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum3 obj = new CombinationSum3();
		System.out.println(obj.combinationSum3(3, 7));
		System.out.println(obj.combinationSum3(3, 9));
	}
}