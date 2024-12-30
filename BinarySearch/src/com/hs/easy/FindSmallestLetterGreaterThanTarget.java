package com.hs.easy;

public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int low = 0, high = letters.length - 1;
		char result = letters[0];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == letters[mid]) {
				low = mid + 1;
			} else if (target > letters[mid]) {
				low = mid + 1;
			} else {
				result = letters[mid];
				high = mid - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FindSmallestLetterGreaterThanTarget obj = new FindSmallestLetterGreaterThanTarget();
		char[] letters = { 'c', 'f', 'j' };
		char target = 'a';
		char result = obj.nextGreatestLetter(letters, target);
		System.out.println(result);
	}
}
