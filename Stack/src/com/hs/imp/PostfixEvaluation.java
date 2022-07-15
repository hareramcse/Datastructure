package com.hs.imp;

import java.util.Stack;

public class PostfixEvaluation {
	public Integer expressionEvaluation(String token) {
		Stack<Integer> stack = new Stack<>();
		for (Character ch : token.toCharArray()) {
			if (ch.equals('+')) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = op1 + op2;
				stack.push(res);
			} else if (ch.equals('-')) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = op2 - op1;
				stack.push(res);
			} else if (ch.equals('*')) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = op1 * op2;
				stack.push(res);
			} else if (ch.equals('/')) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = op1 / op2;
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(String.valueOf(ch)));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		PostfixEvaluation postfixEvaluation = new PostfixEvaluation();
		String st = "123*+5-";
		int res = postfixEvaluation.expressionEvaluation(st);
		System.out.println(res);
	}
}