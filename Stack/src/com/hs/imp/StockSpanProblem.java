package com.hs.imp;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
	public int[] nearestGreatestToLeft(int[] arr) {
		// Pair consist of NGL value and its index
		Stack<Pair> st = new Stack<Pair>();
		int n = arr.length;

		// it will store the index of NGL
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			if (st.empty()) {
				res[i] = -1;
			} else if (st.size() > 0 && st.peek().element > arr[i]) {
				res[i] = st.peek().index;
			} else if (st.size() > 0 && st.peek().element <= arr[i]) {
				while (!st.empty() && st.peek().element <= arr[i]) {
					st.pop();
				}
				if (st.empty()) {
					res[i] = -1;
				} else {
					res[i] = st.peek().index;
				}
			}
			st.push(new Pair(arr[i], i));
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