package com.hs.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToLeft {
	public int[] nearestGreatestToLeft(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) { // for (int i = n - 1; i >= 0; i--) its for next greater element to right
			while (!stack.isEmpty() && nums[i] >= stack.peek()) {
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
		NextGreaterElementToLeft stack = new NextGreaterElementToLeft();
		int[] res = stack.nearestGreatestToLeft(arr);
		System.out.println(Arrays.toString(res));
	}
}