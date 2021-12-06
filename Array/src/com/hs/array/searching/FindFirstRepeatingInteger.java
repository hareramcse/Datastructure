package com.hs.array.searching;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class FindFirstRepeatingInteger {

	private Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

	private void printFirstRepeating(int[] arr) {
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

	public static void main(String[] args) throws java.lang.Exception {
		FindFirstRepeatingInteger array = new FindFirstRepeatingInteger();
		int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
		array.printFirstRepeating(arr);
	}
}
