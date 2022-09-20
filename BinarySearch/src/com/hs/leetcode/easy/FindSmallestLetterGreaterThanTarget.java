package com.hs.leetcode.easy;

public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int n = letters.length;
		int low = 0;
		int high = n - 1;
		char res = letters[0];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == letters[mid])
				low = mid + 1;
			if (target < letters[mid]) {
				high = mid - 1;
				res = letters[mid];
			} else {
				low = mid + 1;
			}
		}
		return res;
	}
}
