package com.hs.array.sorting;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortAnArrayAccordingToAbsoluteDifferenceWithGivenValue {

	private void sortWithAbsoluteDiff(int arr[], int value) {
		int n = arr.length;
		Map<Integer, String> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(Math.abs(arr[i] - value))) {
				String val = map.get(Math.abs(arr[i] - value));
				map.put(Math.abs(arr[i] - value), val + "," + i);
			} else {
				map.put(Math.abs(arr[i] - value), String.valueOf(i));
			}
		}

		for (Entry<Integer, String> entry : map.entrySet()) {
			String mapValue = entry.getValue();
			if (mapValue.length() == 1) {
				System.out.print(arr[Integer.parseInt(mapValue)] + " ");
			} else {
				for (int i = 0; i < mapValue.split(",").length; i++)
					System.out.print(arr[Integer.parseInt(mapValue.split(",")[i])] + " ");
			}
		}
	}

	public static void main(String[] args) {
		SortAnArrayAccordingToAbsoluteDifferenceWithGivenValue array = new SortAnArrayAccordingToAbsoluteDifferenceWithGivenValue();
		int arr[] = { 10, 5, 3, 9, 2 };
		int value = 7;
		array.sortWithAbsoluteDiff(arr, value);
	}
}
