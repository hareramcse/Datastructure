package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return result;

		String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		backtrack(result, new StringBuilder(), key, digits, 0);
		return result;
	}

	private void backtrack(List<String> result, StringBuilder sb, String[] key, String digits, int start) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}

		String curr = key[digits.charAt(start) - '0'];
		for (int i = 0; i < curr.length(); i++) {
			sb.append(curr.charAt(i));
			backtrack(result, sb, key, digits, start + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		LetterCombinationsPhoneNumber obj = new LetterCombinationsPhoneNumber();
		String digits = "23";
		List<String> result = obj.letterCombinations(digits);
		System.out.println(result);
	}
}