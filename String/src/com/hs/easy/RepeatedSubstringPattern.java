package com.hs.easy;

public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		int length = s.length();
		for (int i = length / 2; i > 0; i--) {
			String substring = s.substring(0, i);
			if (length % i == 0) {
				int repeat = length / i;
				StringBuilder sb = new StringBuilder();
				while (repeat > 0) {
					sb.append(substring);
					repeat--;
				}
				if (sb.toString().equals(s))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern obj = new RepeatedSubstringPattern();
		String s = "abab";
		boolean result = obj.repeatedSubstringPattern(s);
		System.out.println(result);
	}
}