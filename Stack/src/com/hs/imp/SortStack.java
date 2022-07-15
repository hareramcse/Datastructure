package com.hs.imp;

import java.util.Stack;

public class SortStack {

	public Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> rstk = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			while (!rstk.isEmpty() && rstk.peek() > tmp) {
				stack.push(rstk.pop());
			}
			rstk.push(tmp);
		}

		return rstk;
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
		Stack<Integer> sort = st.sort(stack);
		while (!sort.isEmpty()) {
			System.out.println(sort.pop());
		}
	}
}
