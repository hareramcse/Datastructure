package com.hs.leetcode.medium;

import java.util.Stack;

public class OnlineStockSpan {
	Stack<Pair> stack;

	public OnlineStockSpan() {
		stack = new Stack<>();
	}

	public int next(int price) {
		int count = 0;
		while (!stack.isEmpty() && stack.peek().first <= price) {
			count += stack.peek().second;
			stack.pop();
		}
		count++;
		stack.push(new Pair(price, count));
		return count;
	}
}
