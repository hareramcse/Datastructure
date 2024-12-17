package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayInTwoPartWithEqualSum {
	public List<List<Integer>> splitArrayIntoEqualSums(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();

		int totalSum = 0;
		for (int num : arr) {
			totalSum += num;
		}

		if (totalSum % 2 != 0) {
			return result;
		}

		int targetSum = totalSum / 2;
		int runningSum = 0;

		List<Integer> firstPart = new ArrayList<>();
		List<Integer> secondPart = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			runningSum += arr[i];
			firstPart.add(arr[i]);

			if (runningSum == targetSum) {
				for (int j = i + 1; j < arr.length; j++) {
					secondPart.add(arr[j]);
				}

				result.add(new ArrayList<>(firstPart));
				result.add(new ArrayList<>(secondPart));
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SplitArrayInTwoPartWithEqualSum array = new SplitArrayInTwoPartWithEqualSum();
		int arr[] = { 1, 2, 3, 4, 5, 5 };
		List<List<Integer>> result = array.splitArrayIntoEqualSums(arr);
		System.out.println(result);
	}
}