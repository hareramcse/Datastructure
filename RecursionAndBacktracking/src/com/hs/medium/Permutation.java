package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public List<List<Integer>> permutation(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];

		permutationUtil(nums, visited, ans, list);
		return ans;
	}

	private void permutationUtil(int[] nums, boolean[] visited, List<List<Integer>> ans, List<Integer> list) {
		if (list.size() == nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				permutationUtil(nums, visited, ans, list);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		Permutation obj = new Permutation();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = obj.permutation(nums);
		System.out.println(result);
	}
}