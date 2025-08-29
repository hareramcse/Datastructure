package com.hs.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;

		for (int i = 0; i <= heights.length; i++) {
			// Use 0 as a sentinel value for the last iteration
			int currentHeight = (i == heights.length) ? 0 : heights[i];

			// Maintain a monotonic increasing stack
			while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				// width = rightBoundy - leftBoundry - 1 but if stack is empty while popping out
				// then left most index is -1 which comes before 0 ( hypothetically)
				// then rightBoundry = i, leftBoundry = -1 and hence width becomes i
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, height * width);
			}

			stack.push(i);
		}

		return maxArea;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram stack = new LargestRectangleInHistogram();
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		int res = stack.largestRectangleArea(arr);
		System.out.println(res);
	}
}