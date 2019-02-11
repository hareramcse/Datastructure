package com.hs.sorting;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortAnArrayAccordingToAbsoluteDifferenceWithGivenValue {

	static void sortWithAbsoluteDiff(int a[], int n, int value) {

		Map<Integer, String> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(Math.abs(a[i] - value))) {
				String val = map.get(Math.abs(a[i] - value));
				map.put(Math.abs(a[i] - value), val + "," + i);
			} else {
				map.put(Math.abs(a[i] - value), String.valueOf(i));
			}
		}

		for (Entry<Integer, String> entry : map.entrySet()) {
			String mapValue = entry.getValue();
			if (mapValue.length() == 1) {
				System.out.print(a[Integer.parseInt(mapValue)] + " ");
			} else {
				for (int i = 0; i < mapValue.split(",").length; i++)
					System.out.print(a[Integer.parseInt(mapValue.split(",")[i])] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 5, 3, 9, 2 };
		int value = 7;
		int n = arr.length;
		sortWithAbsoluteDiff(arr, n, value);
	}
}
