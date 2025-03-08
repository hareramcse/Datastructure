package com.hs.medium;

public class CountNumberOfNiceSubarrays {
	public int numberOfSubarrays(int[] nums, int k) {
		return atMostK(nums, k) - atMostK(nums, k - 1);
	}

	private int atMostK(int[] nums, int k) {
		int count = 0, oddCount = 0;
		int i = 0, j = 0;

		while (j < nums.length) {
			if (nums[j] % 2 != 0) { // Count the current number if it's odd
				oddCount++;
			}

			while (oddCount > k) { // Shrink the window until there are at most k odd numbers
				if (nums[i] % 2 != 0) {
					oddCount--;
				}
				i++;
			}

			count += j - i + 1; // Count subarrays ending at right
			j++;
		}

		return count;
	}

	public static void main(String[] args) {
		CountNumberOfNiceSubarrays obj = new CountNumberOfNiceSubarrays();
		int[] arr = { 1, 1, 2, 1, 1 };
		int k = 3;
		int result = obj.numberOfSubarrays(arr, k);
		System.out.println(result);
	}
}