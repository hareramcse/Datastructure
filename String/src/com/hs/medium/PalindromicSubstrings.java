package com.hs.medium;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += expand(s, i, i); 
			count += expand(s, i, i + 1);
		}
		return count;
	}

	private int expand(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		PalindromicSubstrings obj = new PalindromicSubstrings();
		String input = "aaa";
		int countSubstrings = obj.countSubstrings(input);
		System.out.println(countSubstrings);
	}
}