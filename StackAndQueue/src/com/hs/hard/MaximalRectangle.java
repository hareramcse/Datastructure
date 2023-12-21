package com.hs.hard;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] input) {
		int row = input.length;
		int column = input[0].length;
		int[][] matrix = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix[i][j] = input[i][j] - '0';
			}
		}

		int result = largestRectangleArea(matrix[0]);
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == 1)
					matrix[i][j] += matrix[i - 1][j];
			}
			result = Math.max(result, largestRectangleArea(matrix[i]));
		}
		return result;
	}

	private int largestRectangleArea(int[] input) {
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
		MaximalRectangle stack = new MaximalRectangle();
		char[][] matrix = { { '0', '1', '1', '0' }, { '1', '1', '1', '1' }, { '1', '1', '1', '1' },
				{ '1', '1', '0', '0' } };
		int max = stack.maximalRectangle(matrix);
		System.out.println(max);
	}
}