package com.hs.leetcode.medium;

import java.util.Stack;

public class MinStack {
	Stack<Long> stack = new Stack<Long>();
	Long minEle;

	public MinStack() {
		minEle = Long.MAX_VALUE;
	}

	public void push(int value) {
		Long val = Long.valueOf(value);
		if (stack.isEmpty()) {
			minEle = val;
			stack.push(val);
		} else {
			if (val < minEle) {
				stack.push(2 * val - minEle);
				minEle = val;
			} else {
				stack.push(val);
			}
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;

		Long val = stack.pop();
		if (val < minEle) {
			minEle = 2 * minEle - val;
		}
	}

	public int top() {
		Long val = stack.peek();
		if (val < minEle) {
			return minEle.intValue();
		}
		return val.intValue();
	}

	public int getMin() {
		return minEle.intValue();
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(34);
		stack.push(4);
		stack.push(21);
		stack.push(11);
		stack.push(0);
		stack.pop();
		stack.pop();
		System.out.println(stack.getMin());
	}
}