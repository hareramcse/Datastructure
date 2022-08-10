package com.hs.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CheckForPairWithSumK {
	private List<List<Integer>> printPairs(int arr[], int sum) {
		Set<Integer> set = new HashSet<Integer>();
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			if (temp >= 0 && set.contains(temp)) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[i]);
				list.add(temp);
				ans.add(list);
			}
			set.add(arr[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		CheckForPairWithSumK array = new CheckForPairWithSumK();
		int[] arr = { 1, 4, 45, 6, 10, 8, 8 };
		int sum = 16;
		List<List<Integer>> result = array.printPairs(arr, sum);
		System.out.println(result);
	}
}