package com.hs.dp.mcm;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrueParenthesisMemoization {

	private int solve(String s) {
		int i = 0, j = s.length() - 1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		return solve(s, i, j, true, map);
	}

	private int solve(String str, int i, int j, boolean isTrue, Map<String, Integer> map) {
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
		String key = "" + i + j + isTrue;
		if (map.containsKey(key))
			return map.get(key);

		int ans = 0;
		for (int k = i + 1; k < j; k += 2) {
			int lt = solve(str, i, k - 1, true, map);
			int lf = solve(str, i, k - 1, false, map);
			int rt = solve(str, k + 1, j, true, map);
			int rf = solve(str, k + 1, j, false, map);
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
		map.put(key, ans);
		return ans;
	}

	public static void main(String[] args) {
		EvaluateExpressionToTrueParenthesisMemoization abcd = new EvaluateExpressionToTrueParenthesisMemoization();
		String s = "T|F&T^T";
		int count = abcd.solve(s);
		System.out.println(count);
	}
}