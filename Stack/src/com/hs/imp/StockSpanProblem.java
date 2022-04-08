package com.hs.imp;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
	private int[] nearestGreatestToRight(int[] arr) {
		Stack<Pair> st = new Stack<Pair>();
		int n = arr.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			if (st.empty()) {
				res[i] = -1;
			} else if (st.size() > 0 && st.peek().first > arr[i]) {
				res[i] = st.peek().second;
			} else if (st.size() > 0 && st.peek().first <= arr[i]) {
				while (!st.empty() && st.peek().first <= arr[i]) {
					st.pop();
				}
				if (st.empty()) {
					res[i] = -1;
				} else {
					res[i] = st.peek().second;
				}
			}
			st.push(new Pair(arr[i], i));
		}

		for (int i = 0; i < n; i++) {
			res[i] = i - res[i];
		}
		return res;
	}

	public static void main(String[] args) {
		StockSpanProblem stack = new StockSpanProblem();
		int[] arr = { 5, 2, 1, 6, 3, 4, 8, 7 };
		int[] res = stack.nearestGreatestToRight(arr);
		System.out.println(Arrays.toString(res));
	}
}