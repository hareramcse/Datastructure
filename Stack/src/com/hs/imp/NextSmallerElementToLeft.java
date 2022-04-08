package com.hs.imp;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementToLeft {
	private int[] nearestGreatestToRight(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int n = arr.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			if (st.empty()) {
				res[i] = -1;
			} else if (st.size() > 0 && st.peek() < arr[i]) {
				res[i] = st.peek();
			} else if (st.size() > 0 && st.peek() >= arr[i]) {
				while (!st.empty() && st.peek() >= arr[i]) {
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
		NextSmallerElementToLeft stack = new NextSmallerElementToLeft();
		int[] res = stack.nearestGreatestToRight(arr);
		System.out.println(Arrays.toString(res));
	}
}