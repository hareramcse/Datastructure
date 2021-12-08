package com.hs.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMostFrequentElement {

	private void print_N_mostFrequentNumber(int[] arr, int n, int k) {
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

		// Put count of all the distinct elements in Map
		// with element as the key & count as the value.
		for (int i = 0; i < n; i++) {

			// Get the count for the element if already
			// present in the Map or get the default value
			// which is 0.
			mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
		}

		// Initialize an array list of array lists
		List<List<Integer>> freq = new ArrayList<List<Integer>>();
		for (int i = 0; i <= n; i++)
			freq.add(new ArrayList<Integer>());

		// Use frequencies as indexes and add corresponding
		// values to the list
		for (Map.Entry<Integer, Integer> x : mp.entrySet())
			freq.get(x.getValue()).add(x.getKey());

		// Traverse freq[] from right side.
		int count = 0;
		for (int i = n; i >= 0; i--) {
			for (int x : freq.get(i)) {
				System.out.println(x);
				count++;
				if (count == k)
					return;
			}
		}
	}

	// Driver Code to test the code.
	public static void main(String[] args) {
		KMostFrequentElement array = new KMostFrequentElement();
		int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
		int n = arr.length;
		int k = 2;
		array.print_N_mostFrequentNumber(arr, n, k);
	}

}