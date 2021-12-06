package com.hs.array.arrangement;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithEqualNoOfZeroAndOne {

	// Returns largest sub array with equal number of 0s and 1s
	private int maxLen(int arr[]) {
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Initialize sum of elements
		int sum = 0;

		// Initialize result
		int max_len = 0;
		int ending_index = -1;

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == 0) ? -1 : 1;
		}

		// Now problem reduced find the largest sub array with sum = 0
		for (int i = 0; i < n; i++) {
			// Add current element to sum
			sum += arr[i];

			if (sum == 0) {
				max_len = i + 1;
				ending_index = i;
			}

			// If this sum is seen before, then update max_len if required
			if (map.containsKey(sum)) {
				if (max_len < i - map.get(sum)) {
					max_len = i - map.get(sum);
					ending_index = i;
				}
			} else // Else put this sum in hash table
				map.put(sum, i);
		}

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == -1) ? 0 : 1;
		}

		int end = ending_index - max_len + 1;
		System.out.println(end + " to " + ending_index);// Returns largest sub array with equal number of 0s and 1s
		return max_len;
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		LargestSubArrayWithEqualNoOfZeroAndOne array = new LargestSubArrayWithEqualNoOfZeroAndOne();
		int arr[] = { 0, 0, 0, 1, 0, 1, 1 };
		array.maxLen(arr);
	}
}