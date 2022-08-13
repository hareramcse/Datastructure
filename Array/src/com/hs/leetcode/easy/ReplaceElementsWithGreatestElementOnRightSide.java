package com.hs.leetcode.easy;

public class ReplaceElementsWithGreatestElementOnRightSide {
	public int[] replaceElements(int[] arr) {
		int n = arr.length;
		int max_from_right = arr[n - 1];

		// greatest element for the rightmost element is always -1
		arr[n - 1] = -1;

		// Replace all other elements with the next greatest
		for (int i = n - 2; i >= 0; i--) {
			int temp = arr[i];

			// Replace current element with the next greatest
			arr[i] = max_from_right;

			// Update the greatest element, if needed
			max_from_right = Math.max(max_from_right, temp);
		}
		return arr;
	}
}