package com.hs.array.searching;

import java.util.HashMap;
import java.util.Map;

class FindSubArraySumEqualToK {

	public static void subArraySum(int[] arr, int n, int sum) {
		// cur_sum to keep track of cumulative sum till that point
		int cur_sum = 0;
		int start = 0;
		int end = -1;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			cur_sum = cur_sum + arr[i];
			// check whether cur_sum - sum = 0, if 0 it means
			// the sub array is starting from index 0 so stop
			if (cur_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if map already has the value, means we already
			// have subarray with the sum so stop
			if (map.containsKey(cur_sum - sum)) {
				start = map.get(cur_sum - sum) + 1;
				end = i;
				break;
			}
			// if value is not present then add to map
			map.put(cur_sum, i);

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
		} else {
			System.out.println("Sum found between indexes " + start + " to " + end);
		}

	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };
		int n = arr.length;
		int sum = -10;
		subArraySum(arr, n, sum);
	}
}