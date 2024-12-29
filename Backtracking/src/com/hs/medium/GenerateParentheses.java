package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		backTrack(1, 0, n, "(", result);
		return result;
	}

	private void backTrack(int open, int close, int n, String current, List<String> result) {
		if (current.length() == 2 * n) {
			result.add(current);
			return;
		}

		if (open < n) {
			backTrack(open + 1, close, n, current + "(", result);
		}

		if (close < open) {
			backTrack(open, close + 1, n, current + ")", result);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses obj = new GenerateParentheses();
		List<String> result = obj.generateParenthesis(3);
		System.out.println(result);
	}
}