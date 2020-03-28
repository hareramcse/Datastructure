package com.hs.array.searching;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class MostFrequentElement {

	private static int mostFrequent(int arr[], int n) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i]);
				map.put(arr[i], count + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		// find max frequency.
		int max_count = 0, res = -1;

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (max_count < entry.getValue()) {
				max_count = entry.getValue();
				res = entry.getKey();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 1, 3, 2, 1 };
		int n = arr.length;
		System.out.println("most frequent element is " + mostFrequent(arr, n));
	}
}