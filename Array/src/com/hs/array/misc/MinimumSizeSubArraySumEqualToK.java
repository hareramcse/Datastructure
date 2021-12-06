package com.hs.array.misc;

public class MinimumSizeSubArraySumEqualToK {
	private int minSubArrayLength(int[] arr, int k) {
		int start = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		// Move end pointer
		for (int end = 0; end < arr.length; end++) {
			// Add value to the sum variable
			sum = sum + arr[end];
			// while sum is greater than the value of k
			while (sum >= k && start <= end) {
				// Keep track of minLength
				minLength = Math.min(minLength, (end - start) + 1);
				// Subtract the value from sum variable and move start pointer
				sum = sum - arr[start];
				start++;
			}
		}
		return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
	}

	public static void main(String[] args) {
		MinimumSizeSubArraySumEqualToK array = new MinimumSizeSubArraySumEqualToK();
		int[] arr = { 7, 2, 1, 1, 6, 5 };
		int k = 11;
		int length = array.minSubArrayLength(arr, k);
		System.out.println(length);
	}
}