package com.hs.imp;

import java.util.Stack;

public class DeleteMidElementInStack {
	public void midDelete(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;

		int k = (stack.size() / 2) + 1;
		solve(stack, k);
	}

	private void solve(Stack<Integer> stack, int k) {
		if (k == 1) {
			stack.pop();
			return;
		}
		Integer x = stack.pop();
		solve(stack, k-1);
		stack.push(x);
	}

	public static void main(String[] args) {
		DeleteMidElementInStack sortStack = new DeleteMidElementInStack();
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(4);
		s.push(8);
		s.push(3);
		s.push(2);
		sortStack.midDelete(s);
		for (int x : s) {
			System.out.println(x);
		}
	}
}