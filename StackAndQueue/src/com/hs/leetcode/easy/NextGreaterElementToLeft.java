package com.hs.leetcode.easy;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToLeft {
	private int[] nearestGreatestToLeft(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int n = arr.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			if (st.empty()) {
				res[i] = -1;
			} else if (st.size() > 0 && st.peek() > arr[i]) {
				res[i] = st.peek();
			} else if (st.size() > 0 && st.peek() <= arr[i]) {
				while (!st.empty() && st.peek() <= arr[i]) {
					st.pop();
				}
				if (st.empty()) {
					res[i] = -1;
				} else {
					res[i] = st.peek();
				}
			}
			st.push(arr[i]);
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