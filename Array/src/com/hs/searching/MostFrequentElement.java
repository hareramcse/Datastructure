package com.hs.searching;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class MostFrequentElement {

	static int mostFrequent(int arr[], int n) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int key = arr[i];
			if (map.containsKey(key)) {
				int count = map.get(key);
				map.put(key, count + 1);
			} else {
				map.put(key, 1);
			}
		}

		// find max frequency.
		int max_count = 0, res = -1;

		for (Entry<Integer, Integer> val : map.entrySet()) {
			if (max_count < val.getValue()) {
				res = val.getKey();
				max_count = val.getValue();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 1, 3, 2, 1 };
		int n = arr.length;
		System.out.println(mostFrequent(arr, n));
	}
}