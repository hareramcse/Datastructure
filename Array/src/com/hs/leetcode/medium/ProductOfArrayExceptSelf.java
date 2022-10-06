package com.hs.leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];

		product[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			product[i] = nums[i - 1] * product[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			product[i] = right * product[i]; // left * right
			right *= nums[i];
		}
		return product;
    }

	public static void main(String[] args) {
		ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
		int[] nums = { 1, 2, 3, 4 };
		int[] result = obj.productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}
}
