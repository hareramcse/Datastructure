package com.hs.array.arrangement;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortAnArrayAccordingToAbsoluteDifferenceWithGivenValue {

	static void sortWithAbsoluteDiff(int a[], int n, int x) {

		Map<Integer, String> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(Math.abs(a[i] - x))) {
				String val = map.get(Math.abs(a[i] - x));
				map.put(Math.abs(a[i] - x), val + "," + i);
			} else {
				map.put(Math.abs(a[i] - x), String.valueOf(i));
			}
		}

		for (Entry<Integer, String> entry : map.entrySet()) {
			String value = entry.getValue();
			if (value.length() == 1) {
				System.out.print(a[Integer.parseInt(value)] + " ");
			} else {
				for (int i = 0; i < value.split(",").length; i++)
					System.out.print(a[Integer.parseInt(value.split(",")[i])] + " ");
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
