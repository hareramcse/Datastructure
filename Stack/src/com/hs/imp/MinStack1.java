package com.hs.imp;

import java.util.Stack;

// 155. Min Stack Leetcode
public class MinStack1 {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack1() {
        this.stack = new Stack<>();
		this.minStack = new Stack<>();
    }

	public void push(int x) {
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack1 stack = new MinStack1();
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