package com.hs.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementToLeft {
	public int[] nearestSmallerToLeft(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
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
		NextSmallerElementToLeft stack = new NextSmallerElementToLeft();
		int[] res = stack.nearestSmallerToLeft(arr);
		System.out.println(Arrays.toString(res));
	}
}