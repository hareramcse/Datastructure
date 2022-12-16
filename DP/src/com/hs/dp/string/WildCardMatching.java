package com.hs.dp.string;

public class WildCardMatching {
	 boolean isAllStars(String s, int i) {

		// S1 is taken in 1-based indexing
		for (int j = 1; j <= i; j++) {
			if (s.charAt(j - 1) != '*')
				return false;
		}
		return true;
	}

	 boolean wildcardMatching(String S1, String S2) {

		int n = S1.length();
		int m = S2.length();

		boolean dp[][] = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		for (int j = 1; j <= m; j++) {
			dp[0][j] = false;
		}
		for (int i = 1; i <= n; i++) {
			dp[i][0] = isAllStars(S1, i);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
					dp[i][j] = dp[i - 1][j - 1];

				else {
					if (S1.charAt(i - 1) == '*')
						dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

					else
						dp[i][j] = false;
				}
			}
		}

		return dp[n][m];

	}

	public static void main(String[] args) {
		WildCardMatching obj = new WildCardMatching();
		String input = "xyxzzxy";
		String pattern = "x***x?";
		boolean match = obj.wildcardMatching(input, pattern);
		System.out.println(match);
	}
}