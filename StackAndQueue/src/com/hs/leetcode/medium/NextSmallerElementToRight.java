package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementToRight {
	public int[] nearestSmallerToRight(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		int[] res = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() >= nums[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = stack.peek();
			}
			
			stack.push(nums[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 1, 6, 3, 4, 8, 7 };
		NextSmallerElementToRight stack = new NextSmallerElementToRight();
		int[] res = stack.nearestSmallerToRight(arr);
		System.out.println(Arrays.toString(res));
	}
}