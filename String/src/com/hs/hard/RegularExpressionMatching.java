package com.hs.hard;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		return isMatchUtil(s, p, 0, 0);
	}

	private boolean isMatchUtil(String s, String p, int i, int j) {
		if (i >= s.length() && j >= p.length()) {
			return true;
		}

		if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
			if (isMatchUtil(s, p, i, j + 2)) {
				return true;
			}

			if (p.charAt(j) == '.') {
				for (int k = i; k < s.length(); k++) {
					if (isMatchUtil(s, p, k + 1, j + 2)) {
						return true;
					}
				}
			} else {
				for (int k = i; k < s.length(); k++) {
					if (s.charAt(k) == p.charAt(j)) {
						if (isMatchUtil(s, p, k + 1, j + 2)) {
							return true;
						}
					} else {
						break;
					}
				}
			}
		} else if (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
			return isMatchUtil(s, p, i + 1, j + 1);
		}

		return false;

	}

	public static void main(String[] args) {
		RegularExpressionMatching obj = new RegularExpressionMatching();
		String s = "ab";
		String p = ".*";
		boolean result = obj.isMatch(s, p);
		System.out.println(result);
	}
}