package com.hs.imp;

import java.util.Stack;

public class SortStack {

	public void sort(Stack<Integer> stack) {
		// base case: stack is empty
		if (stack.isEmpty()) {
			return;
		}

		// remove the top element
		int top = stack.pop();

		// recur for the remaining elements in the stack
		sort(stack);

		// insert the popped element back into the sorted stack
		sortedInsert(stack, top);
	}

	private void sortedInsert(Stack<Integer> stack, int key) {
		// base case: if the stack is empty or
		// the key is greater than all elements in the stack
		if (stack.isEmpty() || key > stack.peek()) {
			stack.push(key);
			return;
		}

		// We reach here when the key is smaller than the top element

		// remove the top element
		int top = stack.pop();

		// recur for the remaining elements in the stack
		sortedInsert(stack, key);

		// insert the popped element back into the stack
		stack.push(top);
	}

	public static void main(String[] args) {
		SortStack st = new SortStack();
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(10);
		stack.add(15);
		stack.add(2);
		stack.add(13);
		stack.add(14);
		stack.add(9);
		stack.add(11);
		st.sort(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}