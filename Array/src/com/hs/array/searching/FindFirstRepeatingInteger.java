package com.hs.array.searching;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class FindFirstRepeatingInteger {

	private static Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

	// it also works
	private static void method2(int[] arr) {
		for (Integer ch : arr) {
			map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 2) {
				System.out.println(entry.getKey());
				break;
			}
		}
	}

	private static void printFirstRepeating(int arr[]) {
		// Initialize index of first repeating element
		int min = -1;

		Set<Integer> set = new HashSet<>();

		// Traverse the input array from right to left
		for (int i = arr.length - 1; i >= 0; i--) {
			// If element is already in hash set, update min
			if (set.contains(arr[i]))
				min = i;

			else // Else add element to hash set
				set.add(arr[i]);
		}

		// Print the result
		if (min != -1)
			System.out.println("The first repeating element is " + arr[min]);
		else
			System.out.println("There are no repeating elements");
	}

	public static void main(String[] args) throws java.lang.Exception {
		int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
		printFirstRepeating(arr);
	}
}
