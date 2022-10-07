package com.hs.leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];

		int prefix = 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] = prefix;
			prefix *= nums[i];
		}

		int postfix = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] = postfix * res[i]; // left * right
			postfix *= nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
		int[] nums = { 2, 3, 4, 5 };
		int[] result = obj.productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}
}
