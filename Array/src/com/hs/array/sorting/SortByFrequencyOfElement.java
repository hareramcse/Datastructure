package com.hs.array.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequencyOfElement {

	private void sortByFrequency(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> outputArray = new ArrayList<>();

		// Assign elements and their count in the list and map
		for (int i : arr) {
			int count = map.getOrDefault(i, 0);
			map.put(i, count + 1);
			outputArray.add(i);
		}

		// Sort the map using Collections CLass
		Collections.sort(outputArray, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				// Compare value by frequency
				int freqCompare = map.get(i2).compareTo(map.get(i1));

				// Compare value if frequency is equal
				int valueCompare = i1.compareTo(i2);

				// If frequency is equal, then just compare by value, otherwise -
				// compare by the frequency.
				if (freqCompare == 0)
					return valueCompare;
				else
					return freqCompare;
			}

		});

		// Final Output
		for (Integer i : outputArray) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		SortByFrequencyOfElement array = new SortByFrequencyOfElement();
		int[] arr = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
		array.sortByFrequency(arr);
	}
}