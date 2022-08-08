package com.hs.leetcode.medium;

import java.util.Stack;

public class ScoreOfParanthesis {
	public int scoreOfParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int score = 0;
		for (char ch : s.toCharArray()) {
			int val = 0;
			if (ch == '(') {
				stack.push(0);
			} else {
				// calculate the score
				while (stack.peek() != 0) {
					val += stack.pop();
				}
				val = Math.max(2 * val, 1); // () for this it will return 1
				stack.pop();
				stack.push(val);
			}
		}

		while (!stack.isEmpty()) {
			score += stack.pop();
		}
		return score;
	}

	public static void main(String[] args) {
		ScoreOfParanthesis obj = new ScoreOfParanthesis();
		String input = "(()())()";
		int scoreOfParentheses = obj.scoreOfParentheses(input);
		System.out.println(scoreOfParentheses);
	}
}