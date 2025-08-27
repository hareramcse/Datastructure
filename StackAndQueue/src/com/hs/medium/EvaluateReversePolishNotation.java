package com.hs.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (token.equals("+")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.add(a + b);
			} else if (token.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.add(b - a);
			} else if (token.equals("*")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.add(a * b);
			} else if (token.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.add(b / a);
			} else {
				stack.add(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
		String[] tokens = { "4", "13", "5", "/", "+" };
		int result = obj.evalRPN(tokens);
		System.out.println(result);
	}
}
