package com.hs.leetcode.easy;

public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int low = 0;
		int high = letters.length - 1;
		char res = letters[0];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == letters[mid]) {
				low = mid + 1;
			} else if (target > letters[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
				res = letters[mid];
			}
		}
		return res;
	}
}
