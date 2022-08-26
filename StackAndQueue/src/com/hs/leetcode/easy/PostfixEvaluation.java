package com.hs.leetcode.easy;

import java.util.Stack;

public class PostfixEvaluation {
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();

		for (String token : tokens) {
			if (isOperator(token)) {
				int op2 = Integer.parseInt(stack.pop());
				int op1 = Integer.parseInt(stack.pop());
				int ans = 0;

				if (token.equals("*")) {
					ans = op1 * op2;
				} else if (token.equals("/")) {
					ans = op1 / op2;
				} else if (token.equals("+")) {
					ans = op1 + op2;
				} else if (token.equals("-")) {
					ans = op1 - op2;
				}
				stack.push(ans + "");
			} else {
				stack.push(token);
			}
		}
		return Integer.parseInt(stack.peek());
	}

	private boolean isOperator(String el) {
		if (el.equals("*") || el.equals("+") || el.equals("-") || el.equals("/")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		PostfixEvaluation postfixEvaluation = new PostfixEvaluation();
		String[] tokens = { "2", "1", "+", "3", "*" };
		int res = postfixEvaluation.evalRPN(tokens);
		System.out.println(res);
	}
}