package com.hs.stack.madeeasy;

import java.util.Stack;

public class FindingSpans {
	private int[] findingSpan(int[] arr) {
		int[] spans = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		int p = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				p = -1;
			} else {
				p = stack.peek();
			}
			spans[i] = i - p;
			stack.push(i);
		}
		return spans;
	}

	public static void main(String[] args) {
		FindingSpans fs = new FindingSpans();
		int[] arr = { 6, 3, 4, 5, 2 };
		int[] res = fs.findingSpan(arr);
		for (int a : res) {
			System.out.println(a);
		}
	}
}
