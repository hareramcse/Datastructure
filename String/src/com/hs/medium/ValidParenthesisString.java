package com.hs.medium;

public class ValidParenthesisString {
	public boolean checkValidString(String s) {
		int minOpen = 0; // Minimum possible open parentheses count
		int maxOpen = 0; // Maximum possible open parentheses count

		for (char c : s.toCharArray()) {
			if (c == '(') {
				minOpen++; // '(' adds one possible open parenthesis
				maxOpen++; // '(' definitely adds one open parenthesis
			} else if (c == ')') {
				minOpen = Math.max(0, minOpen - 1); // ')' matches one possible '('
				maxOpen--; // ')' closes one '('
			} else if (c == '*') {
				minOpen = Math.max(0, minOpen - 1); // '*' treated as ')'
				maxOpen++; // '*' treated as '('
			}

			// If maxOpen is negative, we have more ')' than '('
			if (maxOpen < 0) {
				return false;
			}
		}

		// Check if we can balance all open parentheses
		return minOpen == 0;
	}

	public static void main(String[] args) {
		ValidParenthesisString obj = new ValidParenthesisString();
		String s = "(*))";
		boolean result = obj.checkValidString(s);
		System.out.println(result);
	}
}