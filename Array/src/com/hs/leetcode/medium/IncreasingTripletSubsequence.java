package com.hs.leetcode.medium;

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

		// left < mid < right
		for (int num : nums) {
			if (num > mid) { // right element
				return true;
			} else if (num < mid && num > left) {
				mid = num;
			} else if (num < left) {
				left = num;
			}
		}
		return false;
	}
}
