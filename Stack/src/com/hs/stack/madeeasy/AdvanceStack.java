package com.hs.stack.madeeasy;

import java.util.Stack;

public class AdvanceStack {
	private Stack<Integer> elementStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	private void push(int data) {
		elementStack.push(data);
		if (minStack.isEmpty() || (Integer) minStack.peek() >= data) {
			minStack.push(data);
		} else {
			minStack.push(minStack.peek());
		}
	}

	private int pop() throws Exception {
		if (elementStack.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		Integer minTop = minStack.peek();
		Integer elementTop = elementStack.peek();
		if (minTop.intValue() == elementTop.intValue()) {
			minStack.pop();
		}
		return elementStack.pop();
	}

	private int getMinimum() {
		return (int) minStack.peek();
	}

	private boolean isEmpty() {
		return elementStack.isEmpty();
	}

	public static void main(String[] args) {
		AdvanceStack stack = new AdvanceStack();
		try {
			stack.push(10);
			stack.push(20);
			stack.push(30);
			stack.pop();
			System.out.print("Stack is Empty : " + stack.isEmpty());
			System.out.print("\nMinimum element is " + stack.getMinimum());
		} catch (Exception e) {
			e.getMessage();
		}

	}
}
