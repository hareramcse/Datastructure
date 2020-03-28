package com.hs.array.searching;

import java.util.HashMap;
import java.util.Map;

class FindNumberOccursOddNumberOfTimes {

	private static int getOddOccurrence(int arr[], int n) {
		Map<Integer, Integer> map = new HashMap<>();

		// Putting all elements into the HashMap
		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i])) {
				int val = map.get(arr[i]);
				map.put(arr[i], val + 1);
			} else
				map.put(arr[i], 1);
		}

		// Checking for odd occurrence of each element present
		// in the HashMap
		for (Integer i : map.keySet()) {
			if (map.get(i) % 2 != 0)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		int n = arr.length;
		System.out.println(getOddOccurrence(arr, n));
	}
}