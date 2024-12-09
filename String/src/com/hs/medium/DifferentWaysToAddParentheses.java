package com.hs.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String expression) {
		Map<String, List<Integer>> map = new HashMap<>();
		return solve(expression, map);
	}

	private List<Integer> solve(String expression, Map<String, List<Integer>> map) {
		// If the expression is just a number, return its value as a single result
		if (expression.length() == 0
				|| !expression.contains("+") && !expression.contains("-") && !expression.contains("*")) {
			List<Integer> result = new ArrayList<>();
			result.add(Integer.parseInt(expression));
			return result;
		}

		if (map.containsKey(expression)) {
			return map.get(expression);
		}

		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '-' || ch == '+' || ch == '*') {
				String a = expression.substring(0, i);
				String b = expression.substring(i + 1);
				List<Integer> a1 = solve(a, map);
				List<Integer> b1 = solve(b, map);
				for (int x : a1) {
					for (int y : b1) {
						if (ch == '-') {
							res.add(x - y);
						} else if (ch == '+') {
							res.add(x + y);
						} else if (ch == '*') {
							res.add(x * y);
						}
					}
				}
			}
		}
		
		map.put(expression, res);
		return res;
	}

	public static void main(String[] args) {
		DifferentWaysToAddParentheses obj = new DifferentWaysToAddParentheses();
		String expression = "2*3-4*5";
		List<Integer> result = obj.diffWaysToCompute(expression);
		System.out.println(result);
	}
}