package com.hs.easy;

public class FindTheTownJudge {
	public int findJudge(int n, int[][] trust) {
		if (trust.length == 0 && n == 1)
			return 1;

		int[] count = new int[n + 1];
		for (int[] t : trust) {
			count[t[0]]--;
			count[t[1]]++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] == n - 1)
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		FindTheTownJudge obj = new FindTheTownJudge();
		int n = 3;
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		int judge = obj.findJudge(n, trust);
		System.out.println(judge);
	}
}
