package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return result;

		String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		backtrack(0, digits, key, new StringBuilder(), result);
		return result;
	}

	private void backtrack(int start, String digits, String[] key, StringBuilder sb, List<String> result) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}

		String curr = key[digits.charAt(start) - '0'];
		for (int i = 0; i < curr.length(); i++) {
			sb.append(curr.charAt(i));
			backtrack(start + 1, digits, key, sb, result);
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