package com.hs.hard;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		int[][] input = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				input[i][j] = matrix[i][j] - '0';
			}
		}

		int[] height = new int[column];
		int maxArea = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (input[i][j] == 1)
					height[j]++;
				else
					height[j] = 0;
			}
			maxArea = Math.max(maxArea, largestRectangleArea(height));
		}
		return maxArea;
	}

	private int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;

		for (int i = 0; i <= heights.length; i++) {
			// Use 0 as a sentinel value for the last iteration
			int currentHeight = (i == heights.length) ? 0 : heights[i];

			// Maintain a monotonic increasing stack
			while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, height * width);
			}

			stack.push(i);
		}

		return maxArea;
	}

	public static void main(String[] args) {
		MaximalRectangle stack = new MaximalRectangle();
		char[][] matrix = { { '0', '1', '1', '0' }, { '1', '1', '1', '1' }, { '1', '1', '1', '1' },
				{ '1', '1', '0', '0' } };
		int max = stack.maximalRectangle(matrix);
		System.out.println(max);
	}
}