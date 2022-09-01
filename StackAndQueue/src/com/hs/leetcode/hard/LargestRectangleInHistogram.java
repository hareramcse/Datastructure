package com.hs.leetcode.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] input) {
		if (input.length == 1) {
			return input[0];
		}
		int[] NSR = findNSR(input);
		int[] NSL = findNSL(input);
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			max = Math.max(max, (NSR[i] - NSL[i] + 1) * input[i]);
		}
		return max;
	}

	private int[] findNSR(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		int[] res = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				res[i] = n - 1;
			} else {
				res[i] = stack.peek() - 1;
			}

			stack.push(i);
		}
		return res;
	}

	private int[] findNSL(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				res[i] = 0;
			} else {
				res[i] = stack.peek() + 1;
			}

			stack.push(i);
		}
		return res;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram stack = new LargestRectangleInHistogram();
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		int res = stack.largestRectangleArea(arr);
		System.out.println(res);
	}
}