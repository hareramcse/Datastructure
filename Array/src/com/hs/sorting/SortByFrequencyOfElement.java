package com.hs.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SortComparator implements Comparator<Integer> {
	private final Map<Integer, Integer> freqMap;

	// Assign the specified map
	SortComparator(Map<Integer, Integer> tFreqMap) {
		this.freqMap = tFreqMap;
	}

	// Compare the values
	@Override
	public int compare(Integer k1, Integer k2) {

		// Compare value by frequency
		int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

		// Compare value if frequency is equal
		int valueCompare = k1.compareTo(k2);

		// If frequency is equal, then just compare by value, otherwise -
		// compare by the frequency.
		if (freqCompare == 0)
			return valueCompare;
		else
			return freqCompare;
	}
}

public class SortByFrequencyOfElement {

	public static void main(String[] args) {

		// Declare and Initialize an array
		int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> outputArray = new ArrayList<>();

		// Assign elements and their count in the list and map
		for (int current : array) {
			int count = map.getOrDefault(current, 0);
			map.put(current, count + 1);
			outputArray.add(current);
		}

		// Compare the map by value
		SortComparator comparator = new SortComparator(map);

		// Sort the map using Collections CLass
		Collections.sort(outputArray, comparator);

		// Final Output
		for (Integer i : outputArray) {
			System.out.print(i + " ");
		}
	}
}