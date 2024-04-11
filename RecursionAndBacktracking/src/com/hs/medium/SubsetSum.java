package com.hs.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// finds out all the subset sums in increasing order
public class SubsetSum {
	public List<Integer> subsetSums(int[] nums) {
		List<Integer> sumSubset = new ArrayList<>();
		backtrack(nums, 0, nums.length, 0, sumSubset);
		Collections.sort(sumSubset);
		return sumSubset;
	}

	private void backtrack(int[] nums, int i, int n, int sum, List<Integer> sumSubset) {
		if (i == n) {
			sumSubset.add(sum);
			return;
		}

		// pick the element
		backtrack(nums, i + 1, n, sum + nums[i], sumSubset);

		// Do-not pick the element
		backtrack(nums, i + 1, n, sum, sumSubset);
	}

	public static void main(String[] args) {
		SubsetSum obj = new SubsetSum();
		int[] nums = { 3, 1, 2 };
		List<Integer> result = obj.subsetSums(nums);
		System.out.println(result);
	}
}
