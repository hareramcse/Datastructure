package com.hs.medium;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		int positiveIndex = 0;
		int negativeIndex = 1;
		for (int num : nums) {
			if (num >= 0) {
				ans[positiveIndex] = num;
				positiveIndex += 2;
			} else {
				ans[negativeIndex] = num;
				negativeIndex += 2;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		RearrangeArrayElementsBySign obj = new RearrangeArrayElementsBySign();
		int arr[] = { 3, 1, -2, -5, 2, -4 };
		int[] result = obj.rearrangeArray(arr);
		System.out.println(Arrays.toString(result));
	}
}