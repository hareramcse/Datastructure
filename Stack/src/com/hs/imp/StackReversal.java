package com.hs.imp;

import java.util.Stack;

public class StackReversal {
	public void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int temp = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, temp);
	}

	private void insertAtBottom(Stack<Integer> stack, int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}

	private void printStackData(Stack<Integer> stack) {
		Object[] a = stack.toArray();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		StackReversal stack = new StackReversal();
		Stack<Integer> s = new Stack<Integer>();
		s.add(10);
		s.add(20);
		s.add(30);
		s.add(40);
		s.add(50);
		stack.reverseStack(s);
		stack.printStackData(s);
	}
}
