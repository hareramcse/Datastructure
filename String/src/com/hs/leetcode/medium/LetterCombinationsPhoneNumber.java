package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.isEmpty())
			return result;

		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "xyz");

		bakTrack(digits, 0, map, new StringBuilder(), result);
		return result;
	}

	private void bakTrack(String digits, int i, Map<Character, String> map, StringBuilder sb, List<String> result) {
		if (i == digits.length()) {
			result.add(sb.toString());
			return;
		}

		String curr = map.get(digits.charAt(i));
		for (int k = 0; k < curr.length(); k++) {
			sb.append(curr.charAt(k));
			bakTrack(digits, i + 1, map, sb, result);
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