package com.hs.imp;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	private MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	private void push(int val) {
		if (stack.isEmpty()) {
			minStack.push(val);
		} else if (!minStack.isEmpty() && minStack.peek() >= val) {
			minStack.push(val);
		}
		stack.push(val);

	}

	private int pop() {
		int result = 0;
		if (stack.isEmpty()) {
			return -1;
		} else {
			result = stack.pop();
			if (result == minStack.peek()) {
				minStack.pop();
			}
			return result;
		}
	}

	private int getMin() {
		if (minStack.isEmpty()) {
			return -1;
		} else {
			return minStack.peek();
		}
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