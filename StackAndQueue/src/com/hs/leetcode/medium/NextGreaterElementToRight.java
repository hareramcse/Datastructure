package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToRight {
	private int[] nearestGreatestToRight(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		int[] res = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			if (stack.empty()) {
				res[i] = -1;
			} else if (stack.size() > 0 && stack.peek() > arr[i]) {
				res[i] = stack.peek();
			} else if (stack.size() > 0 && stack.peek() <= arr[i]) {
				while (!stack.empty() && stack.peek() <= arr[i]) {
					stack.pop();
				}
				if (stack.empty()) {
					res[i] = -1;
				} else {
					res[i] = stack.peek();
				}
			}
			stack.push(arr[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 1, 6, 3, 4, 8, 7 };
		NextGreaterElementToRight stack = new NextGreaterElementToRight();
		int[] res = stack.nearestGreatestToRight(arr);
		System.out.println(Arrays.toString(res));
	}
}