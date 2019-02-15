package com.hs.array.sorting;

import java.util.HashMap;
import java.util.Map;

class MinimumNoOfSwapToSortBinaryArray {

	static int findMinSwaps(int arr[], int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = n - 1; i > 0; i--) {
			if (arr[i] == 0) {
				count++;
			} else {
				map.put(i, count);
			}
		}
		// Count total number of swaps by adding number
		// of zeroes on right side of every one.
		int sum = 0;
		for (Integer entry : map.keySet()) {
			sum = sum + map.get(entry);
		}
		return sum;
	}

	public static void main(String args[]) {
		int arr[] = { 0, 0, 1, 0, 1, 0, 1, 1, 0 };
		System.out.println(findMinSwaps(arr, arr.length));
	}
}