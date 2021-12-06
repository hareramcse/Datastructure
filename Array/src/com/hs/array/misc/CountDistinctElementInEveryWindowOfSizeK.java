package com.hs.array.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDistinctElementInEveryWindowOfSizeK {
	private List<Integer> distinctElements(int[] arr, int k) {
		List<Integer> result = new ArrayList<>();
		// Declared HashMap
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		/*
		 * Create a first window and put all the element and it's count of this window
		 * in a HashMap.
		 */
		for (int j = 0; j < k; j++) {
			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
		}
		result.add(map.size());
		for (int j = 1; j <= n - k; j++) {
			int removeElem = arr[j - 1];
			int addElem = arr[j + k - 1];
			// Remove element from map
			removeElemFromMap(map, removeElem);
			// Add element from map
			map.put(addElem, map.getOrDefault(addElem, 0) + 1);
			result.add(map.size());
		}
		return result;
	}

	private void removeElemFromMap(Map<Integer, Integer> elemCountMap, int elem) {
		Integer count = elemCountMap.get(elem);
		if (count != null && count > 1) {
			elemCountMap.put(elem, count - 1);
		} else {
			elemCountMap.remove(elem);
		}
	}

	public static void main(String[] args) {
		CountDistinctElementInEveryWindowOfSizeK array = new CountDistinctElementInEveryWindowOfSizeK();
		int[] arr = { 1, 5, 9, 3, 3, 7, 3 };
		int k = 3;
		List<Integer> result = array.distinctElements(arr, k);
		result.forEach(elem -> {
			System.out.println(elem);
		});
	}
}