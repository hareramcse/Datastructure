package com.hs.imp;

import java.util.Stack;

// 85. Maximal Rectangle Leetcode
public class MaxRectangleAreaInBinaryMatrix {

	public int maxBianryHistrogram(char[][] input) {
		int row = input.length;
		int column = input[0].length;
		int[][] matrix = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix[i][j] = input[i][j] - '0';
			}
		}

		int result = maxHistogram(matrix[0]);
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == 1)
					matrix[i][j] += matrix[i - 1][j];
			}
			result = Math.max(result, maxHistogram(matrix[i]));
		}
		return result;
	}

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
			int count = width[i] * input[i];
			if (count > max) {
				max = count;
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
		MaxRectangleAreaInBinaryMatrix stack = new MaxRectangleAreaInBinaryMatrix();
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		int max = stack.maxBianryHistrogram(matrix);
		System.out.println(max);
	}
}