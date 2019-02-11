package com.hs.searching;

import java.util.HashMap;
import java.util.Map;

class FindNumberOccursOddNumberOfTimes {

	// funtion to find the element occurring odd number of times
	static int getOddOccurrence(int arr[], int n) {
		Map<Integer, Integer> hmap = new HashMap<>();

		// Putting all elements into the HashMap
		for (int i = 0; i < n; i++) {
			if (hmap.containsKey(arr[i])) {
				int val = hmap.get(arr[i]);

				// If array element is already present then
				// increase the count of that element.
				hmap.put(arr[i], val + 1);
			} else

				// if array element is not present then put
				// element into the HashMap and initialize
				// the count to one.
				hmap.put(arr[i], 1);
		}

		// Checking for odd occurrence of each element present
		// in the HashMap
		for (Integer a : hmap.keySet()) {
			if (hmap.get(a) % 2 != 0)
				return a;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		int n = arr.length;
		System.out.println(getOddOccurrence(arr, n));
	}
}