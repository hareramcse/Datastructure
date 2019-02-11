package com.hs.searching;

import java.util.HashMap;
import java.util.Map;

class CountPairsWithGivenSum {

	// Returns number of pairs in arr[0..n-1] with sum equal to 'sum'
	static int getPairsCount(int[] arr, int n, int sum) {
		Map<Integer, Integer> map = new HashMap<>();

		// Store counts of all elements in map
		for (int i = 0; i < n; i++) {

			if (map.containsKey(arr[i])) {
				Integer count = map.get(arr[i]);
				map.put(arr[i], count + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		int twice_count = 0;

		// iterate through each element and increment the
		// count (Notice that every pair is counted twice)
		for (int i = 0; i < n; i++) {
			if (map.get(sum - arr[i]) != null)
				twice_count += map.get(sum - arr[i]);

			// if (arr[i], arr[i]) pair satisfies the condition,
			// then we need to ensure that the count is
			// decreased by one such that the (arr[i], arr[i])
			// pair is not considered
			if (sum - arr[i] == arr[i])
				twice_count--;
		}

		// return the half of twice_count
		return twice_count / 2;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 5, 7, -1, 5 };
		int sum = 6;
		System.out.println("Count of pairs is " + getPairsCount(arr, arr.length, sum));
	}
}