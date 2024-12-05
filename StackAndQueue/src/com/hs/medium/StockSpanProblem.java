package com.hs.medium;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
	public int[] nearestGreatestToLeft(int[] nums) {
		// Pair consist of NGL value and its index
		Stack<int[]> stack = new Stack<>();
		int n = nums.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = stack.peek()[1];
			}

			stack.push(new int[] { nums[i], i });
		}

		// once we get the index of NGL we find the count by i - res[i] for each element
		for (int i = 0; i < n; i++) {
			res[i] = i - res[i];
		}
		return res;
	}

	public static void main(String[] args) {
		StockSpanProblem stack = new StockSpanProblem();
		int[] arr = { 5, 2, 1, 6, 3, 4, 8, 7 };
		int[] res = stack.nearestGreatestToLeft(arr);
		System.out.println(Arrays.toString(res));
	}
}