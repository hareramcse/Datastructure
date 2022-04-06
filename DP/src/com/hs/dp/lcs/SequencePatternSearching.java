package com.hs.dp.lcs;

public class SequencePatternSearching {
	private boolean patternSearch(String x, String y) {
		int m = x.length();
		int n = y.length();

		int length = lcs(x, y, m, n);
		if (x.length() == length) {
			return true;
		} else {
			return false;
		}
	}

	private int lcs(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (x.charAt(m - 1) == y.charAt(m - 1)) {
			return 1 + lcs(x, y, m - 1, n - 1);
		} else {
			return Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
		}
	}

	public static void main(String[] args) {
		SequencePatternSearching lcsRecursive = new SequencePatternSearching();
		String x = "abcdgh";
		String y = "abedfhr";
		boolean found = lcsRecursive.patternSearch(x, y);
		System.out.println(found);
	}
}