package com.hs.stack.madeeasy;

import java.util.Stack;

public class MaxRectangleAreaInHistogram {

	public int maxRectangleArea(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int maxArea = 0;
		int i = 0;
		while (i < arr.length) {
			if (s.isEmpty() || arr[s.peek()] <= arr[i]) {
				s.push(i++);
			} else {
				int top = s.pop();
				maxArea = Math.max(maxArea, arr[top] * (s.isEmpty() ? i : i - s.peek() - 1));
			}
		}
		while (!s.isEmpty()) {
			int top = s.pop();
			maxArea = Math.max(maxArea, arr[top] * (s.isEmpty() ? i : i - s.peek() - 1));
		}
		return maxArea;
	}

	public static void main(String[] args) {
		MaxRectangleAreaInHistogram max = new MaxRectangleAreaInHistogram();
		int[] arr = { 3, 2, 5, 6, 1, 4, 4 };
		int maxRectangleArea = max.maxRectangleArea(arr);
		System.out.println("Max rectange area is " + maxRectangleArea);
	}
}
