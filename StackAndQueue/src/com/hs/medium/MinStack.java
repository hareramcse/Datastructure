package com.hs.medium;

import java.util.Stack;

public class MinStack {
	private Stack<int[]> stack;

	public MinStack() {
		stack = new Stack<int[]>();
	}

	public void push(int val) {
		if (stack.isEmpty()) {
			stack.push(new int[] { val, val }); // (value, minSoFar)
		} else {
			int currentMin = stack.peek()[1];
			stack.push(new int[] { val, Math.min(val, currentMin) });
		}
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek()[0];
	}

	public int getMin() {
		return stack.peek()[1];
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