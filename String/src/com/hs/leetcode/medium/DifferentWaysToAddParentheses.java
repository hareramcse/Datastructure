package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String expression) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '-' || ch == '+' || ch == '*') {
				String a = expression.substring(0, i);
				String b = expression.substring(i + 1);
				List<Integer> a1 = diffWaysToCompute(a);
				List<Integer> b1 = diffWaysToCompute(b);
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
		if (res.size() == 0)
			res.add(Integer.valueOf(expression));
		return res;
	}

	public static void main(String[] args) {
		DifferentWaysToAddParentheses obj = new DifferentWaysToAddParentheses();
		String expression = "2*3-4*5";
		List<Integer> result = obj.diffWaysToCompute(expression);
		System.out.println(result);
	}
}