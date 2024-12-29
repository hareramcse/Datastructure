package com.hs.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];

		output[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			output[i] *= right;
			right *= nums[i];
		}

		return output;
	}

	public static void main(String[] args) {
		ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
		int[] nums = { 2, 3, 4, 5 };
		int[] result = obj.productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}
}
