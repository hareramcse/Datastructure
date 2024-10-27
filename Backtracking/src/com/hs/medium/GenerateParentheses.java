package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		backTrack(result, "(", 1, 0, n);
		return result;
	}

	private void backTrack(List<String> result, String current, int open, int closed, int n) {
		if (current.length() == 2 * n) {
			result.add(current);
			return;
		}

		if (open < n) {
			backTrack(result, current + "(", open + 1, closed, n);
		}

		if (closed < open) {
			backTrack(result, current + ")", open, closed + 1, n);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses obj = new GenerateParentheses();
		List<String> result = obj.generateParenthesis(3);
		System.out.println(result);
	}
}