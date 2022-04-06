package com.hs.dp.mcm;

public class PalindromPartition {

	private int solve(String str, int i, int j) {
		if (i >= j || isPalindrome(str, i, j)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			int count = solve(str, i, k) + solve(str, k + 1, j) + 1;
			min = Math.min(min, count);
		}
		return min;
	}

	private boolean isPalindrome(String string, int i, int j) {
		while (i < j) {
			if (string.charAt(i) != string.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromPartition mcm = new PalindromPartition();
		String str = "ababbbabbababa";

		int i = 0;
		int j = str.length() - 1;
		int minCount = mcm.solve(str, i, j);
		System.out.println("Min cuts needed for Palindrome Partitioning is " + minCount);
	}
}