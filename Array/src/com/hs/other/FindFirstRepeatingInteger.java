package com.hs.other;

import java.util.HashSet;
import java.util.Set;

class FindFirstRepeatingInteger {
	private int firstRepeatingNumber(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int num : arr) {
			if (set.contains(num)) {
				return num;
			}
			set.add(num);
		}
		return -1;
	}

	public static void main(String[] args) throws java.lang.Exception {
		FindFirstRepeatingInteger obj = new FindFirstRepeatingInteger();
		int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
		int result = obj.firstRepeatingNumber(arr);
		System.out.println(result);
	}
}