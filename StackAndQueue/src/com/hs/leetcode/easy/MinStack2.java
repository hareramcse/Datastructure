package com.hs.leetcode.easy;

import java.util.Stack;

public class MinStack2 {
	int minEle;
	Stack<Integer> stack = new Stack<Integer>();

	// push element x into the stack
	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
			minEle = x;
			return;
		} else if (x < minEle) {
			stack.push((2 * x) - minEle);
			minEle = x;
		} else {
			stack.push(x);
		}
	}

	// returns poped element from stack
	public int pop() {
		if (stack.isEmpty())
			return -1;
		else if (minEle > stack.peek()) {
			int min = minEle;
			minEle = 2 * minEle - stack.pop();
			return min;
		} else
			return stack.pop();
	}

	// returns min element from stack
	public int getMin() {
		if (stack.isEmpty())
			return -1;

		return minEle;
	}

	public static void main(String[] args) {
		MinStack2 stack = new MinStack2();
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