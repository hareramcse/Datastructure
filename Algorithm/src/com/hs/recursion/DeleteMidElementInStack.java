package com.hs.recursion;

import java.util.Stack;

public class DeleteMidElementInStack {
	private void midDelete(Stack<Integer> s) {
		if (s.isEmpty())
			return;

		int k = (s.size() / 2) + 1;
		solve(s, k);
	}

	private void solve(Stack<Integer> s, int k) {
		if (k == 1) {
			s.pop();
			return;
		}
		Integer x = s.peek();
		s.pop();
		solve(s, k-1);
		s.push(x);
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
