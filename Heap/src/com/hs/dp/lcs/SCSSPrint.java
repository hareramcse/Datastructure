package com.hs.dp.lcs;

public class SCSSPrint {
	private String longestCommonSubsequence(String x, String y) {
		int m = x.length();
		int n = y.length();
		int matrix[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					matrix[i][j] = 0;
				else if (x.charAt(i - 1) == y.charAt(j - 1))
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				else
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
			}
		}

		String result = "";
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				result = result + x.charAt(i - 1);
				i--;
				j--;
			} else {
				if (matrix[i - 1][j] >= matrix[i][j - 1]) {
					result = result + x.charAt(i - 1);
					i--;
				} else {
					result = result + y.charAt(j - 1);
					j--;
				}
			}
		}

		while (i > 0) {
			result = result + x.charAt(i - 1);
			i--;
		}
		while (j > 0) {
			result = result + y.charAt(j - 1);
			j--;
		}
		return result;
	}

	private String reverse(String x) {
		StringBuffer sb = new StringBuffer(x);
		StringBuffer reverse = sb.reverse();
		return reverse.toString();
	}

	public static void main(String[] args) {
		SCSSPrint lcsrm = new SCSSPrint();
		String x = "abcdgh";
		String y = "abedfhr";
		String result = lcsrm.longestCommonSubsequence(x, y);
		result = lcsrm.reverse(result);
		System.out.println(result);
	}
}