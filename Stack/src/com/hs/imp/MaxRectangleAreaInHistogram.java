package com.hs.imp;

import java.util.Stack;

// 84. Largest Rectangle in Histogram Leetcode
public class MaxRectangleAreaInHistogram {
	private int maxHistogram(int[] input) {
		if (input.length == 1) {
			return input[0];
		}
		int[] NSR = findNSR(input);
		int[] NSL = findNSL(input);
		int max = 0;
		int width[] = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			width[i] = NSR[i] - NSL[i] - 1;
			int area = width[i] * input[i];
			if (area > max) {
				max = area;
			}
		}
		return max;
	}

	private int[] findNSR(int[] input) {
		int right[] = new int[input.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = input.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				right[i] = input.length;
			} else if (!stack.isEmpty() && input[stack.peek()] < input[i]) {
				right[i] = stack.peek();
			} else if (!stack.isEmpty() && input[stack.peek()] >= input[i]) {
				while (!stack.isEmpty() && input[stack.peek()] >= input[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					right[i] = input.length;
				} else {
					right[i] = stack.peek();
				}
			}
			stack.push(i);
		}
		return right;
	}

	private int[] findNSL(int[] input) {
		int[] left = new int[input.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			if (stack.isEmpty()) {
				left[i] = -1;
			} else if (!stack.isEmpty() && input[stack.peek()] < input[i]) {
				left[i] = stack.peek();
			} else if (!stack.isEmpty() && input[stack.peek()] >= input[i]) {
				while (!stack.isEmpty() && input[stack.peek()] >= input[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					left[i] = -1;
				} else {
					left[i] = stack.peek();
				}
			}
			stack.push(i);
		}
		return left;
	}

	public static void main(String[] args) {
		MaxRectangleAreaInHistogram stack = new MaxRectangleAreaInHistogram();
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		int res = stack.maxHistogram(arr);
		System.out.println(res);
	}
}