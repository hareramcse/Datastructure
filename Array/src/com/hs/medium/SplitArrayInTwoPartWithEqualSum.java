package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayInTwoPartWithEqualSum {
	private List<List<Integer>> printTwoParts(int arr[]) {
		int n = arr.length;
		int splitIndex = findSplitIndex(arr, n);

		if (splitIndex == -1 || splitIndex == n) {
			return null;
		}

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (splitIndex == i) {
				result.add(list);
				list = new ArrayList<>();
			}
			list.add(arr[i]);
		}
		result.add(list);
		return result;
	}

	private int findSplitIndex(int arr[], int n) {
		// traverse array element and compute sum of whole array
		int leftSum = 0;
		for (int i = 0; i < n; i++)
			leftSum += arr[i];

		// again traverse array and compute right sum and also
		// check left_sum equal to right sum or not
		int rightSum = 0;
		for (int i = n - 1; i >= 0; i--) {
			rightSum += arr[i];
			leftSum -= arr[i];

			if (rightSum == leftSum)
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		SplitArrayInTwoPartWithEqualSum array = new SplitArrayInTwoPartWithEqualSum();
		int arr[] = { 1, 2, 3, 4, 5, 5 };
		List<List<Integer>> result = array.printTwoParts(arr);
		System.out.println(result);
	}
}