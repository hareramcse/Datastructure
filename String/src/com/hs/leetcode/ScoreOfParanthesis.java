package com.hs.leetcode;

import java.util.Stack;

// 856. Score of Parentheses Leetcode Medium
public class ScoreOfParanthesis {
	public int scoreOfParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int score = 0;

		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(score);
				score = 0;
			} else {
				score = stack.pop() + Math.max(2 * score, 1);
			}
		}
		return score;
	}

	public static void main(String[] args) {
		ScoreOfParanthesis obj = new ScoreOfParanthesis();
		String input = "(())";
		int scoreOfParentheses = obj.scoreOfParentheses(input);
		System.out.println(scoreOfParentheses);
	}
}
