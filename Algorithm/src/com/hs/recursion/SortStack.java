package com.hs.recursion;

import java.util.Stack;

public class SortStack {
	private void print(Stack<Integer> s) {
		if (s.isEmpty())
			return;
		int temp = s.pop();
		print(s);
		insert(s, temp);
	}

	private void insert(Stack<Integer> s, int temp) {
		if (s.isEmpty() || s.peek() < temp) {
			s.push(temp);
			return;
		}
		Integer x = s.pop();
		insert(s, temp);
		s.push(x);
	}

	public static void main(String[] args) {
		SortStack sortStack = new SortStack();
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(4);
		s.push(8);
		s.push(3);
		s.push(2);
		sortStack.print(s);
		for (int x : s) {
			System.out.println(x);
		}
	}
}
