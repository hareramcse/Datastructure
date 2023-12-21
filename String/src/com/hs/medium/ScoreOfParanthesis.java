package com.hs.medium;

public class ScoreOfParanthesis {
	public int scoreOfParentheses(String s) {
		int score = 0;
		int depth = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				depth++;
			} else {
				depth--;
			}

			if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
				// Whenever you meet a () pair, you multiply 1 by all the 2 outside of it, and
				// accumulate the result
				score += Math.pow(2, depth);
			}
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