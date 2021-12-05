package com.hs.array.arrangement;

import java.util.HashMap;

public class LargestSubArrayWithEqualNoOfZeroAndOne {

	// Returns largest sub array with equal number of 0s and 1s
	private int maxLen(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == 0) ? -1 : 1;
		}

		int l2 = maxLenSecondWay(arr);

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == -1) ? 0 : 1;
		}

		return l2;
	}

	private int maxLenSecondWay(int arr[]) {
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to sum
			sum += arr[i];

			if (arr[i] == 0 && max_len == 0)
				max_len = 1;

			if (sum == 0)
				max_len = i + 1;

			// Look this sum in hash table
			Integer prev_i = hM.get(sum);

			// If this sum is seen before, then update max_len
			// if required
			if (prev_i != null)
				max_len = Math.max(max_len, i - prev_i);
			else // Else put this sum in hash table
				hM.put(sum, i);
		}

		return max_len;
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		LargestSubArrayWithEqualNoOfZeroAndOne array = new LargestSubArrayWithEqualNoOfZeroAndOne();
		int arr[] = { 0, 0, 0, 1, 0, 1, 1 };
		System.out.println(array.maxLen(arr));
	}
}