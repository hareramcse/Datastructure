package com.hs.array.misc;

public class MaxConsectutiveOnesIfKZeroFlip {

	private int countConsecutiveOnes(int[] arr, int k) {
		int maxConsecutiveOne = 0;
		int start = 0;
		int zeroCount = 0;
		// Move end pointer/index
		for (int end = 0; end < arr.length; end++) {
			// If zero is found, then increment zeroCount
			if (arr[end] == 0) {
				zeroCount++;
			}
			/*
			 * If the value of zeroCount is greater than k, move start pointer and reset the
			 * window.
			 */
			while (zeroCount > k) {
				if (arr[start] == 0) {
					zeroCount--;
				}
				start++;
			}
			maxConsecutiveOne = Math.max(maxConsecutiveOne, end - start + 1);
		}
		return maxConsecutiveOne;
	}

	public static void main(String[] args) {
		MaxConsectutiveOnesIfKZeroFlip array = new MaxConsectutiveOnesIfKZeroFlip();
		int[] arr = { 1, 1, 0, 0, 1, 1, 1, 1, 1 };
		int k = 2; // Represent we can flip at most one 0
		int count = array.countConsecutiveOnes(arr, k);
		System.out.println("Max consecutive ones count is " + count);
	}

}