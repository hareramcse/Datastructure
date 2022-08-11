package com.hs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		int min = Integer.MAX_VALUE;
		int n = arr.length;

		List<List<Integer>> ans = new ArrayList<>();

		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++)
			min = Math.min(min, arr[i + 1] - arr[i]);

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] + min == arr[i + 1])
				ans.add(Arrays.asList(arr[i], arr[i + 1]));
		}
		return ans;
	}

	public static void main(String[] args) {
		MinimumAbsoluteDifference obj = new MinimumAbsoluteDifference();
		int[] arr = { 4, 2, 1, 3 };
		List<List<Integer>> result = obj.minimumAbsDifference(arr);
		System.out.println(result);
	}
}