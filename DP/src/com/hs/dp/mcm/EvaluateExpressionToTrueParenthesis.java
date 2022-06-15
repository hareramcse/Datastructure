package com.hs.dp.mcm;

public class EvaluateExpressionToTrueParenthesis {
	private int solve(String s) {
		int i = 0, j = s.length() - 1;
		return solve(s, i, j, true);
	}

	private int solve(String str, int i, int j, boolean isTrue) {
		if (i > j)
			return 0;
		if (i == j) {
			if (isTrue) {
				if (str.charAt(i) == 'T')
					return 1;
				else
					return 0;
			} else {
				if (str.charAt(i) == 'F')
					return 1;
				else
					return 0;
			}
		}
		int ans = 0;
		for (int k = i + 1; k < j; k += 2) {
			int lt = solve(str, i, k - 1, true);
			int lf = solve(str, i, k - 1, false);
			int rt = solve(str, k + 1, j, true);
			int rf = solve(str, k + 1, j, false);
			if (str.charAt(k) == '&') {
				if (isTrue == true)
					ans = ans + lt * rt;
				else
					ans = ans + lf * rf + lf * rt + lt * rf;
			} else if (str.charAt(k) == '|') {
				if (isTrue == true)
					ans += (lt * rt) + (lt * rf) + (lf * rt);
				else
					ans += (lf * rf);
			} else if (str.charAt(k) == '^') {
				if (isTrue == true)
					ans += lt * rf + rt * lf;
				else
					ans += lt * rt + lf * rf;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		EvaluateExpressionToTrueParenthesis abcd = new EvaluateExpressionToTrueParenthesis();
		String s = "T|F&T^T";
		int count = abcd.solve(s);
		System.out.println(count);
	}
}