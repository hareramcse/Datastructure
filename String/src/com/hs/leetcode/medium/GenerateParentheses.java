package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesisUtil("(", 1, 0, n, result);
		return result;
	}

	private void generateParenthesisUtil(String current, int open, int closed, int n, List<String> result) {
		if (current.length() == 2 * n) {
			result.add(current);
			return;
		}

		if (open < n) {
			generateParenthesisUtil(current + "(", open + 1, closed, n, result);
		}

		if (closed < open) {
			generateParenthesisUtil(current + ")", open, closed + 1, n, result);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses obj = new GenerateParentheses();
		List<String> result = obj.generateParenthesis(3);
		System.out.println(result);
	}
}