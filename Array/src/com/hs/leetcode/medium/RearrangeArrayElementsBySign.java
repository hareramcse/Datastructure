package com.hs.leetcode.medium;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (nums[j] < 0) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}

		int negativeNoStartingIndex = 0, positiveNoStartingIndex = i + 1;

		// Increment the negative index by 2 and positive index by 1, i.e.,
		// swap every alternate negative number with next positive number
		while (positiveNoStartingIndex < n && negativeNoStartingIndex < positiveNoStartingIndex
				&& nums[negativeNoStartingIndex] < 0) {
			int temp = nums[negativeNoStartingIndex];
			nums[negativeNoStartingIndex] = nums[positiveNoStartingIndex];
			nums[positiveNoStartingIndex] = temp;
			positiveNoStartingIndex++;
			negativeNoStartingIndex += 2;
		}
		return nums;
	}

	public static void main(String[] args) {
		RearrangeArrayElementsBySign obj = new RearrangeArrayElementsBySign();
		int arr[] = { 3, 1, -2, -5, 2, -4 };
		int[] result = obj.rearrangeArray(arr);
		System.out.println(Arrays.toString(result));
	}
}