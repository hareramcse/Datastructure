package com.hs.stack;

import java.util.Stack;

public class ReverseStackWithOneStack {
	private static void stackReverse(Stack<Integer> stack) {
		if(stack.isEmpty()) return;
		int temp = stack.pop();
		stackReverse(stack);
		insertAtBottom(stack, temp);
	}
	
	private static void insertAtBottom(Stack<Integer> stack, int data) {
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		ReverseStackWithOneStack.stackReverse(stack);
		System.out.println(stack.toString());
	}
}
